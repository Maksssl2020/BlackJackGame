package sys.blackjack.game;

public class BlackJackController {
    private BlackJackEngine gameEngine;
    private BlackJackUserInterface userInterface;

    public BlackJackController() {}

    public void startGame() {
        String userAnswer;

        do {
            gameRound();
            System.out.println("\nDo you want to restart game? ( Y / N )");
            userAnswer = userInterface.askUserForAnswer();
        } while (!userAnswer.equalsIgnoreCase("N"));
    }

    private void gameRound() {
        String resultMessage;
        initControllerFields();

        gameEngine.userGetCard(gameEngine.getRandomNumber());
        gameEngine.userGetCard(gameEngine.getRandomNumber());
        System.out.printf("Your score: %d%n", gameEngine.getUserScore());

        gameEngine.computerGetCard(gameEngine.getRandomNumber());
        gameEngine.computerGetCard(gameEngine.getRandomNumber());

        userAnswer();
        computerAnswer();

        resultMessage = gameEngine.checkGameResult();

        System.out.println(resultMessage);
    }

    protected void initControllerFields() {
        gameEngine = new BlackJackEngine();
        userInterface = new BlackJackUserInterface();
    }

    protected void userAnswer() {
        String userAnswer = null;
        int userScore;

        do {
            userScore = gameEngine.getUserScore();

            if (userScore < 21) {
                System.out.println("Do you want to take next card? ( Y / N )");
                userAnswer = userInterface.askUserForAnswer();
                checkPlayerGettingNextCard(userAnswer, "user");
                System.out.printf("Your score: %d%n", gameEngine.getUserScore());
            } else {
                System.out.printf("You can't get another card, because you have %d points!%n", userScore);
            }

        } while (!"N".equalsIgnoreCase(userAnswer) && userScore < 21);
    }

    protected void computerAnswer() {
        String computerAnswer = null;
        int computerScore;

        do {
            computerScore = gameEngine.getComputerScore();

            if (computerScore < 21) {
                int computerRandomNumberToAnswer = gameEngine.randomNumberToComputerAnswer();
                computerAnswer = gameEngine.computerAnswer(computerRandomNumberToAnswer);
                checkPlayerGettingNextCard(computerAnswer, "computer");
            }
        } while (!"N".equalsIgnoreCase(computerAnswer) && computerScore < 21);
    }

    protected void checkPlayerGettingNextCard(String playerAnswer, String player) {
        if (player.equalsIgnoreCase("user") && playerAnswer.equalsIgnoreCase("Y")) {
            gameEngine.userGetCard(gameEngine.getRandomNumber());
        } else if (player.equalsIgnoreCase("computer") && playerAnswer.equalsIgnoreCase("Y")) {
            gameEngine.computerGetCard(gameEngine.getRandomNumber());
        }
    }

    protected BlackJackEngine getGameEngine() {
        return gameEngine;
    }

    protected BlackJackUserInterface getUserInterface() {
        return userInterface;
    }
}
