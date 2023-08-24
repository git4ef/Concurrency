package ef;


import ef.examples.DownLatchExample;
import ef.examples.ScheduledExecutorServiceExample;
import ef.examples.SemaphoreExample;


public class Main {
    public static void main(String[] args) throws RuntimeException, InterruptedException {

        SemaphoreExample semaphoreExample = new SemaphoreExample();

        new Thread(() -> {
            try {
                semaphoreExample.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                semaphoreExample.first();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                semaphoreExample.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Thread.sleep(10);
        ScheduledExecutorServiceExample.runScheduledService();

        Thread.sleep(10);
        DownLatchExample downLatchExample = new DownLatchExample();

        new Thread(() -> {
            try {
                downLatchExample.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                downLatchExample.first();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                downLatchExample.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}


