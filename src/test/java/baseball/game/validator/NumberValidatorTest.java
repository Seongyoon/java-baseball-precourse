package baseball.game.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    void lengthExceptionTest() {
        Assertions.assertThrows(
            IllegalArgumentException.class, () -> NumberValidator.validateLength("1234", 3)
        );
    }

    @Test
    void lengthSuccessTest() {
        Assertions.assertDoesNotThrow(
            () -> NumberValidator.validateLength("123", 3)
        );
    }

    @Test
    void typeExceptionTest() {
        Assertions.assertThrows(
            IllegalArgumentException.class, () -> NumberValidator.validateType("abc")
        );
    }

    @Test
    void typeSuccessTest() {
        Assertions.assertDoesNotThrow(
            () -> NumberValidator.validateType("123")
        );
    }

    @Test
    void rangeExceptionTest() {
        Assertions.assertThrows(
            IllegalArgumentException.class, () -> NumberValidator.validateRange("0", 1, 2)
        );

        Assertions.assertThrows(
            IllegalArgumentException.class, () -> NumberValidator.validateRange("3", 1, 2)
        );

        Assertions.assertThrows(
            IllegalArgumentException.class, () -> NumberValidator.validateRange("a", 1, 2)
        );
    }

    @Test
    void rangeSuccessTest() {
        Assertions.assertDoesNotThrow(
            () -> NumberValidator.validateRange("1", 1, 2)
        );
    }

    @Test
    void duplicateExceptionTest() {
        Assertions.assertThrows(
            IllegalArgumentException.class, () -> NumberValidator.validateDuplicateCharacter("119")
        );
    }

    @Test
    void duplicateSuccessTest() {
        Assertions.assertDoesNotThrow(
            () -> NumberValidator.validateDuplicateCharacter("123")
        );
    }
}
