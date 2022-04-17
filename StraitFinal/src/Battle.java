public class Battle {

    public void runBattle(Character player, Character enemy) {
        while (true) {
            player.battleCry();
            player.attack(enemy);
            battleUpdate(player, enemy);

            if (enemy.getHealth() <= 0) {
                declareWinner(player);
                break;
            }

            enemy.battleCry();
            enemy.attack(player);
            battleUpdate(enemy, player);

            if (player.getHealth() <= 0) {
                declareWinner(enemy);
                break;
            }
        }
    }

    private void battleUpdate(Character attacker, Character defender) {
        System.out.println(attacker.getName() + " attacks " + defender.getName() + " with their " + attacker.getWeapon().getName() + " for " + attacker.getWeapon().getDamage() +
                " damage. Health remaining: " + defender.getHealth());
    }

    private void declareWinner(Character winner) {
        System.out.println("The winner is " + winner.getName());
    }
}
