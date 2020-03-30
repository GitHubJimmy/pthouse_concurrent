package thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Demo class
 *
 * @author pthouse boss
 * @date 2020/3/26 17:08
 */
public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.currentThread().join(3000);//实际最终还是调用的wait();
//            LockSupport.park();
//            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (this) {
            try {
//                wait();//wait必须在同步块中
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("我是一个线程" + Thread.currentThread().getName());
    }
}
