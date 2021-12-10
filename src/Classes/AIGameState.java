package Classes;

import Interfaces.IGameState;

import java.util.ArrayList;
import java.util.Arrays;

public class AIGameState implements IGameState {

    private static ArrayList<String> Choices = new ArrayList<String>(Arrays.asList("rock", "paper", "scissors"));
    private Player _humanPlayer;
    private Player _aiPlayer;

    public AIGameState(Player humanPlayer){
        _humanPlayer = humanPlayer;
    }



    @Override
    public void startGame() {
        System.out.println("Game started");
    }

    @Override
    public void gameRockPaperScissorsLogic(Player playerOne, Player playerTwo, String playerOneChoice, String playerTwoChoice) {

    }
}
