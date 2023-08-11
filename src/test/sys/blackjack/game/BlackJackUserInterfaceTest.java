package sys.blackjack.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class BlackJackUserInterfaceTest {

    private BlackJackUserInterface game;

    @BeforeEach
    void setUp() {
        game = new BlackJackUserInterface();
    }

    @Test
    void testUserAnswerToTakeAnotherCard() {
        String userInput = "Y";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        String result = game.askUserForAnswer();
        assertEquals("Y", result);

        System.setIn(System.in);
    }

    @Test
    void testUserAnswerToNotTakeAnotherCard() {
        String userInput = "N";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        String result = game.askUserForAnswer();
        assertEquals("N", result);

        System.setIn(System.in);
    }

    @Test
    void testCheckingUserCorrectAnswer() {
        String userInput = "N";
        assertTrue(game.checkEnteredAnswer(userInput));
    }

    @Test
    void testCheckingUserIncorrectAnswer() {
        String userInput = "2";
        assertFalse(game.checkEnteredAnswer(userInput));
    }
}
