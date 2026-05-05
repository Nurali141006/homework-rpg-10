package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildHall implements GuildMediator {

    private final Map<String, List<GuildMember>> membersByTopic = new HashMap<>();
    private int lastDispatchNotificationCount;

    @Override
    public void register(GuildMember member) {
        addSubscriber("orders", member);
        addSubscriber("urgent", member);

        if (member instanceof Quartermaster) {
            addSubscriber("supplies", member);
            addSubscriber("rewards", member);
        }

        if (member instanceof Scout) {
            addSubscriber("scouting", member);
        }

        if (member instanceof Healer) {
            addSubscriber("healing", member);
        }

        if (member instanceof Captain) {
            addSubscriber("supplies", member);
            addSubscriber("scouting", member);
            addSubscriber("healing", member);
        }

        if (member instanceof Loremaster) {
            addSubscriber("lore", member);
            addSubscriber("curse", member);
            addSubscriber("history", member);
        }
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        System.out.println("\n[GuildHall] " + from.getName()
                + " sends topic '" + topic + "': " + payload);

        lastDispatchNotificationCount = 0;

        for (GuildMember member : subscribersFor(topic)) {
            if (member != from) {
                member.receive(topic, from, payload);
                lastDispatchNotificationCount++;
            }
        }
    }

    public int getLastDispatchNotificationCount() {
        return lastDispatchNotificationCount;
    }

    protected void addSubscriber(String topic, GuildMember member) {
        membersByTopic.computeIfAbsent(topic, key -> new ArrayList<>()).add(member);
    }

    protected List<GuildMember> subscribersFor(String topic) {
        return membersByTopic.getOrDefault(topic, List.of());
    }
}