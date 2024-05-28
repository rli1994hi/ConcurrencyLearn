package ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Runner {
    public static void main(String[] args) {
        BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>(12);
        Thread producerThread1 = new Thread(new Producer(taskQueue), "producer-1");
        Thread producerThread2 = new Thread(new Producer(taskQueue), "producer-2");
        Thread producerThread3 = new Thread(new Producer(taskQueue), "producer-3");
        Thread producerThread4 = new Thread(new Producer(taskQueue), "producer-4");
        Thread consumerThread1 = new Thread(new Consumer(taskQueue), "consumer-1");
        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
        producerThread4.start();
        consumerThread1.start();
    }
}

