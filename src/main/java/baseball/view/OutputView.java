package baseball.view;

import baseball.model.Computer;
import baseball.model.Player;
import nextstep.utils.Console;

public class OutputView {
    static final String EXIT = "2";

    public void printErrorMsg() {
        System.out.println("[ERROR] 숫자를 다시 입력해주세요.");
    }

    public void score(Computer computer, Player player) {

        int strikeCnt = computer.numberOfStrike(player);
        int ballCnt = computer.numberOfBall(player);

        if (strikeCnt == 0 && ballCnt == 0) System.out.print("낫싱");
        if (strikeCnt != 0) System.out.print(strikeCnt + "스트라이크");
        if (strikeCnt != 0 && ballCnt != 0) System.out.print(" ");
        if (ballCnt != 0) System.out.print(ballCnt + "볼");
        System.out.println();
    }
}