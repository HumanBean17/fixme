package com.router;

public enum Ports {
    MARKET_SERVER(5000),
    BROKER_SERVER(5001);

    int port;

    Ports(int port) {
        this.port = port;
    }
}
