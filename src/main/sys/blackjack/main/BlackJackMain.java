package sys.blackjack.main;

import sys.blackjack.game.BlackJackController;

public class BlackJackMain {
    public static void main(String[] args) {
        BlackJackController controller = new BlackJackController();
        controller.startGame();
    }
}
