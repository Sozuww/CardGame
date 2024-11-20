import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> c = new ArrayList<>();
    private int cardsLeft;

    public Deck (String[] ranks, String[] suits, int[] values)
    {
        for (int i = 0; i < ranks.length; i++)
        {
            for (String suit : suits) {
                Card card = new Card(ranks[i], suit, values[i]);
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

    public Card deal()
    {
        if (cardsLeft == 0)
        {
            return null;
        }
        cardsLeft--;
        return c.get(cardsLeft);
    }


    public void shuffle()
    {
        for (int i = c.size(); i > 0; i--)
        {
            int rand = (int) (Math.random() * (i+1));
            Card temp = c.get(i);
            c.set(i, c.get(rand));
            c.set(rand, temp);
        }
        cardsLeft = c.size();
    }

}
