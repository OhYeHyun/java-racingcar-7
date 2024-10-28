package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private RacingService racingService;

    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 에러 발생")
    void 자동차_이름_5글자_초과_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService = new RacingService("aaaaaaa,bbbbbbb,ccccccc,ddddddd", "4");
            racingService.startRace();
        });
    }

    @Test
    @DisplayName("자동차 이름이 중복된 경우 에러 발생")
    void 자동차_이름_중복_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService = new RacingService("a,a,b,c,d", "4");
            racingService.startRace();
        });
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 에러 발생")
    void 자동차_이름_공백_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService = new RacingService("a,,,b,,,", "4");
            racingService.startRace();
        });
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아닌 경우 에러 발생")
    void 시도할_횟수_숫자_테스트1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService = new RacingService("a,b,c", "a");
            racingService.startRace();
        });
    }

    @Test
    @DisplayName("시도할 횟수가 음수인 경우 에러 발생")
    void 시도할_횟수_숫자_테스트2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService = new RacingService("a,b,c", "-1");
            racingService.startRace();
        });
    }
}
