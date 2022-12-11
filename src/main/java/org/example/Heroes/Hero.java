package org.example.Heroes;

import org.example.Enemies.Enemy;
import org.example.Man;
import org.example.Mortal;

public abstract class Hero extends Man implements Mortal {
    private String name;
    private int health;
    private int lvl;
    private int mana;
    private int attackMax;
    private int attackMin;
    private int healthMax;
    private int manaMax;

    public int getAttackMax() {
        return attackMax;
    }

    public int getAttackMin() {
        return attackMin;
    }


    public void getStats() {
        System.out.println(getClass().getSimpleName() + " has : " +
                "\n" + getHealth() + " health" +
                "\n" + getMana() + " mana" +
                "\n" + getAttackMin() + " min at" +
                "\n" + getAttackMax() + " max at");
        System.out.println("hero lvl - " + getLvl());
    }
    public void addHealth(int health) {
        if (getHealth() + health > healthMax) {
            this.health = healthMax;
        } else {
            this.health += health;
        }
    }

    public abstract void getChoice(Enemy enemy);

    public int getMana() {
        return mana;
    }
    public void addMana(int mana) {
        if (getMana() + mana > manaMax) {
            this.mana = manaMax;
        } else {
            this.mana += mana;
        }
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getLvl() {
        return lvl;
    }

    public void upLvl() {
        lvl++;
    }

    public void setAttackMax(int attackMax) {
        this.attackMax = attackMax;
    }

    public void setAttackMin(int attackMin) {
        this.attackMin = attackMin;
    }

    public Hero(String name, int mana, int attackMin, int attackMax) {
        this.name = name;
        health = 100;
        healthMax = 100;
        this.manaMax = mana;
        this.mana = mana;
        lvl = 1;
        this.attackMin = attackMin;
        this.attackMax = attackMax;
    }
    public abstract void upgrade();
    public String getName() {
        return name;
    }
    public void introduceMassage() {
        System.out.println("Hero name is " + getName() + ".It's class is " + getClass().getSimpleName());
    }
    @Override
    public int takeDamage(int damage) {
        health-=damage;
        return damage;
    }
    public int getHealth() {
        return health;
    }
    public abstract void icon();
}
