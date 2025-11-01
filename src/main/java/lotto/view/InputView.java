package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getPurchaseAmount() {
        System.out.println(Message.PURCHASEINPUT.getMessage());
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println(Message.WINNINGINPUT.getMessage());
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println(Message.BONUSINPUT.getMessage());
        return Console.readLine();
    }
}
