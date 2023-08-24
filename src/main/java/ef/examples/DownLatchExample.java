package ef.examples;

import ef.Foo;

import java.util.concurrent.CountDownLatch;

public class DownLatchExample {
    final CountDownLatch downLatch = new CountDownLatch(3);

    Foo foo = new Foo();

    public synchronized void first() throws InterruptedException {
        while (downLatch.getCount() != 3) {
            wait();
        }
        notify();
        System.out.println("\nDown Latch: ");
        foo.first();
        downLatch.countDown();
    }

    public synchronized void second() throws InterruptedException {
        while (downLatch.getCount() != 2) {
            wait();
        }
        notify();
        foo.second();
        downLatch.countDown();
    }

    public synchronized void third() throws InterruptedException {
        while (downLatch.getCount() != 1) {
            wait();
        }
        notify();
        foo.third();
    }
}


