package org.example;

import org.example.Enemies.Enemy;
import org.example.Enemies.MakeEnemy;
import org.example.Enemies.Zombie;
import org.example.Heroes.Hero;

import java.util.*;

public class Level {

    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Hero> heroes;
    private int mobCount;


    public Level(int mobCount,ArrayList<Hero> heroes) {
        enemies.add(MakeEnemy.getEnemy(5*mobCount,10*mobCount,100 + mobCount*10));
        for (int i = 0; i < mobCount; i++) {
            if(i%3==0) {
                enemies.add(MakeEnemy.getEnemy(5*mobCount,10*mobCount,100 + i*mobCount));
            }
        }
        this.heroes = heroes;
        this.mobCount = mobCount;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void afterBattle() {
        System.out.println("Restoring hp and mana after battle : ");
        for (Hero hero: heroes
             ) {
            hero.addHealth(75);
            hero.addMana(50);
            hero.getStats();
        }
    }

    public void getBattle() {
        boolean exit = false;
        while (!enemies.isEmpty() || !heroes.isEmpty()) {
            for (Enemy enemy : enemies) {
                int h = new Random().nextInt(heroes.size());
                enemy.attackEnemy(heroes.get(h));
                if (enemies.size() < mobCount) {
                    if (enemy.getClass().getSimpleName().equals("Necromaster")) {
                        if (new Random().nextInt(100)%10==0) {
                            enemies.add(new Zombie("Necromaster`s zombie",50,5,15));
                        }
                    }
                }
                enemy.icon();
                System.out.println("Heroes hp " + heroes.get(h).getHealth());
                if (!heroes.get(h).isAlive()) {
                    heroes.remove(h);
                    if (heroes.isEmpty()) {
                        System.out.println("All heroes died");
                        exit = true;
                        break;
                    }
                }
            }
            if (exit) {
                break;
            }
            for (Hero hero : heroes) {
                System.out.println("Choose enemy to attack");
                for (int i = 0; i < enemies.size(); i++) {
                    System.out.println(i+1 + " - " + enemies.get(i).getName());
                }
                int e = new Scanner(System.in).nextInt();
                e = e - 1;
                if (e >= enemies.size() || e < 0) {
                    e = 0;
                }
                hero.getChoice(enemies.get(e));
                hero.icon();
                if (enemies.get(e).isAlive()) {
                    System.out.println("Enemy " + enemies.get(e).getName() + " has " + enemies.get(e).getHealth());
                } else {
                    System.out.println(enemies.get(e).getName() + " died! ");
                }
                if (!enemies.get(e).isAlive()) {
                    if (enemies.get(e).getClass().getSimpleName().equals("Zombie")) {
                        if (new Random().nextInt(100)%5==0) {
                            enemies.get(e).setHealth(100);
                            System.out.println("Enemy " + enemies.get(e).getName() + " wake up from dead with 100 hp");
                        } else {
                            enemies.remove(e);
                        }
                    } else {
                        enemies.remove(e);
                    }
                    if (enemies.isEmpty()) {
                        System.out.println("All enemies died");
                        exit = true;
                        break;
                    }
                }
            }
            if (exit) {
                break;
            }
        }
    }
}
