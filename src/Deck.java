import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> c = new ArrayList<Card>();
    private int cardsLeft;

    public Deck (String[] ranks, String[] suits, int[] values)
    {
        for (int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                Card card = new Card(ranks[i], suits[j], values[i]);
                c.add(card);
            }
        }

        cardsLeft = c.size();

        shuffle();
    }



    public boolean isEmpty()
    {
        return cardsLeft == 0;
    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }

 /*   public Card deal()
    {
        if (cardsLeft = 0)
        {
            return null;
        }
    }
    */

    public void shuffle()
    {
        for (int i = cardsLeft; i > 0; i--)
        {

        }
    }

}
