package baseball.game;

import baseball.game.validator.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final GameData gameData;

    public BaseballGame(GameData gameData) {
        this.gameData = gameData;
    }

    public void start() {
        do {
            gameData.reset();
            oneGame();
        } while (!checkEndCondition());
    }

    private void oneGame() {
        do {
            gameData.setUserNumber(readNumbers());
            BaseballPrinter.printResult(gameData);
        } while (!gameData.isAllStrike());
        BaseballPrinter.printEndMessage();
    }

    private static String readNumbers() {
        BaseballPrinter.printNumberInputMessage();
        return Console.readLine();
    }

    private static boolean checkEndCondition() {
        BaseballPrinter.printRestartMessage();

        String input = Console.readLine();
        validateEndCondition(input);
        return "2".equals(input);
    }

    private static void validateEndCondition(String input) {
        NumberValidator.validateLength(input, 1);
        NumberValidator.validateType(input);
        NumberValidator.validateRange(input, 1, 2);
    }
}
