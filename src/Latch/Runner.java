package Latch;

import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        // 10 task worker. Set off at the same time. Wait for all workers to be done
        int workerCount = 10;
        Random r = new Random();
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(workerCount);

        for (int i = 0; i < workerCount; i++) {
            Thread t = new Thread(new TaskWorker(r, startLatch, endLatch), "thread-" + i);
            t.start();
        }

        System.out.println("[" + System.currentTimeMillis() + "] Finished initiating thread. Waiting 2 s to start."); // TODO: have a log frame with predefined format: timestamp - threadName - logContent

        Thread.sleep(2000); // intentionally wait for 2s to make sure no threads would start work during the period

        startLatch.countDown();
        endLatch.await();
        System.out.println("Main thread done");
    }
}
