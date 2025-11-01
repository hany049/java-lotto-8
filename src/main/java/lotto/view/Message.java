package lotto.view;

public enum Message {

    PURCHASEINPUT("구입금액을 입력해 주세요."),
    WINNINGINPUT("당첨 번호를 입력해 주세요."),
    BONUSINPUT("보너스 번호를 입력해 주세요."),
    PURCHASEAMOUNT("개를 구매했습니다."),
    STATISTIC("당첨 통계"),
    THREEHYPHENS("---"),
    MATCH3("3개 일치 (5,000원) - "),
    MATCH4("4개 일치 (50,000원) - "),
    MATCH5("5개 일치 (1,500,000원) - "),
    MATCH5BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH6("6개 일치 (2,000,000,000원) - "),
    NUMBER("개"),
    TOTALRETURNS("총 수익률은 "),
    PERCENT("%입니다."),

    ERROR("[ERROR]"),
    NOTINT("숫자가 아닙니다, 숫자를 입력해 주세요!!!"),
    NOTPOSITIVE("금액은 양수로 입력해 주세요!!!"),
    THOUSAND("1000원 단위로 입력해 주세요!!!"),
    NOT6("숫자가 6개가 아닙니다!!!"),
    DUPLICATION("중복되는 숫자가 있습니다!!!"),
    BONUSDUPLICATION("보너스 번호가 당첨 번호와 중복됩니다!!!"),
    NOTRANGE45("로또 번호는 1~45사이의 숫자로 입력해 주세요!!!");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
