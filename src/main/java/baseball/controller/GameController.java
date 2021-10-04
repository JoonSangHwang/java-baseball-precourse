package baseball.controller;

import baseball.service.GameService;
import baseball.service.GameServiceImpl;

public class GameController {

    private final GameService gameService;

    public GameController() {
        gameService = new GameServiceImpl();
    }

    public void gameStart() {
        while (gameService.inProgress());
    }
}
