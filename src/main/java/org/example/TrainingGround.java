package org.example;


import org.example.Enemies.Enemy;
import org.example.Enemies.EvilMage;
import org.example.Enemies.MakeEnemy;
import org.example.Heroes.Archer;
import org.example.Heroes.Hero;
import org.example.Heroes.Mage;
import org.example.Heroes.Warrior;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class TrainingGround
{
    private static void addHero() {
        System.out.println("Please enter name of hero : ");
        Scanner scanName = new Scanner(System.in);
        String name = scanName.nextLine();
        System.out.println("Please choose your class from list below : ");
        System.out.println("(1 - Warrior,2 - Mage,3 - Archer)");
        Scanner scanRole = new Scanner(System.in);
        int role = scanRole.nextInt();
        if (role == 1) {
            hero = new Warrior(name, 25, 15, 25);
        } else if (role == 2) {
            hero = new Mage(name, 100, 25, 35);
        } else if (role == 3) {
            hero = new Archer(name, 50, 20, 50);
        } else {
            hero = new Warrior(name, 25, 15, 25);
        }
        heroes.add(hero);
        System.out.println("Your hero : ");
        hero.introduceMassage();
    }
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private static Hero hero;
    public static void main( String[] args ) {
        System.out.println("Hello! Below would given list of commands how to play the game");
        System.out.println("Pick role and play\nEnjoy! :)" +
                "\n-------------------------------\n");
        addHero();
        Level level;
        for (int i = 1; i <= 10; i++) {
            level = new Level(i+1,heroes);
            System.out.println("Level " + i);
            level.getBattle();
            if (i%2==0) {
                level.afterBattle();
            }
            if (i%5==0) {
                System.out.println("Add new hero to your company!");
                addHero();
            }
        }
    }
}
