package baseball.game.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserNumberTest {
    private static final int MAX_LENGTH = 3;

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1234", "112"})
    void exceptionTest(String userInput) {
        UserNumber userNumber = new UserNumber(MAX_LENGTH);
        Assertions.assertThrows(
            IllegalArgumentException.class, () -> userNumber.setNumbers(userInput)
        );
    }

    @Test
    void successTest() {
        UserNumber userNumber = new UserNumber(MAX_LENGTH);
        Assertions.assertDoesNotThrow(
            () -> userNumber.setNumbers("012")
        );
    }
}
