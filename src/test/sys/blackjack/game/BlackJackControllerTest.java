package sys.blackjack.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlackJackControllerTest {

    private BlackJackController game;

    @BeforeEach
    void setUp() {
        game = new BlackJackController();
    }

    @Test
    void testInitControllerFields() {
        game.initControllerFields();

        assertNotNull(game.getGameEngine());
        assertNotNull(game.getUserInterface());
    }

    @Test
    void testCheckingYesUserAnswer() {
        String userAnswer = "Y";
        String playerName = "user";
        game.initControllerFields();

        game.checkPlayerGettingNextCard(userAnswer, playerName);
        assertTrue(game.getGameEngine().getUserScore() > 0);
    }

    @Test
    void testCheckingNoUserAnswer() {
        String userAnswer = "N";
        String playerName = "user";
        game.initControllerFields();

        game.checkPlayerGettingNextCard(userAnswer, playerName);
        assertEquals(0, game.getGameEngine().getUserScore());
    }

    @Test
    void testCheckingYesComputerAnswer() {
        String userAnswer = "Y";
        String playerName = "computer";
        game.initControllerFields();

        game.checkPlayerGettingNextCard(userAnswer, playerName);
        assertTrue(game.getGameEngine().getComputerScore() > 0);
    }

    @Test
    void testCheckingNoComputerAnswer() {
        String userAnswer = "N";
        String playerName = "computer";
        game.initControllerFields();

        game.checkPlayerGettingNextCard(userAnswer, playerName);
        assertEquals(0, game.getGameEngine().getComputerScore());
    }
}
