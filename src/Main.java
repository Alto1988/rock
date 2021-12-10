import Classes.GameState;
import Classes.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;




public class Main {


    public static void main(String[] args) {

        GameState gameState = new GameState(new Player(), new Player());
        gameState.startGame();

    }
}
