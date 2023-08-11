package sys.blackjack.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import sys.blackjack.cards.Card;
import sys.blackjack.cards.Deck;
import sys.blackjack.cards.Rank;
import sys.blackjack.cards.Suit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BlackJackEngineTest {

    private BlackJackEngine game;

    @BeforeEach
    void setUp() {
        game = new BlackJackEngine();
    }

    @RepeatedTest(10)
    void testRandomNumbersGenerator() {
        int[] confirmedNumbers = new int[52];
        int confirmedNumbersSum = 0;

        for (int i = 0; i < 500; i++) {
            int randomNumber = game.getRandomNumber();
            confirmedNumbers[randomNumber] = 1;
        }

        for (int confirmedNumber : confirmedNumbers) {
            confirmedNumbersSum += confirmedNumber;
        }

        assertEquals(52, confirmedNumbersSum);
    }

    @Test
    void testGetRandomCardFromDeck() {
        Deck deckToCompare = new Deck();
        int generatedRandomNumber = game.getRandomNumber();

        String randomCard = game.getRandomCardFromDeck(generatedRandomNumber).toString();
        String randomCardFromDeckToCompare = deckToCompare.getCard(generatedRandomNumber).toString();

        assertEquals(randomCardFromDeckToCompare, randomCard);
    }

    @Test
    void testGetTheSameRandomCardFromDeck() {
        int generatedRandomNumber = game.getRandomNumber();

        String randomCard = game.getRandomCardFromDeck(generatedRandomNumber).toString();
        String theSameRandomCard = game.getRandomCardFromDeck(generatedRandomNumber).toString();

        assertNotEquals(theSameRandomCard, randomCard);
    }

    @Test
    void testAceValueUserScoreLessThen10() {
        int resultValue = game.checkAceValue(new Card(Rank.ACE, Suit.SPADES), "user");
        assertEquals(11, resultValue);
    }

    @Test
    void testAceValueUserScoreOver10() {
        game.setUserScore(11);
        int resultValue = game.checkAceValue(new Card(Rank.ACE, Suit.SPADES), "user");
        assertEquals(1, resultValue);
    }

    @Test
    void testAceValueComputerScoreLessThen10() {
        int resultValue = game.checkAceValue(new Card(Rank.ACE, Suit.SPADES), "computer");
        assertEquals(11, resultValue);
    }

    @Test
    void testAceValueComputerScoreOver10() {
        game.setComputerScore(11);
        int resultValue = game.checkAceValue(new Card(Rank.ACE, Suit.SPADES), "computer");
        assertEquals(1, resultValue);
    }

    @Test
    void testUserScoreAfterGettingAceCard() {
        int generatedRandomNumber = 0;

        game.userGetCard(generatedRandomNumber);

        assertEquals(11, game.getUserScore());
    }

    @Test
    void testGettingAceCardWhenUserScoreIsOver10() {
        int generatedRandomNumber = 0;
        int expectedScore;

        game.setUserScore(11);
        game.userGetCard(generatedRandomNumber);
        expectedScore = 12;

        assertEquals(expectedScore, game.getUserScore());
    }

    @Test
    void testComputerScoreAfterGettingAceCard() {
        int generatedRandomNumber = 0;

        game.computerGetCard(generatedRandomNumber);

        assertEquals(11, game.getComputerScore());
    }

    @Test
    void testGettingAceCardWhenComputerScoreIsOver10() {
        int generatedRandomNumber = 0;

        game.setComputerScore(11);
        game.computerGetCard(generatedRandomNumber);

        assertEquals(12, game.getComputerScore());
    }

    @Test
    void testUserScoreAfterGettingCard() {
        Deck deckToCompare = new Deck();
        int generatedRandomNumber = game.getRandomNumber();
        int expectedScore;

        game.userGetCard(generatedRandomNumber);
        expectedScore = deckToCompare.getCard(generatedRandomNumber).getValue();

        assertEquals(expectedScore, game.getUserScore());
    }

    @Test
    void testComputerScoreAfterGettingCard() {
        Deck deckToCompare = new Deck();
        Card takenCard;
        int generatedRandomNumber = game.getRandomNumber();
        int expectedScore;

        game.computerGetCard(generatedRandomNumber);

        takenCard = deckToCompare.getCard(generatedRandomNumber);
        if (takenCard.getCardRank().equalsIgnoreCase("ace")) {
            expectedScore = game.checkAceValue(takenCard, "computer");
        } else {
            expectedScore = takenCard.getValue();
        }


        assertEquals(expectedScore, game.getComputerScore());
    }

    @Test
    void testRandomNumbersToAnswerGenerator() {
        int[] confirmedNumbers = new int[3];
        int confirmedNumbersSum = 0;

        for (int i = 0; i < 50; i++) {
            int randomNumberToAnswer = game.randomNumberToComputerAnswer();
            confirmedNumbers[randomNumberToAnswer - 1] = 1;
        }

        for (int confirmedNumber : confirmedNumbers) {
            confirmedNumbersSum += confirmedNumber;
        }

        assertEquals(3, confirmedNumbersSum);
    }

    @Test
    void testComputerYAnswer() {
        int generatedNumber = 2;
        String resultMessage = game.computerAnswer(generatedNumber);

        assertEquals("Y", resultMessage);
    }

    @Test
    void testComputerNAnswerByGenerating1() {
        int generatedNumber = 1;
        String resultMessage = game.computerAnswer(generatedNumber);

        assertEquals("N", resultMessage);
    }

    @Test
    void testComputerNAnswerByGenerating3() {
        int generatedNumber = 3;
        String resultMessage = game.computerAnswer(generatedNumber);

        assertEquals("N", resultMessage);
    }

    @Test
    void testWinningMessageResult() {
        game.setUserScore(20);
        game.setComputerScore(12);
        String resultMessage = game.checkGameResult();

        assertEquals("Congratulations! You have better score than computer! You won the game!", resultMessage);
    }

    @Test
    void testLoosingMessageResult() {
        game.setUserScore(22);
        game.setComputerScore(12);
        String resultMessage = game.checkGameResult();

        assertEquals("Sorry, you have over 21 points! You lost the game!", resultMessage);
    }

    @Test
    void testTieMessageResult() {
        game.setUserScore(11);
        game.setComputerScore(11);
        String resultMessage = game.checkGameResult();

        assertEquals("You and computer have the same score!", resultMessage);
    }

    @Test
    void testComputerHasOver21Points() {
        game.setUserScore(11);
        game.setComputerScore(22);
        String resultMessage = game.checkGameResult();

        assertEquals("Congratulations! Computer has over 21 points and you won the game!", resultMessage);
    }
}