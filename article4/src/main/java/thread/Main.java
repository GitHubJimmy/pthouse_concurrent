package thread;

import java.util.concurrent.*;

/**
 * Demo class
 *
 * @author pthouse boss
 * @date 2020/3/26 16:14
 */
public class Main {
    public static void main(String[] args) {
//        createFixThreadPool();
//        createSingleThreadPool();
//        createScheduleThreadPool();

        createThreadPool();
    }

    private static void createThreadPool(){
        ExecutorService executorService = new ThreadPoolExecutor(5, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new CustomThreadFactory("pthouse"),new ThreadPoolExecutor.AbortPolicy());
        executorService.submit(new MyRunnableThread());
    }


    private static void createFixThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2,new CustomThreadFactory("pthouse"));
        MyRunnableThread task = new MyRunnableThread();
        int num = 20;
        for (int index = 0; index < num; index++) {
            executorService.submit(task);
        }
        executorService.shutdown();
    }


    private static void createSingleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnableThread task = new MyRunnableThread();
        int num = 5;
        for (int index = 0; index < num; index++) {
            executorService.submit(task);
        }
    }

    private static void createScheduleThreadPool() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        MyRunnableThread task = new MyRunnableThread();
        executorService.scheduleAtFixedRate(task,0,1, TimeUnit.SECONDS);
    }

}
