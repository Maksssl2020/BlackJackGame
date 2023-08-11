package sys.blackjack.cards;

import org.junit.jupiter.api.Test;
import sys.blackjack.cards.Suit;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void testGetClubSymbol() {
        char result = Suit.CLUBS.getSymbol();
        assertEquals('\u2663', result);
    }

    @Test
    void testGetDiamondSymbol() {
        char result = Suit.DIAMONDS.getSymbol();
        assertEquals('\u2666', result);
    }

    @Test
    void testGetHeartSymbol() {
        char result = Suit.HEARTS.getSymbol();
        assertEquals('\u2665', result);
    }

    @Test
    void testGetSpadeSymbol() {
        char result = Suit.SPADES.getSymbol();
        assertEquals('\u2660', result);
    }
}