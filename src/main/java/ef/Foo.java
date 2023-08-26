package ef;

import java.util.concurrent.Semaphore;

public class Foo {

    final Semaphore semaphore = new Semaphore(1, true);
    final Semaphore semaphore2 = new Semaphore(0, true);


    public void first() {
        try {
            semaphore.acquire();
            System.out.println("first " + Thread.currentThread().getName());
            semaphore2.release();
        } catch (InterruptedException e) {
        }
    }


    public void second() {
        try {
            semaphore2.acquire();
            System.out.println("second " + Thread.currentThread().getName());
            semaphore.release();
            semaphore2.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void third() {
        try {
            semaphore2.acquire();
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("third " + Thread.currentThread().getName());
    }
}


