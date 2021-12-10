package Interfaces;

import Classes.Player;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IGameState {
    public void startGame() throws InterruptedException, IOException, UnsupportedAudioFileException;
    public void gameRockPaperScissorsLogic(Player playerOne, Player playerTwo, String playerOneChoice, String playerTwoChoice);
}
