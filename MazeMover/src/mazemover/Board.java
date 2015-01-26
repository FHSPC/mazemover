package mazemover;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
public class Board extends JFrame
{
    public JPanel board;
    public JPanel pieces;
    public JPanel right;
    public JPanel left;
    public JPanel up;
    public JPanel down;
    public JPanel chat;
    public JPanel cards;
    public Board()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Maze Mover");
        board.add(pieces, BorderLayout.CENTER);
        board.add(right, BorderLayout.EAST);
        board.add(left, BorderLayout.WEST);
        board.add(up, BorderLayout.NORTH);
        board.add(down, BorderLayout.SOUTH);
        this.add(board, BorderLayout.CENTER);
        this.add(chat, BorderLayout.SOUTH);
        this.add(cards, BorderLayout.WEST);
        this.setEnabled(true);
        this.setVisible(true);
    }
}