package baseball;

import baseball.game.BaseballGame;
import baseball.game.GameData;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame(new GameData());
        game.start();
    }
}
