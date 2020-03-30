package thread;

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
        threadStateTerminated();
    }

    private static void threadStateNew(){
        Thread thread = new Thread(new MyRunnableThread());
        System.out.println("thread state:" + thread.getState()); //thread state:RUNNABLE
    }


    private static void threadStateRunnable(){
        Thread thread = new Thread(new MyRunnableThread());
        thread.start();
        System.out.println("thread state:" + thread.getState()); //thread state:RUNNABLE
    }

    private static void threadStateBlocking(){
        Runnable runnable = new MyRunnableThread();
        Thread threadA = new Thread(runnable);
        threadA.start();

        Thread threadB = new Thread(runnable);
        threadB.start();

        try {
            //保证输出时threadB已经被调用了
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread state:" + threadB.getState()); //thread state:BLOCKED
    }

    private static void threadStateWaiting(){
        Runnable runnable = new MyRunnableThread();
        Thread threadA = new Thread(runnable);
        threadA.start();

        Thread threadB = new Thread(runnable);
        threadB.start();
        try {
            //保证输出时threadB已经被调用了
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread state:" + threadB.getState());
    }

    private static void threadStateTerminated(){
        Thread threadB = new Thread(()->{System.out.println("finish");});
        threadB.start();
        try {
            //保证输出时threadB已经被调用了
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread state:" + threadB.getState()); //thread state:TERMINATED
    }

}
