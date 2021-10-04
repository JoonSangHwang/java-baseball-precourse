package baseball.model;

import baseball.util.GameRuleUtils;
import nextstep.utils.Randoms;

import java.util.Arrays;

public class Computer {

    private int[] num;

    public Computer() {
        num = new int[3];
    }

    public void initNumber() {
        while (initNum());
    }

    private boolean initNum() {
        num[0] = Randoms.pickNumberInRange(1, 9);
        num[1] = Randoms.pickNumberInRange(1, 9);
        num[2] = Randoms.pickNumberInRange(1, 9);

        String[] intarrToStrarr = Arrays.toString(num).replaceAll("[^0-9]","").split("");
        return GameRuleUtils.isDuplicated(intarrToStrarr);
    }

    public int[] getNum() {
        return this.num;
    }

    public int numberOfStrike(Player player) {
        int[] playerNum = player.getNum();
        int strikeCnt = 0;
        if (num[0] == playerNum[0]) strikeCnt++;
        if (num[1] == playerNum[1]) strikeCnt++;
        if (num[2] == playerNum[2]) strikeCnt++;

        return strikeCnt;
    }

    public int numberOfBall(Player player) {
        int[] playerNum = player.getNum();
        int ballCnt = 0;
        int idx = -1;
        while (idx++ < 2)
            ballCnt += checkBall(idx, playerNum);
        return ballCnt;
    }

    private int checkBall(int idx, int[] playerNum) {
        int ballcnt = 0;

        if (num[idx] == playerNum[(idx + 1) % 3] || num[idx] == playerNum[(idx + 2) % 3])
            ballcnt++;

        return ballcnt;
    }
}