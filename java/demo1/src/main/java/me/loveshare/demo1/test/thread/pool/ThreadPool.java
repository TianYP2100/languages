package me.loveshare.demo1.test.thread.pool;

import java.util.concurrent.ExecutorService;

/**
 * 定义一个类，主要是为了让线程池执行里面的executeMethod方法
 */
public class ThreadPool {

    /**
     * 执行方法
     *
     * @param es 线程池
     */
    public void executeMethod(ExecutorService es) {
        //让该线程池添加10个Thread1线程并执行
        for (int x : new int[10]) {
            es.execute(new Thread1());
        }
    }
}
