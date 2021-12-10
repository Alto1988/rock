package Classes;

import Classes.MenuChoices;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class GameState {

    public static ArrayList<String> Choices = new ArrayList<String>(Arrays.asList("rock", "paper", "scissors"));
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    public GameState(Player _playerOne, Player _playerTwo) {
       playerOne = _playerOne;
       playerTwo = _playerTwo;
    }

    public static void gameRockPaperScissorsLogic(Player playerOne, Player playerTwo, String playerOneChoice, String playerTwoChoice){
        //Inide here we find the winner and update that player's score
        System.out.println("Player One chose " + playerOneChoice);
        System.out.println("Player Two chose " + playerTwoChoice);
        switch(playerOneChoice){
            case "rock":
                if(playerTwoChoice.equals("rock"))
                    break;
                else if(playerTwoChoice.equals("paper")){
                    playerTwo.updateScore();
                    playerTwo.setWins("win");
                    break;
                }else {
                    playerOne.updateScore();
                    playerOne.setWins("win");
                }
                break;
            case "paper":
                if(playerTwoChoice.equals("paper"))break;
                else if (playerTwoChoice.equals("scissors")){
                    playerTwo.updateScore();
                    playerTwo.setWins("win");
                    break;
                }else {
                    playerOne.updateScore();
                    playerOne.setWins("win");
                }
                break;
            case "scissors":
                if(playerTwoChoice.equals("scissors"))break;
                else if(playerTwoChoice.equals("rock")){
                    playerTwo.updateScore();
                    playerTwo.setWins("win");
                    break;
                }else {
                    playerOne.updateScore();
                    playerOne.setWins("win");
                    break;
                }

        }
    }
    public void startGame() {
        boolean gameOver = false;
        boolean choiceIsValid = false;

        Player playerOne = new Player();
        Player playerTwo = new Player();


        Scanner howManyPlayers = new Scanner(System.in);
        while(!choiceIsValid){
            System.out.println("How many players?");
            int numberOfPlayers = howManyPlayers.nextInt();
            if(numberOfPlayers == 1){
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
                    String startMenuChoice = playerScanners.nextLine();
                    if(startMenuChoice.equals(MenuChoices.play.toString())){
                        //We start the game
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Player 1, please enter your choice: ");
                        String playerOneChoice = scanner.nextLine();
                        if(Choices.contains(playerOneChoice)){
                            System.out.println("!!!!!!ENTER A VALID CHOICE!!!!!!");
                        }
                        System.out.println("Player 2, please enter your choice: ");
                        String playerTwoChoice = scanner.nextLine();
                        if(Choices.contains(playerTwoChoice)){
                            System.out.println("!!!!!!ENTER A VALID CHOICE!!!!!!");
                        }
                        gameRockPaperScissorsLogic(playerOne, playerTwo, playerOneChoice, playerTwoChoice);
                    }else if(startMenuChoice.equals(MenuChoices.history.toString())){
                        //display the history of the game
                    }else if(startMenuChoice.equals(MenuChoices.quit.toString())){
                        gameOver = true;
                    }
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
                    String startMenuChoice = playerScanners.nextLine();
                    if(startMenuChoice.equals(MenuChoices.play.toString())){
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Player 1, please enter your choice: ");
                        String playerOneChoice = scanner.nextLine();
                        if(!Choices.contains(playerOneChoice)){
                            System.out.println("!!!!!!ENTER A VALID CHOICE!!!!!!");
                        }
                        System.out.println("Player 2, please enter your choice: ");
                        String playerTwoChoice = scanner.nextLine();
                        if(!Choices.contains(playerTwoChoice)){
                            System.out.println("!!!!!!ENTER A VALID CHOICE!!!!!!");
                        }
                        gameRockPaperScissorsLogic(playerOne, playerTwo, playerOneChoice, playerTwoChoice);
                        //We start the game
                    }else if(startMenuChoice.equals(MenuChoices.history.toString())){
                        //display the history of the game
                        playerOne.getResults().forEach(value -> System.out.println("Player 1: " + value));
                        playerTwo.getResults().forEach(value -> System.out.println("Player 2: " + value));
                    }else if(startMenuChoice.equals(MenuChoices.quit.toString())){
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

