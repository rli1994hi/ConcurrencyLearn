package ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

// Consume 2 tasks per sec
public class Consumer implements Runnable {
    private static final int INTERVAL_MILLI_SEC = 2000;
    private final BlockingQueue<String> taskQueue;

    public Consumer(BlockingQueue<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    private void consumeTasks() {
        while (true) {
            try {
                Thread.sleep(INTERVAL_MILLI_SEC);
                String s = taskQueue.take();
                System.out.println(Thread.currentThread().getName() + " - Took task: " + s);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void run() {
        consumeTasks();
    }
}
