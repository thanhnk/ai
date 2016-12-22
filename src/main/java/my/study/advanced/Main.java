package my.study.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
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

        //Main main = new Main();
        //main.run();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                sleep(1);
                map.put("foo", "bar");
                map.put("foo2", "bar2");
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                sleep(2);
            } finally {
                lock.unlockRead(stamp);
            }

            long stamp2 = lock.readLock();
            try {
                System.out.println(map.get("foo2"));
                sleep(2);
            } finally {
                lock.unlockRead(stamp2);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);

    }
}
