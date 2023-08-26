package ef;

import java.util.concurrent.Semaphore;

public class Foo {

    final Semaphore semaphore = new Semaphore(3, true);

    public void first(Thread thread) {
        while (semaphore.availablePermits() != 3) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        thread.start();
        System.out.println("first");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void second(Thread thread) {
        while (semaphore.availablePermits() != 2) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        thread.start();
        System.out.println("second");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void third(Thread thread) {
        while (semaphore.availablePermits() != 1) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        thread.start();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("third");
    }
}


