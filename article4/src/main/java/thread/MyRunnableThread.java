package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demo class
 *
 * @author pthouse boss
 * @date 2020/3/26 17:08
 */
public class MyRunnableThread implements Runnable {
    private volatile AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "在为顾客点餐。" + count.get());

    }
}
