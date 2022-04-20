import java.util.Random;
public class Battle {

    public Character runBattle(Character player, Character enemy) {
        while (true) {
            player.battleCry();
            player.attack(enemy);
            battleUpdate(player, enemy);

            if (enemy.getHealth() <= 0) {
                declareWinner(player);
                return player;
            }

            enemy.battleCry();
            enemy.attack(player);
            battleUpdate(enemy, player);

            if (player.getHealth() <= 0) {
                declareWinner(enemy);
                return enemy;
            }
        }
    }

    public void tournamentBracket(Player[] bracket1, Enemy[] bracket2) {
        // Bracket 1
        /**
         *  Makes the results array for bracket 1
         */
        int[] results1 = new int[5];
        /**
         * Makes the Semi Final array for the Round Robin Winners
         */
        Character[] Semis = new Character[4];
        /**
         *  Goes through the Round Robin for Bracket 1
         */
        for (int player = 0; player < results1.length; player++) {
            for (int another = player + 1; another < results1.length; another++) {
                if (runBattle(bracket1[player], bracket1[another]) == bracket1[player]) {
                    results1[player]++;
                    resetHealth(bracket1[player]);
                    resetHealth(bracket1[another]);
                    System.out.println();
                } else {
                    results1[another]++;
                    resetHealth(bracket1[another]);
                    resetHealth(bracket1[player]);
                    System.out.println();
                }
            }
        }
        /**
         * This value tracks the max wins for Bracket 1
         *
         * This loops over the Wins of each character is Bracket 1 to find
         * the max
         */
        int winner1 = 0;
        for (int numBracket1 = 1; numBracket1 < results1.length; numBracket1++) {
            if (results1[numBracket1] > results1[winner1]) {
                winner1 = numBracket1;
            }
        }

        Semis[0] = bracket1[winner1];

        /**
         * This value tracks the runner-up in Bracket 1
         *
         * This loops over the remaining people in Bracket 1 to find the
         * runner-up
         */
        int runnerUp1 = 0;
        for (int numBracket1 = 1; numBracket1 < results1.length; numBracket1++) {
            if (results1[numBracket1] > results1[runnerUp1]) {
                runnerUp1 = numBracket1;
            }
        }

        Semis[1] = bracket1[runnerUp1];

        System.out.println("Players going to the Semi finals");
        System.out.println(Semis[0].getName());
        System.out.println(Semis[1].getName());
        System.out.println();

        /**
         * this is an array that tracks the wins from Bracket 2
         *
         * this loop goes through the games for the Round Robin for Bracket 2
         */
        int[] results2 = new int[5];
        for (int player = 0; player < results2.length; player++) {
            for (int another = player + 1; another < results2.length; another++) {
                if (runBattle(bracket2[player], bracket2[another]) == bracket2[player]) {
                    results2[player]++;
                    resetHealth(bracket2[player]);
                    resetHealth(bracket2[another]);
                    System.out.println();
                } else {
                    results2[another]++;
                    resetHealth(bracket2[another]);
                    resetHealth(bracket2[player]);
                    System.out.println();
                }
            }
        }

        /**
         * the value find the winner of Bracket 2
         *
         * this loop finds the winner of the Round Robin of Bracket 2
         */
        int winner2 = 0;
        for (int numBracket2 = 1; numBracket2 < results2.length; numBracket2++) {
            if (results2[numBracket2] > results2[winner2]) {
                winner2 = numBracket2;
            }
        }

        Semis[2] = bracket2[winner2];

        /**
         * the value finds the runner-up of Bracket 2
         *
         * this loop finds the runner-up of Bracket 2
         */
        int runnerUp2 = 0;
        for (int numBracket2 = 1; numBracket2 < results2.length; numBracket2++) {
            if (results2[numBracket2] > results2[runnerUp2]) {
                runnerUp2 = numBracket2;
            }
        }

        Semis[3] = bracket2[runnerUp2];

        System.out.println("Players going to the Semi finals");
        System.out.println(Semis[2].getName());
        System.out.println(Semis[3].getName());
        System.out.println();

        /**
         * An array for the characters that make the finals
         */
        Character[] finals = new Character[2];

        //Semi's
        /**
         * The first semi-finals where the winner of Bracket 1 plays the
         * runner-up of Bracket 2
         */
        if (runBattle(Semis[0], Semis[3]) == Semis[0]) {
            finals[0] = Semis[0];
            resetHealth(Semis[0]);
            resetHealth(Semis[3]);
            System.out.println();
            System.out.println(finals[0].getName() + " " + "Is going to the finals");
        } else {
            finals[0] = Semis[3];
            resetHealth(Semis[0]);
            resetHealth(Semis[3]);
            System.out.println();
            System.out.println(finals[0].getName() + " " + "Is going to the finals");
        }
        /**
         * The second semi-finals game where the winner of Bracket 2 plays the
         * runner-up of Bracket 1.
         */
        if (runBattle(Semis[1], Semis[2]) == Semis[1]) {
            finals[1] = Semis[1];
            resetHealth(Semis[1]);
            resetHealth(Semis[2]);
            System.out.println();
            System.out.println(finals[1] + " " + "Is going to the finals");
        } else {
            finals[1] = Semis[2];
            resetHealth(Semis[1]);
            resetHealth(Semis[2]);
            System.out.println();
            System.out.println(finals[1].getName() + " " + "Is going to the finals");
        }

        //Finals
        /**
         * The final game of the tournament where the winners of both Semi-finals
         * games play to be the winner of the tournament.
         */
        if (runBattle(finals[0], finals[1]) == finals[0]) {
            System.out.println();
            System.out.println(finals[0].getName() + " " + "Has won the tournament");
            System.out.println();
        } else {
            System.out.println();
            System.out.println(finals[1].getName() + " " + "Has won the tournament");
            System.out.println();

        }
    }

        private void battleUpdate (Character attacker, Character defender){
            System.out.println(attacker.getName() + " attacks " + defender.getName() + " with their " + attacker.getWeapon().getName() + " for " + attacker.getWeapon().getDamage() +
                    " damage. Health remaining: " + defender.getHealth());
        }

        private void declareWinner (Character winner){
            System.out.println("The winner is " + winner.getName());
        }
        private void resetHealth (Character character){
            Random random = new Random();
            if (character.getHealth() <= 0) {
                character.setHealth(random.nextInt(20, 51));
            }
        }

}