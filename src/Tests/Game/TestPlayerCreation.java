package Tests.Game;

import Classes.AIGameState;
import Classes.GameState;
import Classes.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;


public class TestPlayerCreation {
    //BEGINNING OF THE TEST FOR THE HUMAN VS HUMAN PORTION OF THE GAME
    @Test
    public void isPlayerCreated() {
        Player testPlayer = new Player();
        Assertions.assertNotNull(testPlayer);
//        Assertions.assertNull(testPlayer);
    }

    @Test
    public void isPlayerCreatedFalse(){
        Player testPlayer = null;
        Assertions.assertNull(testPlayer);
//        Assertions.assertNotNull(testPlayer);
    }
    @Test
    public void testGameStateIsCreated(){
        GameState testGameState = new GameState(new Player(), new Player());
        Assertions.assertNotNull(testGameState);
    }

    @Test
    public void testGameStateReturnValues() throws InterruptedException {
        //Seeing if the game state returns the correct values
        Player player1 = new Player();
        Player player2 = new Player();
        Player anotherPlayer1 = new Player();
        Player anotherPlayer2 = new Player();
        GameState testGameState = new GameState(player1, player2);
        GameState anotherGameState = new GameState(anotherPlayer1, anotherPlayer2);


        testGameState.gameRockPaperScissorsLogic(player1, player2, "rock", "paper");
        Assertions.assertEquals(player2.getResults(), Arrays.asList("win"));

        testGameState.gameRockPaperScissorsLogic(anotherPlayer1, anotherPlayer2, "rock", "scissors");
        Assertions.assertEquals(anotherPlayer1.getResults(), Arrays.asList("win"));
    }

    @Test
    public void gameStateCrashDoes() throws InterruptedException {
        Player player1 = new Player();
        Player player2 = null;
        GameState testGameState = new GameState(player1, player2);
        Assertions.assertThrows(NullPointerException.class, () -> {
            testGameState.gameRockPaperScissorsLogic(player1, player2, "rock", "paper");
        });
    }
    //END OF THE TEST FOR THE HUMAN VS HUMAN PORTION OF THE GAME

    //BEGINNING OF THE TEST FOR THE HUMAN VS AI PORTION OF THE GAME
    @Test
    public void testGameCanStartWithOnePlayer(){
        Player humanPlayer = new Player();
        AIGameState testGameState = new AIGameState(humanPlayer);
        Assertions.assertNotNull(testGameState);
    }

    @Test
    public void testAIPlayerIsUniqueToGameStateClass() {
        AIGameState testGameState = new AIGameState(new Player());
        AIGameState anotherGameState = new AIGameState(new Player());

        Optional<AIGameState> testOptional = Optional.of(testGameState);
        Optional<AIGameState> anotherOptional = Optional.of(anotherGameState);

        boolean isPresent = testOptional.filter(gameState -> gameState.getAIPlayer() != null).isPresent();
        boolean isPresent2 = anotherOptional.filter(gameState -> gameState.getAIPlayer() != null).isPresent();


        Assertions.assertNotEquals(testGameState.getAIPlayer().hashCode(), anotherGameState.getAIPlayer().hashCode());
        Assertions.assertTrue(isPresent);
        Assertions.assertTrue(isPresent2);
        Assertions.assertNotNull(testGameState.getAIPlayer());

    }

    @Test
    public void gameStateCrashDoesAI()throws InterruptedException {
        Player player1 = new Player();

        AIGameState testGameState = new AIGameState(player1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            testGameState.gameRockPaperScissorsLogic(player1, null, "rock", "paper");
        });
    }

    //END OF THE TEST FOR THE HUMAN VS AI PORTION OF THE GAME
}
