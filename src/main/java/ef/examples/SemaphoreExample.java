package ef.examples;

import ef.Foo;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    final Semaphore semaphore = new Semaphore(3, true);

    Foo foo = new Foo();

    public synchronized void first() throws InterruptedException {
        while (semaphore.availablePermits() != 3) {
            wait();
        }
        notify();
        System.out.println("Semaphore: ");
        foo.first();
        semaphore.acquire();
    }

    public synchronized void second() throws InterruptedException {
        while (semaphore.availablePermits() != 2) {
            wait();
        }
        notify();
        foo.second();
        semaphore.acquire();
    }

    public synchronized void third() throws InterruptedException {
        while (semaphore.availablePermits() != 1) {
            wait();
        }
        notify();
        foo.third();
        semaphore.drainPermits();
    }
}


