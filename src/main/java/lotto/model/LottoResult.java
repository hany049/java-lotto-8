package lotto.model;

import lotto.Lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<RankPrize, Integer> result;

    public LottoResult(List<Lotto> lottos, WinningNumber winning, BonusNumber bonus) {

        this.result = initialResult();
        matchLotto(lottos, winning.getNumbers(), bonus.getNumbers());

    }

    private void matchLotto(List<Lotto> lottos, List<Integer> winning, int bonus) {
        for (Lotto lotto : lottos) {

            int countMatch = matchCount(lotto.getNumbers(), winning);
            boolean bonusMatch = matchBonus(lotto.getNumbers(), bonus);
            RankPrize rank = RankPrize.valueOf(countMatch, bonusMatch);

            if (rank != RankPrize.NONE) {

                result.put(rank, result.get(rank) + 1);
            }
        }
    }

    private Map<RankPrize, Integer> initialResult() {

        Map<RankPrize, Integer> init = new EnumMap<>(RankPrize.class);
        for (RankPrize rank : RankPrize.values()) {

            if (rank != RankPrize.NONE) {
                init.put(rank, 0);
            }
        }
        return init;
    }

    private int matchCount(List<Integer> lotto, List<Integer> winning) {

        int match = 0;
        for (int number : lotto) {
            if (winning.contains(number)) {
                match++;
            }
        }
        return match;
    }

    private boolean matchBonus(List<Integer> lotto, int bonus) {

        return lotto.contains(bonus);
    }

    private int totalProfit(Map<RankPrize, Integer> result) {

        int total = 0;
        for (Map.Entry<RankPrize, Integer> entry : result.entrySet()) {

            RankPrize rank = entry.getKey();
            int count = entry.getValue();
            total += count * rank.getPrize();
        }
        return total;
    }

    public double profitRate(Map<RankPrize, Integer> result, int purchaseAmount) {

        double rate = (double) totalProfit(result) / purchaseAmount * 100;
        return Math.round(rate *10.0) / 10.0;
    }

    public Map<RankPrize, Integer> getResult() {
        return result;
    }
}
