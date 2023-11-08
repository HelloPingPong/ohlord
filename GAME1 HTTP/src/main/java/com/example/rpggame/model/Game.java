package com.example.rpggame.model;

public class Game {

    private Character player;
    private Character enemy;
    private boolean gameOver;

    public Game() {
        this.player = new Character("Player", 100, 10, 2);
        this.enemy = new Character("Enemy", 100, 8, 1);
        this.gameOver = false;
    }

    public Character[] start() {
        player.reset();
        enemy.reset();
        gameOver = false;
        return new Character[]{player, enemy};
    }

    public void processTurn(GameAction gameAction) {
        player.performAction(gameAction, enemy);

        if (enemy.getHealth() <= 0) {
            gameOver = true;
            return;
        }

        GameAction enemyAction = GameAction.generateRandomAction();
        enemy.performAction(enemyAction, player);

        if (player.getHealth() <= 0) {
            gameOver = true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Character getPlayer() {
        return player;
    }

    public Character getEnemy() {
        return enemy;
    }
}

/*package com.example.rpggame.model;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Character player;
    private Character enemy;

    public Game(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public Map<String, Object> performAction(GameAction action) {
        Map<String, Object> result = new HashMap<>();

        switch (action.getActionType()) {
            case "attack":
                player.attack(enemy, action.getOption());
                result.put("playerAction", "attack");
                result.put("attackType", action.getOption());
                break;
            case "heal":
                player.heal();
                result.put("playerAction", "heal");
                break;
            case "buff":
                player.applyBuff(action.getOption());
                result.put("playerAction", "buff");
                result.put("buffType", action.getOption());
                break;
            case "debuff":
                enemy.applyDebuff(action.getOption());
                result.put("playerAction", "debuff");
                result.put("debuffType", action.getOption());
                break;
        }

        if (enemy.getHealth() > 0) {
            // Simple enemy AI: random action
            int enemyAction = (int) (Math.random() * 4) + 1;

            switch (enemyAction) {
                case 1:
                    int enemyAttackType = (int) (Math.random() * 5) + 1;
                    enemy.attack(player, enemyAttackType);
                    result.put("enemyAction", "attack");
                    result.put("enemyAttackType", enemyAttackType);
                    break;
                case 2:
                    enemy.heal();
                    result.put("enemyAction", "heal");
                    break;
                case 3:
                    int enemyBuffType = (int) (Math.random() * 5) + 1;
                    enemy.applyBuff(enemyBuffType);
                    result.put("enemyAction", "buff");
                    result.put("enemyBuffType", enemyBuffType);
                    break;
                case 4:
                    int enemyDebuffType = (int) (Math.random() * 5) + 1;
                    player.applyDebuff(enemyDebuffType);
                    result.put("enemyAction", "debuff");
                    result.put("enemyDebuffType", enemyDebuffType);
                    break;
            }
        }

        result.put("player", player);
        result.put("enemy", enemy);

        return result;
    }

    public boolean isGameOver() {
        return player.getHealth() <= 0 || enemy.getHealth() <= 0;
    }
}*/