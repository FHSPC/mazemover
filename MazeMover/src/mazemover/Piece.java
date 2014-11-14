package mazemover;
import javax.swing.ImageIcon;
/**
 * this class represents a mobile piece of the maze
 * @author alecastle
 */
public class Piece
{
    /**
     * the Piece shape
     */
    public ImageIcon type;
    /**
     * Item present on the Piece, if applicable
     */
    public Item item;
    /**
     * Player present on the Piece, if applicable
     */
    public Player player;
    /**
     * Card present on the Piece, if applicable
     */
    public Card card;
    private boolean hasitem;
    private boolean hasplayer;
    private boolean hascard;
    public Piece(String file)
    {
        //
    }
    /**
     * checks whether the Piece contains an Item
     * @return 
     */
    public boolean hasItem()
    {
        return hasitem;
    }
    /**
     * checks whether the Piece contains a Player
     * @return 
     */
    public boolean hasPlayer()
    {
        return hasplayer;
    }
    /**
     * checks whether the Piece contains a Card
     * @return 
     */
    public boolean hasCard()
    {
        return hascard;
    }
    /**
     * adds a Player to the Piece. hasPlayer() will now return true
     * @param player
     * @throws Exception if a Player cannot be added
     */
    public void addPlayer(Player player) throws Exception
    {
        //
    }
    /**
     * adds an Item to the Piece. hasItem() will now return true
     * @param item
     * @throws Exception if an Item cannot be added
     */
    public void addItem(Item item) throws Exception
    {
        //
    }
    /**
     * adds a Card to the Piece. hasCard() will now return true
     * @param card
     * @throws Exception if a Card cannot be added
     */
    public void addCard(Card card) throws Exception
    {
        //
    }
    /**
     * removes a Player from the Piece. hasPlayer() will now return false
     */
    public void removePlayer()
    {
        //
    }
    /**
     * removes an Item from the Piece. hasItem() will now return false
     */
    public void removeItem()
    {
        //
    }
    /**
     * removes a Card from the Piece. hasCard() will now return false
     */
    public void removeCard()
    {
        //
    }
}
