package org.example.Heroes;

import org.example.Enemies.Enemy;
import org.example.Man;
import org.example.Mortal;
import org.example.Spell;

import java.util.Random;
import java.util.Scanner;

public class Archer extends Hero {

    public Archer(String name, int mana,int attackMin,int attackMax) {
        super(name,mana,attackMin,attackMax);
    }

    public void getChoice(Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1 - Attack enemy) (2 - Cast spell) (3 - get info about enemies)");
        int n = scanner.nextInt();
        if (n == 1) {
            attackEnemy(enemy);
        } else if (n == 2){
            castSpell(enemy);
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
        setAttackMax(25 + (getLvl() * 6));
        setAttackMin(15 + (getLvl() * 3));
        setHealthMax(100 + getLvl() * 8);
        setManaMax(50 + getLvl() * 10);
    }

    @Override
    public void castSpell(Man enemy) {
        Spell spell = new Spell("Rain of arrows",this,enemy);
        spell.spell(25,75,25);
    }

    @Override
    public void attackEnemy(Man enemy) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Archer attacks enemy for "
                + enemy.takeDamage(new Random().nextInt((getAttackMax() - getAttackMin())+1)+
                getAttackMin()) + " hp");
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public void icon() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣾⣿⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣻⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣬⣽⣿⣟⠉⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣷⣽⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⡿⣿⣿⡆⠀⠀⣤⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢠⣴⣾⣿⣿⣿⣿⣿⣮⣅⠉⣯⠉⠉⠉⠙⣆⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠂⠛⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⣀⣻⡇⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⣿⣿⣿⣿⣿⣿⣿⣿⡷⠢⣌⡙⠉⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠈⡿⣦⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢹⣿⠇⠀⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⢿⣥⣤⣤⢞⣀⡀⠀⠀");
    }
}
