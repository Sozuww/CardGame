public class Game {


    public Game()
    {
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Deck cards = new Deck(ranks, suits, values);

        Player p1 = new Player("Player", 0);
        Player dealer = new Player("Dealer", 0);


    }
    private static void printInstructions()
    {
        System.out.println("The goal of the game is to get a higher number than ");
        System.out.println("the dealer, but you can't go over 21. If you go over ");
        System.out.println("21, you lose. To gain a card (add 2-10 numbers), then ");
        System.out.println("choose hit. Otherwise, press stand, and you'll ");
        System.out.println("know if you win or lose. ");
        System.out.println("That's all for now, good luck!");
    }

    public static void main(String[] args)
    {
        printInstructions();
    }
}
