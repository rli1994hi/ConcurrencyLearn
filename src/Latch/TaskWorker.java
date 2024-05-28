package Latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TaskWorker implements Runnable {
    private final Random randomSeed;
    private final CountDownLatch startLatch;
    private final CountDownLatch endLatch;

    public TaskWorker(Random randomSeed, CountDownLatch startLatch, CountDownLatch endLatch) {
        this.randomSeed = randomSeed;
        this.startLatch = startLatch;
        this.endLatch = endLatch;
    }

    private void doDummyWork() {
        System.out.println("[" + System.currentTimeMillis() + "] " + Thread.currentThread().getName() + " - start");

        int sleepIntervalMs = Math.abs(randomSeed.nextInt(4000));
        try {
            Thread.sleep(sleepIntervalMs);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("[" + System.currentTimeMillis() + "] " + Thread.currentThread().getName() + " - done");
    }

    @Override
    public void run() {
        try {
            startLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        doDummyWork();
        endLatch.countDown();
    }
}
