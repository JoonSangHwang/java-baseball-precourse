package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.GameRuleUtils;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameServiceImpl implements GameService {

    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer;
    private Player player;

    public GameServiceImpl() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    @Override
    public boolean inProgress() {

        // 컴퓨터 숫자 초기화
        initComputerNumber();

        // 게임 플레이
        while (play());

        // 게임 재시작 여부
        return outputView.isRestart();
    }

    private void initComputerNumber() {
        computer = new Computer();
        computer.initNumber();
    }

    private boolean play() {

        // 플레이어 숫자 초기화
        while (!initPlayerNumber());

        // 점수
        outputView.score(computer, player);

        // 게임 완료 여부
        return outputView.isFinish(computer, player);
    }


    @Override
    public boolean initPlayerNumber() {

        String[] inStr = inputView.printInputMsg();
        if (!GameRuleUtils.isRule(inStr)) {
            outputView.printErrorMsg();
            return false;
        }

        player = new Player(inStr);
        return true;
    }
}