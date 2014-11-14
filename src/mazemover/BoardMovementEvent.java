package mazemover;
/**
 * this class represents the board movement, as interpreted by the server as a MovementEvent
 * @author alecastle
 */
public class BoardMovementEvent extends MovementEvent
{
    public BoardMovementEvent(int direction)
    {
        this.movetype = MovementEvent.movetypechoices[direction];
    }
}
