package org.example.Heroes;

import org.example.Enemies.Enemy;
import org.example.Man;
import org.example.Spell;


import java.util.Random;
import java.util.Scanner;

public class Warrior extends Hero {

    public Warrior(String name,int mana,int attackMin,int attackMax) {
        super(name,mana,attackMin,attackMax);
    }

    @Override
    public void getChoice(Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1 - Attack enemy) (2 - Cast spell) (3 - get info about enemies)");
        int n = scanner.nextInt();
        if (n == 1) {
            attackEnemy(enemy);
        } else if (n == 2){
            castSpell(this);
        } else if (n == 3) {
            enemy.enemyStats();
            getChoice(enemy);
        } else {
            attackEnemy(enemy);
        }
    }
    @Override
    public void upgrade() {
        upLvl();
        setAttackMax(15 + (getLvl() * 5));
        setAttackMin(5 + (getLvl() * 2));
        setHealthMax(125 + getLvl() * 10);
        setManaMax(25 + getLvl() * 15);
    }
    @Override
    public void castSpell(Man man) {
        if (getMana() > 0) {
            int n = new Random().nextInt((getAttackMax() - getAttackMin()) + 1) + getAttackMin();
            System.out.println("Warrior health self for " + n);
            addHealth(n);
            System.out.println("Warriors " + getName() + " current health " + getHealth());
            addMana(-10);
        } else {
            System.out.println("No mana for spell");
        }
    }
    @Override
    public void attackEnemy(Man enemy) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Warrior attacks enemy for " +
                enemy.takeDamage(new Random().nextInt((getAttackMax() - getAttackMin())+1)+getAttackMin())
                + " hp");
    }

    @Override
    public void icon() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡶⢷⣾⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣯⠰⠌⡤⠺⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣷⣤⡶⣶⣴⣷⣄⢀⣴⣾⣿⣿⣶⣄⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣰⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀\n" +
                "⠀⢠⠤⣤⠀⠀⢠⣾⠛⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣭⣽⣿⣿⣿⣿⠀\n" +
                "⣰⠯⠆⣿⡀⣰⣿⣿⡷⠏⣿⣝⣿⠿⠿⠿⠿⣻⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
                "⢿⣶⡿⠉⣿⣿⣿⣿⡀⠀⢿⣿⣿⣿⠀⠀⣿⣿⡇⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⠀\n" +
                "⠀⠀⠀⠀⠈⠉⠉⠉⠉⢰⣿⣿⣿⣷⣶⣶⣿⣿⣇⠘⣿⣿⣿⣾⣾⣿⣿⣿⠏⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡏⠈⢻⣿⣿⣿⠀⠈⠻⢿⣿⣿⡿⠟⠁⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⠀⠀⢸⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⠁⠀⠀⣼⣿⣿⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⠀⠀⠘⠻⠿⠿⠿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠛⠀");
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }
}
