package com.pthouse.concurrent.blocking;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 阻塞
 *
 * @author pthouse boss
 * @date 2020/3/26 10:16
 */
public class BlockingOrder {
    private List<String> menus = Arrays.asList("龙井", "碧螺春", "瓜子");


    /**
     * 这里加synchronized保证多线程操作menus时不会出错
     */
    public synchronized void order(String name) throws InterruptedException {
        Random random = new Random();
        //点餐花的时间
        Thread.sleep(1000);
        //为了简单只取一个
        System.out.println(name + "点了" + menus.get(random.nextInt(menus.size())) + ",点单时间：" + System.currentTimeMillis());
    }
}
