package baseball.game;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class GameDataTest {
    @Test
    void resetTest() {
        GameData gameData = new GameData();
        gameData.reset();
        Assertions.assertTrue(gameData.getStrikeCount() == 0 && gameData.getBallCount() == 0);
    }

    @Test
    void allStrikeTest() {
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
            .thenReturn(1, 2, 3);

        GameData gameData = new GameData();
        gameData.reset();
        gameData.setUserNumber("123");

        Assertions.assertTrue(gameData.isAllStrike());
        mock.close();
    }

    @Test
    void nothingTest() {
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
            .thenReturn(1, 2, 3);

        GameData gameData = new GameData();
        gameData.reset();
        gameData.setUserNumber("456");

        Assertions.assertTrue(gameData.getStrikeCount() == 0 && gameData.getBallCount() == 0);
        mock.close();
    }

    @Test
    void strikeAndBallTest() {
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
            .thenReturn(1, 2, 3);

        GameData gameData = new GameData();
        gameData.reset();
        gameData.setUserNumber("136");

        Assertions.assertTrue(gameData.getStrikeCount() == 1 && gameData.getBallCount() == 1);
        mock.close();
    }
}
