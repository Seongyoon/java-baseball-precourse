package baseball.game.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseball.game.validator.NumberValidator;

public class UserNumber {
    private final int maxLength;

    private List<String> numbers;

    public UserNumber(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setNumbers(String inputValue) {
        reset();
        validate(inputValue);
        numbers = Arrays.asList(inputValue.split(""));
    }

    private void reset() {
        numbers = new ArrayList<>();
    }

    private void validate(String inputValue) {
        NumberValidator.validateType(inputValue);
        NumberValidator.validateLength(inputValue, maxLength);
        NumberValidator.validateDuplicateCharacter(inputValue);
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public String getNumber(int index) {
        return numbers.get(index);
    }

    @Override
    public String toString() {
        return String.join("", numbers);
    }
}
