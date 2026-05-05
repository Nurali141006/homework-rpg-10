package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===");

        List<Hero> party = List.of(
                new Hero("Warrior", 120, 20, 15),
                new Hero("Mage", 80, 50, 25, 5, 100)
        );
        QuestLog questLog = new QuestLog();

        questLog.add(new Quest("Goblin Cave", QuestPriority.NORMAL, 120, false));
        questLog.add(new Quest("Escort Caravan", QuestPriority.LOW, 80, false));
        questLog.add(new Quest("Cursed Totem", QuestPriority.HIGH, 250, true));
        questLog.add(new Quest("Defend Village", QuestPriority.URGENT, 400, true));
        questLog.add(new Quest("Ancient Ruins", QuestPriority.HIGH, 300, false));

        GuildHall hall = new GuildHall();

        Captain captain = new Captain("Arman", hall);
        Quartermaster qm = new Quartermaster("Dias", hall);
        Scout scout = new Scout("Ayan", hall);
        Healer healer = new Healer("Dana", hall);
        Loremaster loremaster = new Loremaster("Sanzhar", hall);

        System.out.println("\n--- Mediator Demo ---");

        captain.issueOrder("orders", "Prepare for campaign!");
        scout.reportRoute("scouting", "North road is dangerous.");
        qm.requestSupplies("supplies", "Need weapons and armor.");
        healer.prepareAid("healing", "Prepare potions.");
        loremaster.explainLore("curse", "Ancient curse detected.");

       CouncilEngine engine = new CouncilEngine();
        CouncilRunResult result = engine.runCouncil(party, questLog, hall, captain);

        System.out.println("\n--- Reverse Iterator ---");
        QuestIterator reverse = questLog.reverse();
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }
        System.out.println("\n--- Reward Sorted Iterator ---");
        QuestIterator reward = questLog.rewardSorted();
        while (reward.hasNext()) {
            System.out.println(reward.next());
        }
        System.out.println("\n--- FINAL RESULT ---");
        System.out.println(result);
    }
}