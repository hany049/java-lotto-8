package lotto.model;

import lotto.view.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber(String input) {

        this.numbers = parseValidate(input);
    }

    private List<Integer> parseValidate(String input) {
        List<Integer> number = parseInt(input);
        validate(number);
        return number;
    }

    private List<Integer> parseInt(String input) {
        try {
            return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOTINT.getMessage());
        }
    }

    private void validate(List<Integer> number) {
        if (number.size() != 6) {
            throw new IllegalArgumentException(Message.NOT6.getMessage());
        }

        if (new HashSet<>(number).size() != number.size()) {
            throw new IllegalArgumentException(Message.DUPLICATION.getMessage());
        }

        for (Integer num : number) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(Message.NOTRANGE45.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
