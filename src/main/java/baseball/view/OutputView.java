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

    public boolean isFinish(Computer computer, Player player) {
        int[] computerNum = computer.getNum();
        int[] playerNum = player.getNum();

        return computerNum[0] != playerNum[0]
                || computerNum[1] != playerNum[1]
                || computerNum[2] != playerNum[2];
    }

    public boolean isRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return !EXIT.equals(Console.readLine());
    }
}