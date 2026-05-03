package com.narxoz.rpg.combatant;

public class Hero {

    private final String name;
    private int hp;
    private final int maxHp;
    private int mana;
    private int gold;
    private final int attackPower;
    private final int defense;

    public Hero(String name, int hp, int attackPower, int defense) {
        this(name, hp, 0, attackPower, defense, 0);
    }

    public Hero(String name, int hp, int mana, int attackPower, int defense, int gold) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.gold = gold;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMana() {
        return mana;
    }

    public int getGold() {
        return gold;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void takeDamage(int amount) {
        hp = Math.max(0, hp - Math.max(0, amount));
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + Math.max(0, amount));
    }

    public void addGold(int amount) {
        gold += Math.max(0, amount);
    }

    public boolean spendGold(int amount) {
        if (amount < 0 || amount > gold) {
            return false;
        }
        gold -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Hero{"
                + "name='" + name + '\''
                + ", hp=" + hp
                + ", mana=" + mana
                + ", gold=" + gold
                + ", attackPower=" + attackPower
                + ", defense=" + defense
                + '}';
    }
}
