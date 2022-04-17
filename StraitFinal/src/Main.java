public class Main {
    public static void main(String[] args) {

        CharacterCreator creator = new CharacterCreator();

        Player player = creator.generatePlayer("Maximus");
        Enemy enemy = creator.generateEnemy("Brutus");

        System.out.println(player.getName() + " starting health: " + player.getHealth());
        System.out.println(enemy.getName() + " starting health: " + enemy.getHealth());
        System.out.println("Let the battle begin");

        Battle battle = new Battle();
        battle.runBattle(player, enemy);
    }
}
