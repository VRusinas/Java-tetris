package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread 
{
    private GameArea gamearea; 
    private Game game;
    private int score;
    public GameThread(GameArea gamearea, Game gameForm) 
    {
        this.gamearea = gamearea;
        this.game = gameForm;
    }
    @Override
    public void run()
    {
        while (true)
        { 
            gamearea.spawnBlock();
            while (gamearea.moveBlockDown() == true) 
            {
                try {
                   
                    if(score < 5)
                    {
                        Thread.sleep(600); 
                    }
                    else  Thread.sleep(300);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(gamearea.isBlockOutOfBounds() == true)
            {
                System.out.println("Game Over");
                System.out.println("Your score: " + score);
                break;
             
            }
            gamearea.moveBlockToBg();
            score += gamearea.clearLines();
            gamearea.clearLines();
            game.updateScore(score);
        }
    }
}
