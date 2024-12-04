import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private String name;
    private int points;

    Player(String name, int points)
    {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.points = 0;
    }
    Player(String name, ArrayList<Card> hand, int points)
    {
        this.name = name;
        this.points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int num)
    {
        this.points += num;
    }

    public void addCard(Card a)
    {
        hand.add(a);
    }

    public int calculatePoints()
    {
        int total = 0;
        int aces = 0;

        for (Card card : hand)
        {
            total += card.getValue();
            if (card.getRank().equals("A"))
            {
                aces++;
            }
        }

        for (int i = 0; i < aces; i++)
        {
            if (total + 10 <= 21)
            {
                total += 10;
            }
        }

        return total;
    }

    public String toString()
    {
        return name + " has " + getPoints() + " points\n " + name + "'s cards: " + getHand();
    }
}
