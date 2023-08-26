package ef;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws RuntimeException, InterruptedException {

        Foo foo = new Foo();

        CompletableFuture.runAsync(() -> {
            foo.second();
        });

        CompletableFuture.runAsync(() -> {
            foo.first();
        });

        CompletableFuture.runAsync(() -> {
            foo.third();
        });

        Thread.sleep(2000);

    }
}



