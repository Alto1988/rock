package Classes;

import Classes.MenuChoices;
import Interfaces.IGameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class GameState implements IGameState {

    private final ArrayList<String> Choices = new ArrayList<String>(Arrays.asList("rock", "paper", "scissors"));
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    public GameState(Player _playerOne, Player _playerTwo) {
       playerOne = _playerOne;
       playerTwo = _playerTwo;
    }

    public void gameRockPaperScissorsLogic(Player playerOne, Player playerTwo, String playerOneChoice, String playerTwoChoice){
        //Inide here we find the winner and update that player's score
        System.out.println("Player One chose " + playerOneChoice);
        System.out.println("Player Two chose " + playerTwoChoice);
        switch(playerOneChoice){
            case "rock":
                if(playerTwoChoice.equals("rock"))
                    break;
                else if(playerTwoChoice.equals("paper")){
                    playerTwo.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player Two wins!");
                    playerTwo.setWins("win");
                    System.out.println("==========================================================");
                    break;
                }else {
                    playerOne.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player One wins!");
                    playerOne.setWins("win");
                    System.out.println("==========================================================");
                }
                break;
            case "paper":
                if(playerTwoChoice.equals("paper"))break;
                else if (playerTwoChoice.equals("scissors")){
                    playerTwo.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player Two wins!");
                    playerTwo.setWins("win");
                    System.out.println("==========================================================");
                    break;
                }else {
                    playerOne.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player One wins!");
                    playerOne.setWins("win");
                    System.out.println("==========================================================");
                }
                break;
            case "scissors":
                if(playerTwoChoice.equals("scissors"))break;
                else if(playerTwoChoice.equals("rock")){
                    playerTwo.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player Two wins!");
                    playerTwo.setWins("win");
                    System.out.println("==========================================================");
                    break;
                }else {
                    playerOne.updateScore();
                    System.out.println("==========================================================");
                    System.out.println("Player One wins!");
                    playerOne.setWins("win");
                    System.out.println("==========================================================");
                    break;
                }

        }
    }
    public void startGame() throws InterruptedException {
        boolean gameOver = false;
        boolean choiceIsValid = false;
        Scanner howManyPlayers = new Scanner(System.in);
        while(!choiceIsValid){
            System.out.println("How many players?");
            int numberOfPlayers = howManyPlayers.nextInt();
            if(numberOfPlayers == 1){
                choiceIsValid = true;
                while(!gameOver){
                    //TODO: implement game logic for an individual player
                    AIGameState aiGame = new AIGameState(playerOne);
                    aiGame.startGame();
                    gameOver = true;
                }
            }else if(numberOfPlayers == 2){
                choiceIsValid = true;
                while(!gameOver){
                    //TODO: implement game logic
                    //Do some stuff here
                    System.out.println("Welcome to Rock, Paper, Scissors!");
                    System.out.println("MAIN MENU");
                    System.out.println("=========");
                    System.out.println("1. type 'play' to play");
                    System.out.println("2. type 'history' to see the history of the game");
                    System.out.println("3. type 'quit' to quit");
                    Scanner playerScanners = new Scanner(System.in);
                    String startMenuChoice = playerScanners.nextLine().toLowerCase();
                    if(startMenuChoice.equals(MenuChoices.play.toString())){
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Player 1, please enter your choice: ");
                        String playerOneChoice = scanner.nextLine().toLowerCase();
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        Thread.sleep(1000);
                        System.out.println("Player 2, please enter your choice: ");
                        String playerTwoChoice = scanner.nextLine().toLowerCase();
                        try {
                            if(Choices.contains(playerOneChoice) && Choices.contains(playerTwoChoice)){

                                gameRockPaperScissorsLogic(playerOne, playerTwo,playerOneChoice, playerTwoChoice);
                            }
                        }catch (Exception e){
                            System.out.println("Choices were invalid");
                        }
                    }else if(startMenuChoice.equals(MenuChoices.history.toString())){
                        //display the history of the game
                        System.out.println("==========================================================");
                        System.out.println("Player history");
                        playerOne.getResults().forEach(value -> System.out.println("Player 1: " + value));
                        playerTwo.getResults().forEach(value -> System.out.println("Player 2: " + value));
                        System.out.println("==========================================================");
                    }else if(startMenuChoice.equals(MenuChoices.quit.toString())){
                        if(playerOne.getScore() > playerTwo.getScore()){
                            System.out.println("==========================================================");
                            System.out.println("Player One wins!");
                            System.out.println("==========================================================");
                        }else if(playerOne.getScore() < playerTwo.getScore()){
                            System.out.println("==========================================================");
                            System.out.println("Player Two wins!");
                            System.out.println("==========================================================");
                        }
                        gameOver = true;
                    }
                }
            }else {
                System.out.println("Invalid number of players");
                choiceIsValid = false;
            }
        }

    }
}

