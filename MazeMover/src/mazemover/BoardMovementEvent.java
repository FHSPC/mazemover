package mazemover;
/**
 * this class represents the board movement, as interpreted by the server as a MovementEvent
 * @author alecastle
 */
public class BoardMovementEvent extends MovementEvent
{
    public BoardMovementEvent(int direction, int horizontal, int vertical, Player player)
    {
        this.movetype = super.movetypechoices[direction];
        this.horizontalchange = horizontal;
        this.verticalchange = vertical;
        this.player = player;
    }
}
