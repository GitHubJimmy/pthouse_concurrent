package com.pthouse.thread;

import java.util.concurrent.Callable;

/**
 * 实现Callable
 *
 * @author pthouse boss
 * @date 2020/3/26 17:41
 */
public class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("我是一个异步任务");
        return "线程：" + Thread.currentThread().getName() + "执行完毕";
    }
}
