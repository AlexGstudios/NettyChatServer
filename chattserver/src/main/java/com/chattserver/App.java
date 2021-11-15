package com.chattserver;

public class App {
    public static void main(String[] args) {
        Task task = new Task(5000);
        Task task2 = new Task(5050);

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}