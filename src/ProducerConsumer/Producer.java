package ProducerConsumer;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

// Produce 1 task per sec
public class Producer implements Runnable {
    private final BlockingQueue<String> taskQueue;
    private static final int INTERVAL_MILLI_SEC = 500;

    public Producer(BlockingQueue<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    private void produceTasks() {
        while (true) {
            try {
                Thread.sleep(INTERVAL_MILLI_SEC);
                // produce task
                String task = "task-" + new Date();
                System.out.println(Thread.currentThread().getName() + " - Offering task: " + task);
                taskQueue.put(task);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void run() {
        produceTasks();
    }
}
