package ef;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws RuntimeException, InterruptedException {

        Foo foo = new Foo();

        CompletableFuture.runAsync(() -> {
            foo.second(new Thread());
        });

        CompletableFuture.runAsync(() -> {
            foo.first(new Thread());
        });

        CompletableFuture.runAsync(() -> {
            foo.third(new Thread());
        });

        Thread.sleep(2000);

    }
}



