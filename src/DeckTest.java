import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck = null;
    @Before
    public void setUp() throws Exception {

        deck = new Deck(52);
    }

    @After
    public void tearDown() throws Exception {
        deck = null;
    }

    @Test(timeout = 500)
    public void When_NeedOneCard_Expect_GetOneCard() throws Exception {
        String str = deck.getCard();
        assertNotNull(str);
    }

    @Test
    public void When_Shuffle_Expect_ShuffledDeck() throws Exception {
        ArrayList<Card> deck2 = (ArrayList<Card>) deck.deck.clone();
        deck.shuffle();
        assertFalse(Arrays.equals(deck.deck.toArray(),deck2.toArray()));
    }

    @Test
    public void When_Sort_Expect_SortedDeck() throws Exception {
        ArrayList<Card> deck2 = (ArrayList<Card>) deck.deck.clone();
        deck.sort();
        assertTrue(!Arrays.equals(deck.deck.toArray(),deck2.toArray()));
    }
    @Ignore
    @Test
    public void When_Sort_Expect_52Cards() throws Exception {
        deck.sort();
        assertEquals(52,deck.deck.size());
    }

    @Test(expected = AssertionError.class)
    public void When_NeedCard_Expect_CardClass() throws Exception {

        assertEquals(Integer.class,deck.getCard().getClass());
    }

}