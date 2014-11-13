/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Trivial client for the date server.
 */
public class TestClient {
   public static Socket s;
   public static BufferedReader fromServer;
   public static PrintWriter toServer;
   public volatile static JFrame mainFrame; 
   public static void main(String[] args) throws IOException {
      String serverAddress = JOptionPane.showInputDialog(
         "Enter IP Address of a machine that is\n" +
         "running the game service on port 9390:");
      connectToServer(serverAddress);
      BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
      String answer = input.readLine();
      PrintWriter out =new PrintWriter(s.getOutputStream(),true);
      JOptionPane.showMessageDialog(null, answer);
      JButton button = new JButton();
      button.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent ae) {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
      });
      System.out.println(input.readLine());

      System.exit(0);
   }
   
   public static void chatClient(){
      Thread thread= new Thread(){
         @Override public void run(){
         
         }
      };
      thread.start();
   }
   
   public static void connectToServer(String serverAddress) throws IOException{
     s = new Socket(serverAddress, 9390);
     fromServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
     toServer=new PrintWriter(s.getOutputStream(),true);
     
   }
   public static void sendChat(String message) throws IOException{
      OutputStream pos=s.getOutputStream();
      ObjectOutputStream poos= new ObjectOutputStream(pos);
      poos.writeObject(message);
   }
   public static void sendBoardMovement(Object obj) throws IOException{
      OutputStream pos=s.getOutputStream();
      ObjectOutputStream poos= new ObjectOutputStream(pos);
      poos.writeObject(obj);
   }
   public static void chatHandler(String chat){
      
   }
   public static void boardHandler(Object obj){
      
   }
   public static void outOfTurnHandler(){
      
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
}