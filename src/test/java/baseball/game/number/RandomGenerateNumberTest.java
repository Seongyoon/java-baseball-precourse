package baseball.game.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomGenerateNumberTest {
    private static final int MAX_LENGTH = 3;

    @Test
    void lengthTest() {
        RandomGenerateNumber randomGenerateNumber = new RandomGenerateNumber(MAX_LENGTH);
        Assertions.assertEquals(MAX_LENGTH, randomGenerateNumber.getNumbers().size());
    }

    @Test
    void typeTest() {
        Assertions.assertDoesNotThrow(
                () -> {
                    UserNumber userNumber = new UserNumber(MAX_LENGTH);
                    userNumber.setNumbers("012");
                }
        );

    }
}
