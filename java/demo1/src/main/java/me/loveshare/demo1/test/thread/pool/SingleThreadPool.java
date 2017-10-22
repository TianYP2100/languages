package me.loveshare.demo1.test.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 单个后台线程的线程池: <br/>
 * 此方法创建的线程池里只能同时运行一个线程。<br/>
 * 如果该线程在执行中异常结束了，线程池会重新创建一个线程继续执行。<br/>
 * 通过以下打印的结果发现：程序按顺序执行的，意味着它每次都只能同时运行一个任务。<br/>
 *
 * @author tony
 * @since 2017-10-21
 * <p>
 * Thread-0 is running.
 * Thread-0 is running.
 * Thread-0 is running.
 * Thread-1 is running.
 * Thread-1 is running.
 * Thread-1 is running.
 * Thread-2 is running.
 * Thread-2 is running.
 * Thread-2 is running.
 * Thread-3 is running.
 * Thread-3 is running.
 * Thread-3 is running.
 * Thread-4 is running.
 * Thread-4 is running.
 * Thread-4 is running.
 * </p>
 */
public class SingleThreadPool implements Pool {

    public static void main(String[] args) {
        SingleThreadPool stp = new SingleThreadPool();
//        stp.test1();
//        stp.test2();
        stp.test3();
    }

    public void test1() {
        // 这个方法创建的线程池里只能同时运行一个线程，如果该线程在执行途中异常结束了，线程池会重新创建一个线程继续执行
        ExecutorService es = Executors.newSingleThreadExecutor();  //手动创建效果会更好
        //执行ThreadPool类中定义的执行方法
        new ThreadPool().executeMethod(es);
        //执行完就关闭线程池
        es.shutdown();
    }

    public void test2() {
        ExecutorService es1 = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory1, abortPolicy);
        new ThreadPool().executeMethod(es1);
        es1.shutdown();
    }

    public void test3() {
        ExecutorService es2 = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory2, abortPolicy);
        new ThreadPool().executeMethod(es2);
        es2.shutdown();
    }

}

















