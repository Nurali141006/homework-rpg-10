package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.GuildHall;
import com.narxoz.rpg.guild.GuildMediator;
import com.narxoz.rpg.guild.GuildMember;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;

import java.util.List;

public class CouncilEngine {

    public CouncilRunResult runCouncil(
            List<Hero> party,
            QuestLog questLog,
            GuildMediator hall,
            GuildMember sender
    ) {
        int questsTraversed = 0;
        int messagesRouted = 0;
        int membersNotified = 0;

        System.out.println("\n=== WAR COUNCIL START ===");

        System.out.println("\n--- Party ---");
        for (Hero hero : party) {
            System.out.println(hero);
        }

        System.out.println("\n--- Iterator: Arrival Order ---");
        QuestIterator ordered = questLog.ordered();

        while (ordered.hasNext()) {
            Quest quest = ordered.next();
            System.out.println("Planning quest: " + quest);

            questsTraversed++;

            hall.dispatch("orders", sender, "Prepare plan for: " + quest.getTitle());
            messagesRouted++;

            if (hall instanceof GuildHall guildHall) {
                membersNotified += guildHall.getLastDispatchNotificationCount();
            }
        }

        System.out.println("\n--- Iterator: HIGH+ Priority ---");
        QuestIterator highPriority = questLog.priorityAtLeast(QuestPriority.HIGH);

        while (highPriority.hasNext()) {
            Quest quest = highPriority.next();
            System.out.println("URGENT quest: " + quest);

            questsTraversed++;

            hall.dispatch("urgent", sender, "Urgent quest: " + quest.getTitle());
            messagesRouted++;

            if (hall instanceof GuildHall guildHall) {
                membersNotified += guildHall.getLastDispatchNotificationCount();
            }
        }

        System.out.println("\n=== WAR COUNCIL END ===");

        return new CouncilRunResult(questsTraversed, messagesRouted, membersNotified);
    }
}