package com.broker;

import com.core.client.Client;

public class Broker {

    public static void main(String[] args) {
        Client client = new Client("Broker");
        Thread clientThread = new Thread(client);
        clientThread.start();
        try {
            clientThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Client.handleInput(client);
    }
}
