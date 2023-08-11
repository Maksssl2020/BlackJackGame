package sys.blackjack.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @Test
    void testGetQueenValue() {
        int value = Rank.QUEEN.getValue();
        assertEquals(10, value);
    }

    @Test
    void testGetKingValue() {
        int value = Rank.KING.getValue();
        assertEquals(10, value);
    }

    @Test
    void testGetJackValue() {
        int value = Rank.JACK.getValue();
        assertEquals(10, value);
    }

    @Test
    void testGetAceValue() {
        int value = Rank.ACE.getValue();
        assertEquals(1, value);
    }

    @Test
    void testGetFiveValue() {
        int value = Rank.FIVE.getValue();
        assertEquals(5, value);
    }
}