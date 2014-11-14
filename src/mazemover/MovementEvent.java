package mazemover;
/**
 * this class represents any movement that the server should receive and process
 * @author alecastle
 */
public class MovementEvent
{
    /**
     * possible move types
     */
    public static String[] movetypechoices = new String[]{"North","South","East","West","Clockwise","Counterclockwise"};
    /**
     * direction of this MovementEvent
     */
    public String movetype;
    /**
     * change in the horizontal direction (left is negative, right is positive)
     */
    public int horizontalchange;
    /**
     * change in the vertical direction (down is negative, up is positive)
     */
    public int verticalchange;
    /**
     * player who initiated the movement
     */
    public Player player;
}
