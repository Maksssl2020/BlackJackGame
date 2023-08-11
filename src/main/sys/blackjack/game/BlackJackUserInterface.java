package sys.blackjack.game;

import java.util.Scanner;

class BlackJackUserInterface {
    protected String askUserForAnswer() {
        String userInput;
        boolean checkUserInput;

        do {
            userInput = new Scanner(System.in).nextLine();
            checkUserInput = checkEnteredAnswer(userInput);
        } while (!checkUserInput);

        return userInput.toUpperCase();
    }

    protected boolean checkEnteredAnswer(String userInput) {
        String userAnswerRegex = "[yYnN]";

        return userInput.matches(userAnswerRegex);
    }
}
