package baseball.model;

public class Player {

    private int[] num;

    public Player(String[] inStr) {
        num = new int[3];
        num[0] = Integer.parseInt(inStr[0]);
        num[1] = Integer.parseInt(inStr[1]);
        num[2] = Integer.parseInt(inStr[2]);
    }

    public int[] getNum() {
        return this.num;
    }
}