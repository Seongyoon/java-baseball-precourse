package baseball.game.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {
    private NumberValidator() {}

    public static void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(String.format("숫자의 길이를 잘못 입력했습니다. 유효길이: %d", length));
        }
    }

    public static void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static void validateRange(String input, int start, int end) {
        int parsedInput = Integer.parseInt(input);
        if (parsedInput < start || parsedInput > end) {
            throw new IllegalArgumentException(String.format("입력 가능 범위를 벗어났습니다. 범위: %d ~ %d", start, end));
        }
    }

    public static void validateDuplicateCharacter(String inputValue) {
        List<String> list = Arrays.asList(inputValue.split(""));
        Set<String> characterSet = new HashSet<>(list);
        if (characterSet.size() != inputValue.length()) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
    }
}
