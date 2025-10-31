package lotto.model;

public enum RankPrize {

    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int match;
    private final boolean matchBonus;
    private final int prize;

    RankPrize(int match, boolean bonus, int prize) {
        this.match = match;
        this.matchBonus = bonus;
        this.prize = prize;
    }

    public static RankPrize valueOf(int match, boolean bonus) {
        if (match == 6) {
            return FIRST;
        }

        if (match == 5 && bonus) {
            return SECOND;
        }

        if (match == 5) {
            return THIRD;
        }

        if (match == 4) {
            return FOURTH;
        }

        if (match == 3) {
            return FIFTH;
        }

        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
