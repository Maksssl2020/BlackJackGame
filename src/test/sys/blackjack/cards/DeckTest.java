package sys.blackjack.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeckTest {

    private Deck cards;

    @BeforeEach
    void setUp() {
        cards = new Deck();
    }

    @Test
    void testGetFirstCard() {
        String firstCard = cards.getCard(0).toString();
        String expectedFirstCard = new Card(Rank.ACE, Suit.CLUBS).toString();
        assertEquals(expectedFirstCard, firstCard);
    }

    @Test
    void testGetLastCard() {
        String lastCard = cards.getCard(51).toString();
        String expectedLastCard = new Card(Rank.KING, Suit.SPADES).toString();
        assertEquals(expectedLastCard, lastCard);
    }

    @Test
    void testGetTheSameCardTwoTimes() {
        String firstCardInDeck = cards.getCard(0).toString();
        String theSameFirstCardInDeck = cards.getCard(0).toString();
        assertNotEquals(theSameFirstCardInDeck, firstCardInDeck);
    }

    @Test
    void testGetDeckSize() {
        int totalDeckSize = cards.getDeckSize();
        assertEquals(52, totalDeckSize);
    }

    @Test
    void testGetDeckSizeAfterGettingCard() {
        cards.getCard(0);
        int deckSize = cards.getDeckSize();
        assertEquals(51, deckSize);
    }
}