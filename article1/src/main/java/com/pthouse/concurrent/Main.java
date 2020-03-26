package com.pthouse.concurrent;

import com.pthouse.concurrent.blocking.BlockingOrder;
import com.pthouse.concurrent.blocking.NonBlockingOrder;

/**
 * Demo class
 *
 * @author jimmy
 * @date 2020/3/26 10:12
 */
public class Main {

    public static void main(String[] args) {
        int times = 10;

        BlockingOrder blockingOrder = new BlockingOrder();
        NonBlockingOrder nonBlockingOrder = new NonBlockingOrder();

        for (int index = 0; index < times; index++) {
            int id = index;
            Thread thread = new Thread(() -> {
                try {
                    nonBlockingOrder.order("顾客" + id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }


}
