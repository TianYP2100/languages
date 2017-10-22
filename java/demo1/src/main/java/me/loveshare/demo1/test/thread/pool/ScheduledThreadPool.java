package me.loveshare.demo1.test.thread.pool;

import java.util.concurrent.*;

/**
 * 每一个被调度的任务都会由线程池中一个线程去执行，因此任务是并发执行的，相互之间不会受到干扰
 * 只有当任务的执行时间到来时，ScheduedExecutor 才会真正启动一个线程，其余时间 ScheduledExecutor 都是在轮询任务的状态
 */
public class ScheduledThreadPool implements Pool {

    int corePoolSize = 1;

    public static void main(String[] args) {
        ScheduledThreadPool stp = new ScheduledThreadPool();
//        stp.test1();
        stp.test2();
    }

    public void test1() {
        ExecutorService es = Executors.newScheduledThreadPool(corePoolSize);
        new ThreadPool().executeMethod(es);
        es.shutdown();
    }

    public void test2() {
        ScheduledExecutorService ses = new ScheduledThreadPoolExecutor(corePoolSize, threadFactory1);

        /**
         * new Thread1() 要执行的任务线程
         * 1000：延迟多长时间执行
         * 2000: 每隔多少长时间执行一次
         * TimeUnit.MILLISECONDS：时间单位
         */

        ses.scheduleAtFixedRate(new Thread1(), 1000, 2000, unit);
//        new ThreadPool().executeMethod(ses);

        ses.shutdown();
    }
}
