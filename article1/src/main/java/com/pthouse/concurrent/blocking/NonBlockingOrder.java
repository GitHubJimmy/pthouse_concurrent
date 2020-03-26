package com.pthouse.concurrent.blocking;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 非阻塞
 *
 * @author T-House Boss
 * @date 2020/3/26 10:41
 */
public class NonBlockingOrder {
    /**
     * 构建一个不可修改的list这样就能在多线程下保证数据安全
     */
    private final List<String> menus = Collections.unmodifiableList(Arrays.asList("龙井","碧螺春","瓜子"));


    public void order(String name) throws InterruptedException {
        Random random = new Random();
        //点餐花的时间
        Thread.sleep(1000);
        //为了简单只取一个
        System.out.println(name + "点了" + menus.get(random.nextInt(menus.size())) + ",点单时间：" + System.currentTimeMillis());
    }
}
