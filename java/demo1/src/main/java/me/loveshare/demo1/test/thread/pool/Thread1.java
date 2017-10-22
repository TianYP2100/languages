package me.loveshare.demo1.test.thread.pool;

/**
 * 定义一个线程执行run方法，方法是打印某线程在执行
 */
public class Thread1 extends Thread {

    int i = 0;

    //run方法，打印当前执行的线程
    @Override
    public void run() {

        while (i++ < 3) {
            System.out.println(this.getName() + " is running.(" + System.nanoTime() + ").");
        }
    }
}
