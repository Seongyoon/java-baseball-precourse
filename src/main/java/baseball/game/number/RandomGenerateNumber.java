package baseball.game.number;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerateNumber {
    private final List<String> numbers;

    public RandomGenerateNumber(int maxLength) {
        numbers = new ArrayList<>();
        while (numbers.size() < maxLength) {
            addNumber();
        }
    }

    private void addNumber() {
        String number = generateNumberString();
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    private String generateNumberString() {
        return String.valueOf(Randoms.pickNumberInRange(0, 9));
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public String getNumber(int index) {
        return this.numbers.get(index);
    }

    @Override
    public String toString() {
        return String.join("", this.numbers);
    }
}
