package lotto.controller;

import lotto.Lotto;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;


public class LottoController {

    public void run() {

        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = generateLotto(purchaseAmount);
        WinningNumber winningNumber = inputWinningNumber();
        BonusNumber bonusNumber = inputBonusNumber(winningNumber);
        getResult(purchaseAmount, lottos, winningNumber, bonusNumber);
    }

    private PurchaseAmount inputPurchaseAmount() {

        while (true) {
            try {
                String input = InputView.getPurchaseAmount();
                return new PurchaseAmount(input);
            }
            catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLotto(PurchaseAmount purchaseAmount) {

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generateLotto(purchaseAmount.getLottoCount());
        OutputView.printPurchaseLotto(lottos,purchaseAmount.getLottoCount());
        return lottos;
    }

    private WinningNumber inputWinningNumber() {
        while (true){
            try {
                String input = InputView.getWinningNumbers();
                return new WinningNumber(input);
            }
            catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                String input = InputView.getBonusNumber();
                return new BonusNumber(input, winningNumber);
            }
            catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void getResult(
            PurchaseAmount purchaseAmount,
            List<Lotto> lottos,
            WinningNumber winningNumber,
            BonusNumber bonusNumber) {

        LottoResult lottoResult = new LottoResult(lottos, winningNumber, bonusNumber);
        Map<RankPrize,Integer> result = lottoResult.getResult();

        OutputView.printLottoResult(result);

        double rate = lottoResult.profitRate(result, purchaseAmount.getCost());

        OutputView.printRate(rate);
    }
}
