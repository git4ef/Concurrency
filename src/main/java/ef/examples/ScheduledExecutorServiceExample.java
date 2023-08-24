package ef.examples;

import ef.Foo;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void runScheduledService(){
        Foo foo = new Foo();

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(3);

        scheduledExecutorService.schedule(() -> System.out.println("\nScheduledExecutorService: "), 0, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(() -> foo.first(), 1, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(() -> foo.second(), 2, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(() -> foo.third(), 3, TimeUnit.MILLISECONDS);
        scheduledExecutorService.shutdown();
    }
}
