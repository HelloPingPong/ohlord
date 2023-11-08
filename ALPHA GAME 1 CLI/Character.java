package com.example.rpggame.model;

import java.util.Random;

public class Character {
    private String name;
    private int health;
    private int attackPower;
    private int defense;
    private int healPower;
    private int speed;
    private double criticalChance;
    private double dodgeChance;
    private Random random;

    public Character(String name, int health, int attackPower, int defense, int healPower, int speed, double criticalChance, double dodgeChance) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.healPower = healPower;
        this.speed = speed;
        this.criticalChance = criticalChance;
        this.dodgeChance = dodgeChance;
        this.random = new Random();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealPower() {
        return healPower;
    }

    public void setHealPower(int healPower) {
        this.healPower = healPower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(double dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void heal() {
        this.health += this.healPower;
    }

    public void attack(Character target, int attackType) {
        int damage = this.attackPower;
        double critMultiplier = 1.0;
        double dodgeMultiplier = 1.0;

        if (random.nextDouble() <= this.criticalChance) {
            critMultiplier = 1.5; // Critical hit multiplies the damage by 1.5
        }

        if (random.nextDouble() <= target.getDodgeChance()) {
            dodgeMultiplier = 0.0; // Dodged attack deals no damage
        }

        switch (attackType) {
            case 1:
                damage += 5;
                break;
            case 2:
                damage += 10;
                break;
            case 3:
                damage += 15;
                break;
            case 4:
                damage += 20;
                break;
            case 5:
                damage += 25;
                break;
        }

        int finalDamage = (int) Math.round(damage * critMultiplier * dodgeMultiplier) - target.getDefense();
        finalDamage = Math.max(finalDamage, 0); // Ensure damage is not negative
        target.setHealth(target.getHealth() - finalDamage);
    }

    public void applyBuff(int buffType) {
        switch (buffType) {
            case 1:
                this.attackPower += 5;
                break;
            case 2:
                this.defense += 5;
                break;
            case 3:
                this.speed += 5;
                break;
            case 4:
                this.criticalChance += 0.05;
                break;
            case 5:
                this.dodgeChance += 0.05;
                break;
        }
    }

    public void applyDebuff(int debuffType) {
        switch (debuffType) {
            case 1:
                this.attackPower -= 5;
                break;
            case 2:
                this.defense -= 5;
                break;
            case 3:
                this.speed -= 5;
                break;
            case 4:
                this.criticalChance -= 0.05;
                break;
            case 5:
                this.dodgeChance -= 0.05;
                break;
        }
    }
}
