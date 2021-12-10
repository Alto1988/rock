package Classes;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int _score;
    private final List<String> _results = new ArrayList<>();

    public Player(){
        _score = 0;
    }
    public void setWins(String result){
        //Basically everytime a player wins, or loses, the score is updated
        _results.add(result);
    }
    public void updateScore(){
       _score++;
    }
    public int getScore(){
        return _score;
    }
    public String getName(){
        return this.getClass().getSimpleName();
    }
    public List<String> getResults(){
        return _results;
    }
}
