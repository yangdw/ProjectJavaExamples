package manon.java.network.bio2;

import manon.java.network.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("The time server is start, port is " +  port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while(true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null){
                System.out.println("The time server close.");
                server.close();
                server = null;
            }
        }
    }
}
