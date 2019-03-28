package io.lxx.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class ServerTest {
    static ArrayList<Socket> list = new ArrayList<Socket>();

    public static void main(String[] args) {
        try {
            ServerSocket serSocket = new ServerSocket(9999);
            while(true){
                Socket socket = serSocket.accept();
                list.add(socket);

                ServerThread th = new ServerThread(socket);
                th.start();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
