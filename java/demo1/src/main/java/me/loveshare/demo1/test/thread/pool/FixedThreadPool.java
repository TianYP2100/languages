package me.loveshare.demo1.test.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 固定大小线程池:<br/>
 * 此方法创建的线程池里可同时运行指定数量的线程，每完成了一个任务时就再创建一个线程去执行任务，直到线程数量达到线程池可同时运行的最大值。<br/>
 * 如果有一个线程在执行中异常结束了，会自动创建一个线程补充其执行。<br/>
 * 通过以下打印的结果发现：它在执行第一个任务后不断地创建新线程去执行余下的任务，直到线程数量达到了可允许的最大值,可发现，它同时执行的线程不超过3个。<br/>
 * <p>
 * Thread-0 is running.
 * Thread-0 is running.
 * Thread-0 is running.
 * Thread-1 is running.
 * Thread-1 is running.
 * Thread-1 is running.
 * Thread-3 is running.
 * Thread-3 is running.
 * Thread-3 is running.
 * Thread-2 is running.
 * Thread-2 is running.
 * Thread-2 is running.
 * Thread-4 is running.
 * Thread-4 is running.
 * Thread-4 is running.
 * </p>
 */
public class FixedThreadPool implements Pool {

    private static final int nThreads = 3;
    int corePoolSize = 3;
    int maximumPoolSize = 3;

    public static void main(String[] args) {
        FixedThreadPool ftp = new FixedThreadPool();
//        ftp.test1();
        ftp.test2();
    }

    public void test1() {
        ExecutorService es = Executors.newFixedThreadPool(nThreads);
        new ThreadPool().executeMethod(es);
        es.shutdown();
    }

    public void test2() {
        ExecutorService es2 = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory2, abortPolicy);
        new ThreadPool().executeMethod(es2);
        es2.shutdown();
    }
}
