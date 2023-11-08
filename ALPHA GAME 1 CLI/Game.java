import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Character player = new Character("Player", 100, 10, 5, 5, 5, 0.1, 0.1);
        Character enemy = new Character("Enemy", 50, 8, 4, 3, 4, 0.05, 0.05);

        Scanner scanner = new Scanner(System.in);

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("\nPlayer Health: " + player.getHealth());
            System.out.println("Enemy Health: " + enemy.getHealth());
            System.out.println("\nChoose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Apply Buff");
            System.out.println("4. Apply Debuff to Enemy");

            int playerAction = scanner.nextInt();

            switch (playerAction) {
                case 1:
                    System.out.println("Choose attack type (1-5):");
                    int attackType = scanner.nextInt();
                    player.attack(enemy, attackType);
                    System.out.println("Player attacked Enemy!");
                    break;
                case 2:
                    player.heal();
                    System.out.println("Player healed!");
                    break;
                case 3:
                    System.out.println("Choose buff type (1-5):");
                    int buffType = scanner.nextInt();
                    player.applyBuff(buffType);
                    System.out.println("Player applied buff!");
                    break;
                case 4:
                    System.out.println("Choose debuff type (1-5):");
                    int debuffType = scanner.nextInt();
                    enemy.applyDebuff(debuffType);
                    System.out.println("Player applied debuff to Enemy!");
                    break;
                default:
                    System.out.println("Invalid input. Skipping turn.");
                    break;
            }

            if (enemy.getHealth() > 0) {
                // Simple enemy AI: random action
                int enemyAction = (int) (Math.random() * 4) + 1;

                switch (enemyAction) {
                    case 1:
                        int enemyAttackType = (int) (Math.random() * 5) + 1;
                        enemy.attack(player, enemyAttackType);
                        System.out.println("Enemy attacked Player!");
                        break;
                    case 2:
                        enemy.heal();
                        System.out.println("Enemy healed!");
                        break;
                    case 3:
                        int enemyBuffType = (int) (Math.random() * 5) + 1;
                        enemy.applyBuff(enemyBuffType);
                        System.out.println("Enemy applied buff!");
                        break;
                    case 4:
                        int enemyDebuffType = (int) (Math.random() * 5) + 1;
                        player.applyDebuff(enemyDebuffType);
                        System.out.println("Enemy applied debuff to Player!");
                        break;
                }
            }
        }

        if (player.getHealth() <= 0) {
            System.out.println("\nGame Over! Enemy has won!");
        } else {
            System.out.println("\nCongratulations! You have defeated the Enemy!");
        }

        scanner.close();
    }
}