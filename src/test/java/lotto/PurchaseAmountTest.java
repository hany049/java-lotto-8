package lotto;

import lotto.view.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

import lotto.model.PurchaseAmount;

public class PurchaseAmountTest {

    @Nested
    @DisplayName("숫자인지 검증")
    class 숫자인지_검증 {

        @ParameterizedTest
        @ValueSource(strings = {"1000", "4000", "18000", "51000"})
        @DisplayName("1000원 단위 양수 입력")
        void 양수_1000원단위_입력(String input) {
            assertThatCode(() -> new PurchaseAmount(input)).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"천원", "thousand", "1000 5000", "1,000"})
        @DisplayName("문자열 및 잘못된 입력 형태")
        void 문자열(String input) {
            assertThatThrownBy(() -> new PurchaseAmount(input)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.NOTINT.getMessage());
        }


    }

    @Nested
    @DisplayName("천원단위 확인")
    class 천원단위_확인 {

        @Test
        @DisplayName("천원단위 숫자 변환 확인")
        void 천원단위_숫자변환() {
            PurchaseAmount purchaseAmount = new PurchaseAmount("18000");
            assertThat(purchaseAmount.getCost()).isEqualTo(18000);
        }

        @ParameterizedTest
        @ValueSource(strings = {"364", "1300", "90",})
        @DisplayName("천원단위가 아닌 입력")
        void 천원단위가_아닌_입력(String input) {
            assertThatThrownBy(() -> new PurchaseAmount(input)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Message.THOUSAND.getMessage());
        }

    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "0", "-18000"})
    @DisplayName("양수 검증")
    void 양수_검증(String input) {

        assertThatThrownBy(() -> new PurchaseAmount(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NOTPOSITIVE.getMessage());

    }

    @Test
    @DisplayName("구매 개수 검증")
    void 구매_개수_검증() {

        PurchaseAmount purchaseAmount = new PurchaseAmount("18000");
        assertThat(purchaseAmount.getLottoCount()).isEqualTo(18);

    }

}
