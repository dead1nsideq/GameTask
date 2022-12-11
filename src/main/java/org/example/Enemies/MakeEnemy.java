package org.example.Enemies;

import java.util.*;

public class MakeEnemy {
    private enum EnemyList {
        Bandit,
        EvilMage,
        Vampire,
        Zombie,
        Necromater
    }
    private static final ArrayList<String> preficsList = new ArrayList<String>() {{
        add("Scary");
        add("Big");
        add("Fast");
    }};

    private static final List<EnemyList> VALUES =
            Collections.unmodifiableList(Arrays.asList(EnemyList.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private static EnemyList randomEnemy()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
    public static Enemy getEnemy(int min,int max,int heath) {
        switch (randomEnemy()) {
            case Bandit:
                return new Bandit(preficsList.get(new Random().nextInt(preficsList.size())),heath,min,max);
            case Zombie:
                return new Zombie(preficsList.get(new Random().nextInt(preficsList.size())),heath,min,max);
            case Vampire:
                return new Vampire(preficsList.get(new Random().nextInt(preficsList.size())),heath,min,max);
            case EvilMage:
                return new EvilMage(preficsList.get(new Random().nextInt(preficsList.size())),heath,min,max);
            case Necromater:
                return new Necromaster(preficsList.get(new Random().nextInt(preficsList.size())),heath,min,max);
        }
        return null;
    }
}
