package Interfaces;

import Classes.Player;

public interface IGameState {
    public void startGame() throws InterruptedException;
    public void gameRockPaperScissorsLogic(Player playerOne, Player playerTwo, String playerOneChoice, String playerTwoChoice);
}
