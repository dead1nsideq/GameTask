package org.example;

import java.lang.annotation.Target;
import java.util.Random;

public class Spell {
    private String spellName;
    private Man caster;
    private Man target;

    public Spell(String spellName,Man caster,Man target) {
        this.spellName = spellName;
        this.caster = caster;
        this.target = target;
    }

    public int spell(int min,int max,int mana) {
        int manaPool = caster.getMana();
        int lvl = caster.getLvl();
        if (manaPool >= mana) {
            int attackMax = max;
            int attackMin = min;
            attackMin += (lvl * 10);
            attackMax += (lvl * 10);
            int damage = new Random().nextInt((attackMax - attackMin) + 1) + attackMin;
            System.out.println("Caster of spell " + caster.getClass().getSimpleName() +
                    " cast spell " + spellName+ " to " + target.getClass().getSimpleName() +
                    " for " + damage);
            target.takeDamage(damage);
            return mana;
        } else {
            System.out.println("No mana for this spell");
            return 0;
        }
    }
}
