package Interfaces;

import Classes.Player;

public interface IGameState {
    public void startGame();
    public void gameRockPaperScissorsLogic(Player playerOne, Player playerTwo, String playerOneChoice, String playerTwoChoice);
}
