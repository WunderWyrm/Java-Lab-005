import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Dice die;


    public Game(Player p1, Player p2, Dice die) {
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }

    public void play() {
        Player current = this.p1;

        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);

        System.out.println( announceWinner() );
    }

    public Player nextPlayer(Player current) {
        if (current == this.p1) {
            return this.p2;
        } else {
            return this.p1;
        }
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        System.out.println( this.p1.getName() + ": " + this.p1.getScore());
        System.out.println( this.p2.getName() + ": " + this.p2.getScore());

        if (this.p1.getScore() > this.p2.getScore()) {
            return this.p1.getName();
        } else if (this.p1.getScore() < this.p2.getScore()) {
            return this.p2.getName();
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many sides should the dice have?: ");
        int sides = sc.nextInt();
        sc.nextLine();

        System.out.print("\nWhat is Player 1's name?: ");
        String name1 = sc.nextLine();

        System.out.print("\nWhat is Player 2's name?: ");
        String name2 = sc.nextLine();

        Game game = new Game( new Player(name1), new Player(name2), new Dice(sides) );

        game.play();
    }
}
