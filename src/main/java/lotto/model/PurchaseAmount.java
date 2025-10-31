package lotto.model;

import lotto.view.Message;

public class PurchaseAmount {

    private final int cost;

    public PurchaseAmount(String inputCost) {
        this.cost = parserValidate(inputCost);
    }

    private int parserValidate(String input) {
        int intCost = parserInt(input);
        validate(intCost);
        return intCost;
    }

    private int parserInt(String input) {
        try{
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR.getMessage()+Message.NOTINT.getMessage());
        }
    }

    private void validate(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(Message.ERROR.getMessage()+Message.NOTPOSITIVE.getMessage());
        }

        if (input % 1000 != 0) {
            throw new IllegalArgumentException(Message.ERROR.getMessage()+Message.THOUSAND.getMessage());
        }
    }

    public int getCost() {
        return cost;
    }

    public int getLottoCount() {
        return cost / 1000;
    }
}
