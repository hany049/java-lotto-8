package lotto;

import lotto.model.BonusNumber;
import lotto.model.LottoResult;
import lotto.model.RankPrize;

import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Nested
    @DisplayName("당첨 순위 검증")
    class 당첨_순위_검증 {

        @Test
        @DisplayName("당첨 1등")
        void 당첨_1등() {
            RankPrize rank = RankPrize.valueOf(6,false);
            assertThat(rank).isEqualTo(RankPrize.FIRST);
        }

        @Test
        @DisplayName("당첨 2등")
        void 당첨_2등() {
            RankPrize rank = RankPrize.valueOf(5,true);
            assertThat(rank).isEqualTo(RankPrize.SECOND);
        }

        @Test
        @DisplayName("당첨 3등")
        void 당첨_3등() {
            RankPrize rank = RankPrize.valueOf(5,false);
            assertThat(rank).isEqualTo(RankPrize.THIRD);
        }

        @Test
        @DisplayName("당첨 4등")
        void 당첨_4등() {
            RankPrize rank = RankPrize.valueOf(4,false);
            assertThat(rank).isEqualTo(RankPrize.FOURTH);
        }

        @Test
        @DisplayName("당첨 5등")
        void 당첨_5등() {
            RankPrize rank = RankPrize.valueOf(3,false);
            assertThat(rank).isEqualTo(RankPrize.FIFTH);
        }

        @ParameterizedTest
        @ValueSource(ints = {0,1,2})
        @DisplayName("미당첨")
        void 미당첨(int inputs) {
            RankPrize rank = RankPrize.valueOf(inputs,false);
            assertThat(rank).isEqualTo(RankPrize.NONE);
        }
    }

    @Nested
    @DisplayName("수익률 계산 검증")
    class 수익률_계산_검증 {

        @Test
        @DisplayName("수익률 계산 및 소수점 확인")
        void 수익률_계산_및_소수점_확인() {

            List<Lotto> lottos = List.of(
                    new Lotto(List.of(1, 2, 4, 6, 7, 8)),
                    new Lotto(List.of(10, 12, 13, 14, 16, 17)),
                    new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                    new Lotto(List.of(3, 5, 11, 16, 32, 45)),
                    new Lotto(List.of(2, 5, 20, 21, 22, 32)),
                    new Lotto(List.of(1, 5, 7, 21 ,34, 36))
            );

            WinningNumber winningNumber = new WinningNumber("1,2,4,10,12,31");
            BonusNumber bonusNumber = new BonusNumber("41", winningNumber);
            LottoResult result = new LottoResult(lottos, winningNumber, bonusNumber);
            assertThat(result.profitRate(result.getResult(),6000)).isEqualTo(83.3);
        }
    }
}
