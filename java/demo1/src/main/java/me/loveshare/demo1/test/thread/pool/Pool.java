package me.loveshare.demo1.test.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

public interface Pool {

    int corePoolSize = 1;
    int maximumPoolSize = 1;
    long keepAliveTime = 0L;
    TimeUnit unit = TimeUnit.MILLISECONDS;
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2000);
    ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();

    ThreadFactory threadFactory1 = new BasicThreadFactory.Builder().namingPattern("Google-pool-%d").build();

    ThreadFactory threadFactory2 = new ThreadFactoryBuilder().setNameFormat("Apache-pool-%d").build();
}
