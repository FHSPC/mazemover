package mazemover;
<<<<<<< HEAD
=======

>>>>>>> 4477609b690ef9d58c8662883eafdcf13bbc6f46
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
<<<<<<< HEAD
=======

>>>>>>> 4477609b690ef9d58c8662883eafdcf13bbc6f46
/**
 * this is merely a meek gateway to the rest of our filepath
 * @author alecastle
 */
public class MazeMover
{
<<<<<<< HEAD
    public static Socket s;
    public static BufferedReader fromServer;
    public static PrintWriter toServer;
    public static void main(String[] args)
    {
       //
    }
    public static void connectToServer(String serverAddress) throws IOException
    {
        s = new Socket(serverAddress, 9390);
        fromServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
        toServer=new PrintWriter(s.getOutputStream(),true);
    }
    public static void sendChat(String message) throws IOException
    {
        OutputStream pos=s.getOutputStream();
        ObjectOutputStream poos= new ObjectOutputStream(pos);
        poos.writeObject(message);
    }
    public static void sendBoardMovement(Object obj) throws IOException
    {
        OutputStream pos=s.getOutputStream();
        ObjectOutputStream poos= new ObjectOutputStream(pos);
        poos.writeObject(obj);
    }
    public static void chatHandler(String chat)
    {

    }
    public static void boardHandler(Object obj)
    {
        //
    }
    public static void outOfTurnHandler()
    {

    }
    public static void severEventHandler() throws IOException, ClassNotFoundException
    {
        InputStream inStream= s.getInputStream();
        ObjectInputStream objInStream = new ObjectInputStream(inStream);
        Object obj = objInStream.readObject();
        if(obj instanceof String)
        {
            String message = (String)obj;
            //މis u789 
            if(message.equals("މoutOfTurn"))
            {
                outOfTurnHandler();
            }
            else
            {
                chatHandler(message);
            }
        }
        //pretend that this is if(obj isinstanceof MovementEvent
        else
        {
            boardHandler(obj);
        }
    }
=======
   public static Socket s;
   public static BufferedReader fromServer;
   public static PrintWriter toServer;
   public static void main(String[] args)
   {
       //
   }
   public static void connectToServer(String serverAddress) throws IOException
   {
      s = new Socket(serverAddress, 9390);
      fromServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
      toServer=new PrintWriter(s.getOutputStream(),true);
     
   }
   public static void sendChat(String message) throws IOException
   {
      OutputStream pos=s.getOutputStream();
      ObjectOutputStream poos= new ObjectOutputStream(pos);
      poos.writeObject(message);
   }
   public static void sendBoardMovement(Object obj) throws IOException
   {
      OutputStream pos=s.getOutputStream();
      ObjectOutputStream poos= new ObjectOutputStream(pos);
      poos.writeObject(obj);
   }
   public static void chatHandler(String chat)
   {
      
   }
   public static void boardHandler(Object obj)
   {
      
   }
   public static void outOfTurnHandler()
   {
      
   }
   public static void severEventHandler() throws IOException, ClassNotFoundException
   {
      InputStream inStream= s.getInputStream();
      ObjectInputStream objInStream = new ObjectInputStream(inStream);
      Object obj = objInStream.readObject();
      if(obj instanceof String)
      {
         String message = (String)obj;
         //މis u789 
         if(message.equals("މoutOfTurn"))
         {
            outOfTurnHandler();
         }
         else
         {
            chatHandler(message);
         }
      }
      //pretend that this is if(obj isinstanceof BoardMovementEvent
      else
      {
         boardHandler(obj);
      }
   }
>>>>>>> 4477609b690ef9d58c8662883eafdcf13bbc6f46
}
