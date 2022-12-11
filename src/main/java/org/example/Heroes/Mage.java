package org.example.Heroes;

import org.example.Enemies.Enemy;
import org.example.Man;
import org.example.Mortal;
import org.example.Spell;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mage extends Hero{

    public Mage(String name,int mana,int attackMin,int attackMax) {
        super(name,mana,attackMin,attackMax);
    }

    @Override
    public void upgrade() {
        upLvl();
        setAttackMax(15 + (getLvl() * 5));
        setAttackMin(5 + (getLvl() * 3));
        setHealthMax(100 + getLvl() * 10);
        setManaMax(100 + getLvl() * 15);
    }

    @Override
    public void attackEnemy(Man enemy) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mage attacks enemy for " +
                enemy.takeDamage(new Random().nextInt((getAttackMax() - getAttackMin())+1)+getAttackMin()) + " hp");
    }

    @Override
    public void castSpell(Man enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1 - Fire ball) (2 - Frost arrow) (3 - lightning)");
        int n = scanner.nextInt();
        if (n == 1) {
            Spell spell = new Spell("Fire ball",this,enemy);
            spell.spell(10,50,30);
        } else if (n == 2) {
            Spell spell = new Spell("Frost arrow",this,enemy);
            spell.spell(20,40,45);
        } else if (n == 3) {
            Spell spell = new Spell("lightning",this,enemy);
            spell.spell(1,99,75);
        } else {
            Spell spell = new Spell("Fire ball",this,enemy);
            spell.spell(10,50,30);
        }
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
    public boolean isAlive() {
        return getHealth() > 0;
    }
    public void icon() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠘⣿⡅⠈⣉⢢⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠘⠿⡿⠛⠛⠛⠒⣤⣰⣿⠃⣾⣿⡎⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⢀⣰⣚⣽⣷⠖⠒⣲⣚⣋⣯⡑⠤⠿⠿⡸⠁⠀⠀⠀⠀⠀⢀⠖⠀⠀⠀⠀\n" +
                "⠀⠀⠘⠋⠁⠀⠀⢠⡎⢨⣿⣿⣿⠉⢳⡟⣿⠇⠀⠀⠀⠀⣠⣴⠿⠧⠐⠃⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢀⣟⣸⣿⢃⠋⠏⠛⡟⢿⣯⣤⣤⣤⠶⠛⠉⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣜⠉⠛⣯⣿⡿⠀⢸⡷⠎⠙⣻⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⢹⣯⣏⠀⠀⠀⠱⠲⢎⣁⣴⡶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⠤⣤⠞⠋⢉⣯⣩⣽⡅⠀⠀⢈⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠸⠛⠒⠁⠀⢀⣼⣿⣟⣉⣀⣀⣀⣸⣿⣃⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠉⠉⠉⢹⣿⣯⣤⡶⠶⠿⠿⠿⠛⠛⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

}
