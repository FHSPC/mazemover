package mazemover;
/**
 * this class represents the movement of a player, as interpreted by the server as a MovementEvent
 * @author alecastle
 */
public class PlayerMovementEvent extends MovementEvent
{
    public PlayerMovementEvent(int direction, int horizontal, int vertical, Player player)
    {
        this.movetype = super.movetypechoices[direction];
        this.horizontalchange = horizontal;
        this.verticalchange = vertical;
        this.player = player;
    }
}
