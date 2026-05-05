package com.narxoz.rpg.quest;

public class Quest {

    private final String title;
    private final QuestPriority priority;
    private final int rewardGold;
    private final boolean urgent;

    public Quest(String title, QuestPriority priority, int rewardGold, boolean urgent) {
        this.title = title;
        this.priority = priority;
        this.rewardGold = rewardGold;
        this.urgent = urgent;
    }

    public String getTitle() {
        return title;
    }

    public QuestPriority getPriority() {
        return priority;
    }

    public int getRewardGold() {
        return rewardGold;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public String toString() {
        return "Quest{"
                + "title='" + title + '\''
                + ", priority=" + priority
                + ", rewardGold=" + rewardGold
                + ", urgent=" + urgent
                + '}';
    }
}