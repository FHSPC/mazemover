
package mazemover_server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mazemover_server {
    public static void main(String[] args){
////        ServerSocket listener = null;
////        try {
////            listener = new ServerSocket(9390);
////        } catch (IOException ex) {
////            Logger.getLogger(Mazemover_server.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        while (true) {
////            Socket socket = null;
////            try {
////                socket = listener.accept();
////            } catch (IOException ex) {
////                Logger.getLogger(Mazemover_server.class.getName()).log(Level.SEVERE, null, ex);
////            }
////            async(socket,new function(){
////
////                @Override
////                public void run(Object sock) {
////                    Socket socket= (Socket) sock;
////                    try {
////                        PrintWriter out =
////                            new PrintWriter(socket.getOutputStream(), true);
////                        out.println(new Date().toString());
////                        BufferedReader input =
////                            new BufferedReader(new InputStreamReader(socket.getInputStream()));
////                        String name=input.readLine();
////                        System.out.print(name);
////                        out.println("hello "+name);
////                        async("hey",new function(){
////
////                            @Override
////                            public void run(Object obj) {
////                                System.out.println(obj);
////                            }
////                        });
////                    }catch (IOException ex) {
////                        Logger.getLogger(Mazemover_server.class.getName()).log(Level.SEVERE, null, ex);
////                    } finally {
////                        try {
////                            socket.close();
////                        } catch (IOException ex) {
////                            Logger.getLogger(Mazemover_server.class.getName()).log(Level.SEVERE, null, ex);
////                        }
////                    }
////                }   
//
////                });
////                try {
////                    PrintWriter out =
////                        new PrintWriter(socket.getOutputStream(), true);
////                    out.println(new Date().toString());
////                    BufferedReader input =
////                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
////                    String name=input.readLine();
////                    System.out.print(name);
////                    out.println("hello "+name);
////                    async("hey",new function(){
////
////                        @Override
////                        public void run(Object obj) {
////                            System.out.println(obj);
////                        }
////                    });
////                } finally {
////                    socket.close();
////                }
////            }
////        }
////        finally {
////            listener.close();
////        }
//        //    });
//       // }
//    }
//    //function to be done with the object passed in an asyncrnous way
////    public static void async(Object obj,function func)
////    {
////        Thread thread = new Thread(){
////            @Override
////            public void run(){
////                func.run(obj);
////            };
////        };
////        thread.setDaemon(true);
////        thread.start();
////    }
//    
//    
}
