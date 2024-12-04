import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;

    public Game()
    {
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        this.deck = new Deck(ranks, suits, values);
        this.player = new Player("Player", 0);
        this.dealer = new Player("Dealer", 0);

        startGame();
    }

    private void startGame()
    {
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());

        System.out.println(player);
        System.out.println(dealer);

        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver)
        {
            System.out.println("Do you want to 'hit' or 'stand'?");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("hit"))
            {
                player.addCard(deck.deal());
                System.out.println(player);

                if (player.calculatePoints() > 21)
                {
                    System.out.println("You busted! Dealer wins.");
                    gameOver = true;
                }
            }

            else if (action.equalsIgnoreCase("stand"))
            {
                gameOver = true;
            }

            else {
                System.out.println("Invalid Choice. Type 'hit' or 'stand'");
            }

        }

        while (dealer.calculatePoints() < 17)
        {
            dealer.addCard(deck.deal());
            System.out.println(dealer);
        }

        determineWinner();
    }

    private void determineWinner()
    {
        int playerPoints = player.calculatePoints();
        int dealerPoints = dealer.calculatePoints();

        System.out.println("Player's final score: " + playerPoints);
        System.out.println("Dealer's final score: " + dealerPoints);

        if (playerPoints > 21)
        {
            System.out.println("You busted! Dealer wins.");
        }
        else if (dealerPoints > 21)
        {
            System.out.println("Dealer busted! You win!");
        }
        else if (playerPoints > dealerPoints)
        {
            System.out.println("You win!");
        }
        else if(dealerPoints > playerPoints)
        {
            System.out.println("Dealer wins.");
        }
        else
        {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        printInstructions();
        Game game = new Game();
        game.startGame();


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





}
