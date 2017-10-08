import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckTests extends TestCase {

    Deck deck = null;

    public void setUp() throws Exception {
        deck = new Deck(52);
    }

    public void testGetCard() throws Exception {
        String str = deck.getCard();
        assertNotNull(str);

        assertEquals(String.class,deck.getCard().getClass());
    }

    public void testShuffle() throws Exception {
        ArrayList<Card> deck2 = (ArrayList<Card>) deck.deck.clone();
        deck.shuffle();
        assertFalse(Arrays.equals(deck.deck.toArray(),deck2.toArray()));

        assertEquals(52,deck.deck.size());

    }

    public void testSort() throws Exception {
        ArrayList<Card> deck2 = (ArrayList<Card>) deck.deck.clone();
        deck.sort();
        assertTrue(!Arrays.equals(deck.deck.toArray(),deck2.toArray()));

    }


    public void tearDown() throws Exception {

        deck = null;
    }

}