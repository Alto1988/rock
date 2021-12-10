import java.util.Scanner;




public class Main {
    public enum MenuChoices {
        play,
        history,
        quit
    }
    public static void gameRockPaperScissorsLogic(String playerOneChoice, String playerTwoChoice){
        //Inide here we find the winner and update that player's score
    }


    public static void main(String[] args) {
        boolean gameOver = false;
        boolean choiceIsValid = false;

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
                    }else if(startMenuChoice.equals(MenuChoices.history.toString())){
                        //display the history of the game
                    }else if(startMenuChoice.equals(MenuChoices.quit.toString())){
                        gameOver = true;
                    }
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Player 1, please enter your choice: ");
//            String playerOneChoice = scanner.nextLine();
//            System.out.println("Player 2, please enter your choice: ");
//            String playerTwoChoice = scanner.nextLine();
//            gameRockPaperScissorsLogic(playerOneChoice, playerTwoChoice);
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
                        //We start the game
                    }else if(startMenuChoice.equals(MenuChoices.history.toString())){
                        //display the history of the game
                    }else if(startMenuChoice.equals(MenuChoices.quit.toString())){
                        gameOver = true;
                    }
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Player 1, please enter your choice: ");
//            String playerOneChoice = scanner.nextLine();
//            System.out.println("Player 2, please enter your choice: ");
//            String playerTwoChoice = scanner.nextLine();
//            gameRockPaperScissorsLogic(playerOneChoice, playerTwoChoice);
                }
            }else {
                System.out.println("Invalid number of players");
                choiceIsValid = false;
            }
        }
    }
}
