package manon.java.network.nio2;

import java.io.IOException;

public class TimeServer {
    public static void main(String[] args) throws IOException{
        int port = 8080;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
