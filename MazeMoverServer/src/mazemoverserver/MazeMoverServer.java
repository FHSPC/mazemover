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
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
//   static{
//      InputStream inputStream = "".getClass().getClassLoader().getResourceAsStream(serverconfigpath);
//      try {
//         serverconfig.load(inputStream);
//      } catch (IOException ex) {
//         Logger.getLogger(MazeMoverServer.class.getName()).log(Level.SEVERE, null, ex);
//      }
//      if (inputStream == null) {
//         try {
//            throw new FileNotFoundException("property file '" + serverconfigpath + "' not found in the classpath");
//         } catch (FileNotFoundException ex) {
//            Logger.getLogger(MazeMoverServer.class.getName()).log(Level.SEVERE, null, ex);
//         }
//      }
//   }
   
   public static void main(String[] args) throws IOException{
      ServerSocket listener = new ServerSocket(9390);
      while (true) {
         Socket socket = listener.accept();
         async(socket,new function(){
            @Override
            public void run(Object sock) {
               Socket socket= (Socket) sock;
               try {
                  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                  out.println(new Date().toString());
                  BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                  String name=input.readLine();
                  System.out.print(name);
                  out.println("hello "+name);
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
