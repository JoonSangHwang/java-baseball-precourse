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
}