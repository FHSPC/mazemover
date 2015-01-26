package mazemover;
import javax.swing.ImageIcon;
/**
 * this class represents a Player object
 * @author alecastle
 */
public class Player
{
    /**
     * image used for the player on the board
     */
    public ImageIcon display;
    /**
     * whether it is the Player's turn
     */
    public boolean turn;
    /**
     * the Player's score
     */
    public int score = 0;
    /**
     * two element array representing the player's location on the board
     */
    public int[] location = new int[2];
    public Player(String file)
    {
        //
    }
}
