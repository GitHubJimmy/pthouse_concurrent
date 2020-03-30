package com.pthouse.thread;

/**
 * Demo class
 *
 * @author pthouse boss
 * @date 2020/3/26 17:08
 */
public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("我是一个线程" + Thread.currentThread().getName());
    }
}
