package org.example;

public abstract class Man {
    public abstract int getLvl();
    public abstract int getMana();
    public abstract void upgrade();
    public abstract void attackEnemy(Man enemy);
    public abstract void castSpell(Man enemy);
    public abstract int takeDamage(int damage);
}
