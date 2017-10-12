import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Deck testing class
 */
public class DeckTests extends TestCase {

    private Deck deck = null;

    /**
     * Create new deck
     * @throws Exception when error
     */
    public void setUp() throws Exception {
        super.setUp();
        deck = new Deck(52);
    }

    /**
     * Get card test
     * @throws Exception when error
     */
    public void testGetCard() throws Exception {
        String str = deck.getCard();

        assertNotNull(str);
        assertEquals(String.class,deck.getCard().getClass());
    }

    /**
     * Shuffle test
     * @throws Exception when error
     */
    public void testShuffle() throws Exception {
        ArrayList<Card> deck2 = new ArrayList<>(deck.deck);
        deck.shuffle();

        assertFalse(Arrays.equals(deck.deck.toArray(),deck2.toArray()));
        assertEquals(52,deck.deck.size());
    }

    /**
     * Sort test
     * @throws Exception when error
     */
    public void testSort() throws Exception {
        ArrayList<Card> deck2 = new ArrayList<>(deck.deck);
        deck.sort();

        assertTrue(!Arrays.equals(deck.deck.toArray(),deck2.toArray()));
    }

    /**
     * Delete deck
     * @throws Exception when error
     */
    public void tearDown() throws Exception {
        super.tearDown();
        deck = null;
    }

}