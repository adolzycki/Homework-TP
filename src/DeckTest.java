import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;

/**
 * Decks for tests
 */
public class DeckTest {
    private Deck deck1 = null;
    private Deck deck2 = null;
    private Deck deck3 = null;

    /**
     * Constructs Decks for tests
     * @throws Exception when error
     */
    @Before
    public void setUp() throws Exception {
        deck1 = new Deck(52);
        deck2 = new Deck(32);
        deck3 = new Deck(24);
    }

    /**
     * Delete decks after tests
     * @throws Exception when error
     */
    @After
    public void tearDown() throws Exception {
        deck1 = null;
        deck2 = null;
        deck3 = null;
    }

    /**
     * When_NeedOneCard_Expect_GetOneCard test
     * @throws Exception when error
     */
    @Test(timeout = 500)
    public void When_NeedOneCard_Expect_GetOneCard() throws Exception {
        String str1 = deck1.getCard();
        String str2 = deck2.getCard();
        String str3 = deck3.getCard();
        assertNotNull(str1);
        assertNotNull(str2);
        assertNotNull(str3);
    }

    /**
     * When_Shuffle_Expect_ShuffledDeck test
     * @throws Exception when error
     */
    @Test
    public void When_Shuffle_Expect_ShuffledDeck() throws Exception {
        ArrayList<Card> tmpdeck1 = new ArrayList<>(deck1.deck);
        ArrayList<Card> tmpdeck2 = new ArrayList<>(deck2.deck);
        ArrayList<Card> tmpdeck3 = new ArrayList<>(deck3.deck);
        deck1.shuffle();
        deck2.shuffle();
        deck3.shuffle();
        assertFalse(Arrays.equals(deck1.deck.toArray(),tmpdeck1.toArray()));
        assertFalse(Arrays.equals(deck2.deck.toArray(),tmpdeck2.toArray()));
        assertFalse(Arrays.equals(deck3.deck.toArray(),tmpdeck3.toArray()));
    }

    /**
     * When_Sort_Expect_SortedDeck test
     * @throws Exception when error
     */
    @Test
    public void When_Sort_Expect_SortedDeck() throws Exception {
        ArrayList<Card> tmpdeck1 = new ArrayList<>(deck1.deck);
        ArrayList<Card> tmpdeck2 = new ArrayList<>(deck2.deck);
        ArrayList<Card> tmpdeck3 = new ArrayList<>(deck3.deck);
        deck1.sort();
        deck2.sort();
        deck3.sort();
        assertTrue(!Arrays.equals(deck1.deck.toArray(),tmpdeck1.toArray()));
        assertTrue(!Arrays.equals(deck2.deck.toArray(),tmpdeck2.toArray()));
        assertTrue(!Arrays.equals(deck3.deck.toArray(),tmpdeck3.toArray()));
    }

    /**
     * When_Sort_Expect_52Cards test
     * @throws Exception when error
     */
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

    /**
     * When_NeedCard_Expect_CardClass test
     * @throws Exception when error
     */
    @Test(expected = AssertionError.class)
    public void When_NeedCard_Expect_CardClass() throws Exception {
        assertEquals(Integer.class,deck1.getCard().getClass());
        assertEquals(Integer.class,deck2.getCard().getClass());
        assertEquals(Integer.class,deck3.getCard().getClass());
    }

    /**
     * When_Shuffle_Expect_NotSorted test
     * @throws Exception when error
     */
    @Test
    public void When_Shuffle_Expect_NotSorted() throws Exception{
        Deck deck1tmp = new Deck(deck1);
        Deck deck2tmp = new Deck(deck2);
        Deck deck3tmp = new Deck(deck3);

        deck1.shuffle();
        deck2.shuffle();
        deck3.shuffle();
        deck1tmp.sort();
        deck2tmp.sort();
        deck3tmp.sort();

        assertFalse(Arrays.equals(deck1tmp.deck.toArray(),deck1.deck.toArray()));
        assertFalse(Arrays.equals(deck2tmp.deck.toArray(),deck2.deck.toArray()));
        assertFalse(Arrays.equals(deck3tmp.deck.toArray(),deck3.deck.toArray()));
    }

}
