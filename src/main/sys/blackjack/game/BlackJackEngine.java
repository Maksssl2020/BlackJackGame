package sys.blackjack.game;

import sys.blackjack.cards.Card;
import sys.blackjack.cards.Deck;

import java.util.Random;

class BlackJackEngine {
    public static final int MAX_VALUE_FOR_11_POINTS_ACE = 10;
    private final int MAX_SCORE = 21;
    private final Deck cardsDeck = new Deck();
    private int userScore = 0;
    private int computerScore = 0;

    protected void userGetCard(int generatedRandomNumber) {
        Card takenCard = getRandomCardFromDeck(generatedRandomNumber);

        if (takenCard.getCardRank().equalsIgnoreCase("ace")) {
            userScore += checkAceValue(takenCard, "user");
        } else {
            userScore += takenCard.getValue();
        }

        System.out.printf("You have taken %s!%n", takenCard);
    }

    protected void computerGetCard(int generatedRandomNumber) {
        Card takenCard = getRandomCardFromDeck(generatedRandomNumber);

        if (takenCard.getCardRank().equalsIgnoreCase("ace")) {
            computerScore += checkAceValue(takenCard, "computer");
        } else {
            computerScore += takenCard.getValue();
        }
    }

    protected int checkAceValue(Card ace, String player) {
        int aceValue;

        if ("user".equalsIgnoreCase(player) && userScore <= MAX_VALUE_FOR_11_POINTS_ACE) {
            aceValue = 11;
        } else if ("computer".equalsIgnoreCase(player) && computerScore <= MAX_VALUE_FOR_11_POINTS_ACE) {
            aceValue = 11;
        } else {
            aceValue = 1;
        }

        return aceValue;
    }

    protected String computerAnswer(int randomNumberToAnswer) {
        String computerAnswer;

        if (randomNumberToAnswer % 2 == 0) {
            computerAnswer = "Y";
        } else {
            computerAnswer = "N";
        }

        return computerAnswer;
    }

    protected int randomNumberToComputerAnswer() {
        return new Random().nextInt(3) + 1;
    }

    protected Card getRandomCardFromDeck(int generatedRandomNumber) {
        return cardsDeck.getCard(generatedRandomNumber);
    }

    protected int getRandomNumber() {
        return new Random().nextInt(cardsDeck.getDeckSize());
    }

    protected int getUserScore() {
        return userScore;
    }

    protected void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    protected int getComputerScore() {
        return computerScore;
    }

    protected void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    protected String checkGameResult() {
        String resultMessage;

        if (userScore > MAX_SCORE) {
            resultMessage = "Sorry, you have over 21 points! You lost the game!";
        } else if (userScore < computerScore && computerScore > MAX_SCORE) {
            resultMessage = "Congratulations! Computer has over 21 points and you won the game!";
        } else if (userScore > computerScore) {
            resultMessage = "Congratulations! You have better score than computer! You won the game!";
        } else if (userScore < computerScore && computerScore < MAX_SCORE) {
            resultMessage = "Sorry, you have worse score than computer! You lost the game!";
        } else {
            resultMessage = "You and computer have the same score!";
        }

        return resultMessage;
    }
}
