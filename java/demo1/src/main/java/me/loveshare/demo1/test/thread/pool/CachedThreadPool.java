package me.loveshare.demo1.test.thread.pool;

import java.util.concurrent.*;

/**
 * 无界线程池，可以进行自动线程回收:<br/>
 * 这种线程池也是在完成一个任务后再创建一个线程，它没有限制数量，所能容纳的最大线程数量是Integer的最大值。<br/>
 * 通过以下打印的结果发现：可同时运行所有线程。<br/>
 */
public class CachedThreadPool implements Pool {

    int corePoolSize = 0;
    int maximumPoolSize = Integer.MAX_VALUE;
    long keepAliveTime = 60L;

    public static void main(String[] args) {
        CachedThreadPool ctp = new CachedThreadPool();
//        ctp.test1();
        ctp.test2();
    }

    public void test1() {
        ExecutorService es = Executors.newCachedThreadPool();
        new ThreadPool().executeMethod(es);
        es.shutdown();
    }

    public void test2() {
        ExecutorService es2 = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory2, abortPolicy);
        new ThreadPool().executeMethod(es2);
        es2.shutdown();
    }
}
