package my.study.advanced;

import javax.lang.model.SourceVersion;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public class Main extends ConcurrentUtils {
    ReentrantLock lock = new ReentrantLock();

    int count = 0;

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    synchronized void incrementSync() {
        count = count + 1;
    }

    void run(){
        ExecutorService executor = Executors.newFixedThreadPool(200);

        IntStream.range(0, 1000)
                .forEach(i -> executor.submit(this::increment));

        ConcurrentUtils.stop(executor);

        System.out.println(count);  // 9965
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        for( final SourceVersion version: compiler.getSourceVersions() ) {
            System.out.println( version );
        }
    }
}
