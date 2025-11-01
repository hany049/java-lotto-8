package lotto;

import lotto.model.BonusNumber;
import lotto.model.WinningNumber;
import lotto.view.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class WinningBonusNumberTest {

    @Nested
    @DisplayName("당첨번호 검증")
    class 당첨번호_검증 {

        @Test
        @DisplayName("문자 입력 예외 확인")
        void 문자_입력_예외_검증 () {
            assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,a")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.NOTINT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        @DisplayName("입력 개수 6개 확인")
        void 입력_개수_6개_확인 (String inputs) {
            assertThatThrownBy(() -> new WinningNumber(inputs)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.NOT6.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,1,2,3,4,5", "12,12,12,26,43,45"})
        @DisplayName("중복 예외 확인")
        void 중복_예외_확인 (String inputs) {
            assertThatThrownBy(() -> new WinningNumber(inputs)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.DUPLICATION.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"0,1,2,3,4,5", "1,12,23,34,45,56"})
        @DisplayName("범위 예외 확인")
        void 범위_예외_확인 (String inputs) {
            assertThatThrownBy(() -> new WinningNumber(inputs)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.NOTRANGE45.getMessage());
        }
    }

    @Nested
    @DisplayName("보너스 번호 검증")
    class 보너스번호_검증 {

        private WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        @ParameterizedTest
        @ValueSource(strings = {"number", "1,0"})
        @DisplayName("문자열 예외 확인")
        void 문자열_예외_확인 (String inputs) {
            assertThatThrownBy(() -> new BonusNumber(inputs,winningNumber)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.NOTINT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "56"})
        @DisplayName("범위 예외 확인")
        void 범위_예외_확인 (String inputs) {
            assertThatThrownBy(() -> new BonusNumber(inputs,winningNumber)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.NOTRANGE45.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "6"})
        @DisplayName("중복 예외 확인")
        void 중복_예외_확인 (String inputs) {
            assertThatThrownBy(() -> new BonusNumber(inputs,winningNumber)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.BONUSDUPLICATION.getMessage());
        }
    }
}
