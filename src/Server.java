import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;




public class Server {
    static  String str;

    public static  void runServer()  throws Exception {

        ServerSocket listener = new ServerSocket(40001);





        try {
            while (true) {
                Socket socket = listener.accept();
                socket.setTcpNoDelay(true);
                socket.setKeepAlive(true);
                System.out.println("Client Connected");
                try {
                    DataInput printin = new DataInputStream (socket.getInputStream());
                    while (null != ((str = printin.readLine())))
                    {
                        System.out.println(str);
                        GetData.setuid(str);
                        break;

                    }

                    break;











                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }


    }






}