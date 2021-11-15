package com.chattserver;

public class Task implements Runnable {

    private final int PORT;

    public Task(int port) {
        this.PORT = port;
    }

    @Override
    public void run() {
        Server server = new Server(PORT);
        server.start();

    }

}
