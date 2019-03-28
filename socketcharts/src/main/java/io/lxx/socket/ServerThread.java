package io.lxx.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                String str = br.readLine();
                System.out.println(str);
                for(Socket so :ServerTest.list){
                    if(so!=socket){
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                        bw.write(str);
                        bw.newLine();
                        bw.flush();
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
