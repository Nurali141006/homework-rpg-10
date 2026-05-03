package com.narxoz.rpg.council;

public class CouncilRunResult {

    private final int questsTraversed;
    private final int messagesRouted;
    private final int membersNotified;

    public CouncilRunResult(int questsTraversed, int messagesRouted, int membersNotified) {
        this.questsTraversed = questsTraversed;
        this.messagesRouted = messagesRouted;
        this.membersNotified = membersNotified;
    }

    public int getQuestsTraversed() {
        return questsTraversed;
    }

    public int getMessagesRouted() {
        return messagesRouted;
    }

    public int getMembersNotified() {
        return membersNotified;
    }

    @Override
    public String toString() {
        return "CouncilRunResult{"
                + "questsTraversed=" + questsTraversed
                + ", messagesRouted=" + messagesRouted
                + ", membersNotified=" + membersNotified
                + '}';
    }
}