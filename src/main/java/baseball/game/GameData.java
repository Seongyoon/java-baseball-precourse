package baseball.game;

import java.util.ArrayList;
import java.util.List;

import baseball.game.number.RandomGenerateNumber;
import baseball.game.number.UserNumber;

public class GameData {
    private static final int INPUT_MAX_LENGTH = 3;

    private RandomGenerateNumber randomNumber;

    private UserNumber userNumber;

    private int strikeCount;

    private int ballCount;

    public void reset() {
        randomNumber = new RandomGenerateNumber(INPUT_MAX_LENGTH);
        userNumber = new UserNumber(INPUT_MAX_LENGTH);
        countReset();
    }

    public void setUserNumber(String inputValue) {
        userNumber.setNumbers(inputValue);
        countReset();
        calc();
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }

    private void countReset() {
        strikeCount = 0;
        ballCount = 0;
    }

    private void calc() {
        calcStrikeCount();
        calcBallCount();
    }

    private void calcStrikeCount() {
        for (int i = 0; i < randomNumber.getNumbers().size(); i++) {
            strikeCondition(randomNumber.getNumber(i), userNumber.getNumber(i));
        }
    }

    private void strikeCondition(String a, String b) {
        if (a.equals(b)) {
            strikeCount++;
        }
    }

    private void calcBallCount() {
        List<String> newArray = new ArrayList<>(randomNumber.getNumbers());
        newArray.retainAll(userNumber.getNumbers());
        this.ballCount = newArray.size() - this.strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
