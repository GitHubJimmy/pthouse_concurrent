package com.pthouse.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Demo class
 *
 * @author pthouse boss
 * @date 2020/3/26 16:14
 */
public class Main {
    public static void main(String[] args) {
        createThread();
        createFutureThread();
    }

    private static void createThread(){
//        Thread thread = new Thread(()->System.out.println("我是一个线程" + Thread.currentThread().getName()));
        Thread thread = new Thread(new MyRunnableThread());
        thread.start();
    }

    private static void createFutureThread(){
        FutureTask<String> futureTask = new FutureTask<>(new MyTask());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
