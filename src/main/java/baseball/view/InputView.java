package baseball.view;

import nextstep.utils.Console;

public class InputView {

    public String[] printInputMsg() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine().split("");
    }
}