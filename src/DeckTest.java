import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck1 = null;
    Deck deck2 = null;
    Deck deck3 = null;
    @Before
    public void setUp() throws Exception {

        deck1 = new Deck(52);
        deck2 = new Deck(32);
        deck3 = new Deck(24);
    }

    @After
    public void tearDown() throws Exception {
        deck1 = null;
        deck2 = null;
        deck3 = null;
    }

    @Test(timeout = 500)
    public void When_NeedOneCard_Expect_GetOneCard() throws Exception {
        String str1 = deck1.getCard();
        String str2 = deck2.getCard();
        String str3 = deck3.getCard();
        assertNotNull(str1);
        assertNotNull(str2);
        assertNotNull(str3);
    }

    @Test
    public void When_Shuffle_Expect_ShuffledDeck() throws Exception {
        ArrayList<Card> tmpdeck1 = (ArrayList<Card>) deck1.deck.clone();
        ArrayList<Card> tmpdeck2 = (ArrayList<Card>) deck2.deck.clone();
        ArrayList<Card> tmpdeck3 = (ArrayList<Card>) deck3.deck.clone();
        deck1.shuffle();
        deck2.shuffle();
        deck3.shuffle();
        assertFalse(Arrays.equals(deck1.deck.toArray(),tmpdeck1.toArray()));
        assertFalse(Arrays.equals(deck2.deck.toArray(),tmpdeck2.toArray()));
        assertFalse(Arrays.equals(deck3.deck.toArray(),tmpdeck3.toArray()));
    }

    @Test
    public void When_Sort_Expect_SortedDeck() throws Exception {
        ArrayList<Card> tmpdeck1 = (ArrayList<Card>) deck1.deck.clone();
        ArrayList<Card> tmpdeck2 = (ArrayList<Card>) deck2.deck.clone();
        ArrayList<Card> tmpdeck3 = (ArrayList<Card>) deck3.deck.clone();
        deck1.sort();
        deck2.sort();
        deck3.sort();
        assertTrue(!Arrays.equals(deck1.deck.toArray(),tmpdeck1.toArray()));
        assertTrue(!Arrays.equals(deck2.deck.toArray(),tmpdeck2.toArray()));
        assertTrue(!Arrays.equals(deck3.deck.toArray(),tmpdeck3.toArray()));
    }
    @Ignore
    @Test
    public void When_Sort_Expect_52Cards() throws Exception {
        deck1.sort();
        deck2.sort();
        deck3.sort();
        assertEquals(52,deck1.deck.size());
        assertEquals(32,deck2.deck.size());
        assertEquals(24,deck3.deck.size());
    }

    @Test(expected = AssertionError.class)
    public void When_NeedCard_Expect_CardClass() throws Exception {

        assertEquals(Integer.class,deck1.getCard().getClass());
        assertEquals(Integer.class,deck2.getCard().getClass());
        assertEquals(Integer.class,deck3.getCard().getClass());
    }

}