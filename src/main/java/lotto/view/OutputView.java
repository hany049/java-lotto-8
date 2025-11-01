package lotto.view;

import lotto.Lotto;
import lotto.model.RankPrize;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchaseLotto(List<Lotto> lottos, int count) {

        System.out.println(count + Message.PURCHASEAMOUNT.getMessage());

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResult(Map<RankPrize, Integer> result) {

        System.out.println(Message.STATISTIC.getMessage());

        System.out.println(Message.THREEHYPHENS.getMessage());

        System.out.println(Message.MATCH3.getMessage()
                + result.get(RankPrize.FIFTH)
                + Message.NUMBER.getMessage());

        System.out.println(Message.MATCH4.getMessage()
                + result.get(RankPrize.FOURTH)
                + Message.NUMBER.getMessage());

        System.out.println(Message.MATCH5.getMessage()
                + result.get(RankPrize.THIRD)
                + Message.NUMBER.getMessage());

        System.out.println(Message.MATCH5BONUS.getMessage()
                + result.get(RankPrize.SECOND)
                + Message.NUMBER.getMessage());

        System.out.println(Message.MATCH6.getMessage()
                + result.get(RankPrize.FIRST)
                + Message.NUMBER.getMessage());
    }

    public static void printRate(double rate) {
        System.out.println(Message.TOTALRETURNS.getMessage()
                + rate
                + Message.PERCENT.getMessage());
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
