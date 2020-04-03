package com.pthouse.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo class
 *
 * @author pthouse boss
 * @date 2020/3/26 10:12
 */
public class Main {

    private volatile static int anInt = 0;

    private static int a = 0;
    private static boolean flag = false;

    public static void main(String[] args) {
        atomic();
    }

    private static void atomic() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int num = 100;
        CountDownLatch latch = new CountDownLatch(num);

        for (int index = 0; index < num; index++) {
            executorService.submit(() -> {
                anInt++;
                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(anInt);
        executorService.shutdown();
    }

}
