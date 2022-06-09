package SemaphoreLearn;

import java.util.concurrent.Semaphore;

public class SemaphoreCheckerRunnable implements Runnable {
    private Semaphore semaphore;

    public SemaphoreCheckerRunnable(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(String.format("[%s] semaphore available permits: " + semaphore.availablePermits(),
                Thread.currentThread().getName()));
    }
}
