package com.pthouse.thread;

/**
 * 继承Thread类
 *
 * @author pthouse boss
 * @date 2020/3/26 16:42
 */
public class MyExtendThread extends Thread {
    @Override
    public void run() {
        System.out.println("我是一个线程" + Thread.currentThread().getName());
    }
}
