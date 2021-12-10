package Classes;

import Interfaces.IGameState;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AIGameState implements IGameState {

    private final ArrayList<String> Choices = new ArrayList<>(Arrays.asList("rock", "paper", "scissors"));
    private final Player _humanPlayer;
    private final Player _aiPlayer;

    public AIGameState(Player humanPlayer){
        _humanPlayer = humanPlayer;
        _aiPlayer = new Player();
    }



    @Override
    public void startGame() throws InterruptedException {
        String soundFileOne = "src/sounds/fireball.wav";
        String soundFileTwo = "src/sounds/fireworks.wav";
        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("Welcome to Rock, Paper, Scissors!");
            System.out.println("MAIN MENU");
            System.out.println("=========");
            System.out.println("1. type 'play' to play");
            System.out.println("2. type 'history' to see the history of the game");
            System.out.println("3. type 'quit' to quit");
            Scanner playerScanners = new Scanner(System.in);
            String startMenuChoice = playerScanners.nextLine().toLowerCase();
            if (startMenuChoice.equals(MenuChoices.play.toString())) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Player 1, please enter your choice: ");
                String playerOneChoice = scanner.nextLine().toLowerCase();
                playSound(soundFileOne);
                System.out.println("\033[H\033[2J");
                System.out.flush();
                Thread.sleep(1000);
                String playerTwoChoice = getRandomChoice();
                playSound(soundFileTwo);
                /*
                //TODO: implement the logic for the ai portion of the game simple number generator
                //TODO: should return a random value from the arraylist of choices based on the random number
                * */
                if(Choices.contains(playerOneChoice) && Choices.contains(playerTwoChoice)){
                    gameRockPaperScissorsLogic(_humanPlayer, _aiPlayer, playerOneChoice, playerTwoChoice);
                }else{
                    System.out.println("!!!Invalid choice, please try again!!!");
                }
            }else if(startMenuChoice.equals(MenuChoices.history.toString())){
                System.out.println("==========================================================");
                System.out.println("Player history");
                _humanPlayer.getResults().forEach(value -> System.out.println("Player 1: " + value));
                _aiPlayer.getResults().forEach(value -> System.out.println("Player 2: " + value));
                System.out.println("==========================================================");
            }else if (startMenuChoice.equals(MenuChoices.quit.toString())){
                if(_humanPlayer.getScore() > _aiPlayer.getScore()){
                    System.out.println("==========================================================");
                    System.out.println("Player One wins!");
                    System.out.println("==========================================================");
                }else if(_humanPlayer.getScore() < _aiPlayer.getScore()){
                    System.out.println("==========================================================");
                    System.out.println("Player Two wins!");
                    System.out.println("==========================================================");
                }
                gameOver = true;
            }
        }
    }

    @Override
    public void gameRockPaperScissorsLogic(Player playerOne, Player playerTwo, String playerOneChoice, String playerTwoChoice) {
        switch (playerOneChoice) {
            case "rock":
                if (playerTwoChoice.equals("rock"))
                    break;
                else if (playerTwoChoice.equals("paper")) {
                    playerTwo.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player Two wins!");
                    playerTwo.setWins("win");
                    System.out.println("==========================================================");
                    break;
                } else {
                    playerOne.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player One wins!");
                    playerOne.setWins("win");
                    System.out.println("==========================================================");
                }
                break;
            case "paper":
                if (playerTwoChoice.equals("paper")) break;
                else if (playerTwoChoice.equals("scissors")) {
                    playerTwo.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player Two wins!");
                    playerTwo.setWins("win");
                    System.out.println("==========================================================");
                    break;
                } else {
                    playerOne.updateScore();
                    System.out.println("==========================================================");
                    playerOne.setWins("win");
                    System.out.println("Player One wins!");
                    System.out.println("==========================================================");
                }
                break;
            case "scissors":
                if (playerTwoChoice.equals("scissors")) break;
                else if (playerTwoChoice.equals("rock")) {
                    playerTwo.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player Two wins!");
                    playerTwo.setWins("win");
                    System.out.println("==========================================================");
                    break;
                } else {
                    playerOne.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player One wins!");
                    playerOne.setWins("win");
                    System.out.println("==========================================================");
                    break;
                }

        }
    }

    private String getRandomChoice(){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        return Choices.get(randomNumber);
    }

    public Player getAIPlayer(){
        return _aiPlayer;
    }
    public static synchronized void playSound(final String soundFile){
        new Thread(new Runnable() {
            File file = new File(soundFile);
            public void run() {
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
