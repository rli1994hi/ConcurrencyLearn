package SemaphoreLearn;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(new SemaphoreGrabberRunnable(semaphore, 2)); // 2 is greater than available permits 1
        Thread t2 = new Thread(new SemaphoreGrabberAndReleaserRunnable(semaphore, 1, 2));
        Thread t3 = new Thread(new SemaphoreCheckerRunnable(semaphore));

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
