package sys.blackjack.cards;

import org.junit.jupiter.api.Test;
import sys.blackjack.cards.Card;
import sys.blackjack.cards.Rank;
import sys.blackjack.cards.Suit;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testGetQueenValue() {
        Card queen = new Card(Rank.QUEEN, Suit.CLUBS);
        int value = queen.getValue();
        assertEquals(10, value);
    }

    @Test
    void testGetKingValue() {
        Card queen = new Card(Rank.KING, Suit.CLUBS);
        int value = queen.getValue();
        assertEquals(10, value);
    }

    @Test
    void testGetJackValue() {
        Card queen = new Card(Rank.JACK, Suit.CLUBS);
        int value = queen.getValue();
        assertEquals(10, value);
    }

    @Test
    void testGetAceValue() {
        Card queen = new Card(Rank.ACE, Suit.CLUBS);
        int value = queen.getValue();
        assertEquals(1, value);
    }

    @Test
    void testGetFiveValue() {
        Card queen = new Card(Rank.FIVE, Suit.CLUBS);
        int value = queen.getValue();
        assertEquals(5, value);
    }
}