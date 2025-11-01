package lotto.model;

import lotto.view.Message;

public class BonusNumber {

    private final int bonus;

    public BonusNumber(String input, WinningNumber winningNumber) {
        this.bonus = parseValidate(input, winningNumber);
    }

    private int parseValidate(String input, WinningNumber winningNumber) {
        int number = parseInt(input);
        validate(number, winningNumber);
        return number;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOTINT.getMessage());
        }
    }

    private void validate(int bonusNumber, WinningNumber winningNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Message.NOTRANGE45.getMessage());
        }

        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.BONUSDUPLICATION.getMessage());
        }
    }

    public int getNumbers() {
        return bonus;
    }

}
