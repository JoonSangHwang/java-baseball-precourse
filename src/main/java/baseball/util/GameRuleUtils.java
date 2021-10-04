package baseball.util;

public class GameRuleUtils {

    public static boolean isRule(String[] inStr) {
        return isFitLength(inStr)
                && isNumber(inStr)
                && isScope(inStr)
                && !isDuplicated(inStr);
    }

    private static boolean isNumber(String[] inStr) {
        return inStr[0].matches("[+-]?\\d*(\\.\\d+)?")
                || inStr[1].matches("[+-]?\\d*(\\.\\d+)?")
                || inStr[2].matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static boolean isScope(String[] inStr) {
        return Integer.parseInt(inStr[0]) >= 1
                || Integer.parseInt(inStr[0]) <= 9
                || Integer.parseInt(inStr[1]) >= 1
                || Integer.parseInt(inStr[1]) <= 9
                || Integer.parseInt(inStr[2]) >= 1
                || Integer.parseInt(inStr[2]) <= 9;
    }

    private static boolean isFitLength(String[] inStr) {
        return inStr.length == 3;
    }

    public static boolean isDuplicated(String[] inStr) {

        int duplYn = 0, idx = -1;

        while (idx++ < 2)
            duplYn += checkDupl(idx, inStr);

        if (duplYn != 0)
            return true;

        return false;
    }

    private static int checkDupl(int idx, String[] inStr) {
        if (inStr[idx].equals(inStr[(idx + 1) % 3]) || inStr[idx].equals(inStr[(idx + 2) % 3]))
            return 1;

        return 0;
    }
}
