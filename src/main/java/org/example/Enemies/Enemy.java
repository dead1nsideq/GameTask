package org.example.Enemies;

import org.example.Man;
import org.example.Mortal;
import org.example.Spell;

import java.util.Random;

public class Enemy extends Man implements Mortal {
    private int health;
    private String name;
    private int attackMin;
    private int attackMax;

    public Enemy(String name,int health,int minAttack,int maxAttack) {
        this.name = name;
        if (health < 0) {
            System.out.println("You can not set health to zero and less");
        } else {
            this.health = health;
        }
        this.attackMin = minAttack;
        this.attackMax = maxAttack;
    }
    public int getHealth() {
        return health;
    }

    public void introduceMessage() {
        System.out.println("There is " + getName() + " with " + getHealth() + " hp");
    }

    public void enemyStats() {
        System.out.println("Enemy " + getName() + " has " + getHealth() + " hp and " + getMana() + " mana");
    }

    public String getName() {
        return name + " " +getClass().getSimpleName();
    }
    public void icon() {
        System.out.println("");
    }
    public Enemy() {
        this.health = 100;
        this.name = "Monster";
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int takeDamage(int damage) {
        health-=damage;
        return damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int getLvl() {
        return 1;
    }

    @Override
    public int getMana() {
        return 100;
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void attackEnemy(Man enemy) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int n = new Random().nextInt(((attackMax - attackMin)+1)+attackMin);
        System.out.println(getName() + " attacks enemy for "
                + enemy.takeDamage(n) + " hp");
        if (getClass().getSimpleName().equals("Vampire")) {
            System.out.println("Vampire restore some health from hero!");
            this.setHealth(getHealth() + n/4);
        } else if (getClass().getSimpleName().equals("EvilMage")) {
            if (new Random().nextInt(100)%10 == 0) {
                Spell spell = new Spell("Fire ball", this, enemy);
                spell.spell(10, 25, 30);
            }
        }
    }

    @Override
    public void castSpell(Man enemy) {
        Spell spell = new Spell("Fire ball",this,enemy);
        spell.spell(10,50,30);
    }
}
