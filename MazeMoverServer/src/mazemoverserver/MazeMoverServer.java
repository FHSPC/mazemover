/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazemoverserver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author darclaw
 */
public class MazeMoverServer {
   public static Properties serverconfig=new Properties();
   public static String  serverconfigpath="serverconfig.properties";
   public static int turns=0;
   public static int whoPlayes=0;
   public static int numPlayers=0;
   public static ArrayList<PlayerSocket> sockets= new ArrayList<>();
   public static void main(String[] args) throws IOException{
      ServerSocket listener = new ServerSocket(9390);
      mainLoop:
      while (true) {
         PlayerSocket socket = (PlayerSocket) listener.accept();
         sockets.add(socket);
         socket.playerNum=numPlayers;
         numPlayers++;
         async(socket,new function(){
            @Override
            public void run(Object sock) {
               PlayerSocket socket= (PlayerSocket) sock;
               try {
//                  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                  out.println(new Date().toString());
                  
                     InputStream inStream= socket.getInputStream();
                     ObjectInputStream objInStream = new ObjectInputStream(inStream);
                     try {
                        Object obj = objInStream.readObject();
                        if(obj instanceof String)
                        {
                           for(PlayerSocket Player:sockets){
                                 OutputStream pos=Player.getOutputStream();
                                 ObjectOutputStream poos= new ObjectOutputStream(pos);
                                 poos.writeObject(obj);
                           }
                        }
                        else{
                           if(socket.playerNum==turns%numPlayers)
                           {
                              for(PlayerSocket Player:sockets){
                                 OutputStream pos=Player.getOutputStream();
                                 ObjectOutputStream poos= new ObjectOutputStream(pos);
                                 poos.writeObject(obj);
                              }
                              OutputStream pos=socket.getOutputStream();
                              ObjectOutputStream poos= new ObjectOutputStream(pos);
                              // މis u789
                              poos.writeObject("މoutOfTurn");
                           }
                        }
                     } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MazeMoverServer.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     turns++;
//                  BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
//                  String name=input.readLine();
//                  System.out.print(name);
//                  out.println("hello "+name);
               }catch (IOException ex) {
                  Logger.getLogger(MazeMoverServer.class.getName()).log(Level.SEVERE, null, ex);
               } finally {
                  try {
                     socket.close();
                 } catch (IOException ex) {
                     Logger.getLogger(MazeMoverServer.class.getName()).log(Level.SEVERE, null, ex);
                  }
               }
            }
         });
      }
    }
    
    //function to be done with the object passed in an asyncrnous way
    public static void async(Object obj,function func)
    {
        Thread thread = new Thread(){
            @Override
            public void run(){
               func.run(obj);
            };
        };
        //thread.setDaemon(true);
        thread.start();
    }
    
}
