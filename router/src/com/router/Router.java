package com.router;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Router {

    public static void main(String[] args) {
        Server brokerServer = new Server(Ports.BROKER_SERVER.port);
        Thread brokerServerThread = new Thread();
        brokerServerThread.start();

        Server marketServer = new Server(Ports.MARKET_SERVER.port);
        Thread marketServerThread = new Thread();
        marketServerThread.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while (true) {
            command = null;
            try {
                command = br.readLine();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            if (command != null && command.equalsIgnoreCase("exit")) {
                brokerServer.shutDown();
                marketServer.shutDown();
                System.out.println("shutdown");
                break;
            }
        }
    }
}
