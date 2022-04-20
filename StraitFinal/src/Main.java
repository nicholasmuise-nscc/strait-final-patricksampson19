public class Main {
    public static void main(String[] args) {

        CharacterCreator creator = new CharacterCreator();

        Player[] bracket1 = new Player[5];
        Enemy[] bracket2 = new Enemy[5];

        bracket1[0] = creator.generatePlayer("Matt");
        bracket1[1] = creator.generatePlayer("Liam");
        bracket1[2] = creator.generatePlayer("Mitchell");
        bracket1[3] = creator.generatePlayer("Brandon");
        bracket1[4] = creator.generatePlayer("Alexander");
        bracket2[0] = creator.generateEnemy("Blake");
        bracket2[1] = creator.generateEnemy("Carmen");
        bracket2[2] = creator.generateEnemy("Patrick");
        bracket2[3] = creator.generateEnemy("ALyssa");
        bracket2[4] = creator.generateEnemy("Lloyd");

        for (int charcount = 0; charcount < bracket1.length; charcount++ ) {
            System.out.println(bracket1[charcount].getName() + " starting health: " + bracket1[charcount].getHealth());
        }
        for (int charcount = 0; charcount < bracket1.length; charcount++ ) {
            System.out.println(bracket2[charcount].getName() + " starting health: " + bracket2[charcount].getHealth());
        }
        System.out.println("Let the tournament begin");

        Battle battle = new Battle();
        //battle.bracketOne(bracket1);
       // battle.bracketTwo(bracket2);
        battle.tournamentBracket(bracket1, bracket2);
    }
}
