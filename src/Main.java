import Classes.GameState;
import Classes.Player;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;




public class Main {


    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException {

        GameState gameState = new GameState(new Player(), new Player());
        gameState.startGame();

    }
}
