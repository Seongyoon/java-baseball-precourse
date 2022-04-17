package baseball.game;

public class BaseballPrinter {
    private BaseballPrinter() {}

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public static void printResult(GameData gameData) {
        System.out.println(createResultString(gameData.getStrikeCount(), gameData.getBallCount()));
    }

    private static String createResultString(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        return (createBallString(ballCount) + createStrikeString(strikeCount)).trim();
    }

    private static String createBallString(int ballCount) {
        if (ballCount > 0) {
            return ballCount + "볼 ";
        }
        return "";
    }

    private static String createStrikeString(int strikeCount) {
        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }
        return "";
    }
}
