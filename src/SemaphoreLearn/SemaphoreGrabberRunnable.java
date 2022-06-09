package SemaphoreLearn;

import java.util.concurrent.Semaphore;

public class SemaphoreGrabberRunnable implements Runnable {
    private Semaphore semaphore;
    private int permitsToGrab;

    public SemaphoreGrabberRunnable(Semaphore semaphore, int permitsToGrab) {
        this.semaphore = semaphore;
        this.permitsToGrab = permitsToGrab;
    }

    @Override
    public void run() {
        try {
            System.out.println(String.format("[%s] Grabbing semaphore for %d permits",
                    Thread.currentThread().getName(),
                    permitsToGrab)); // TODO: set up log format
            semaphore.acquire(permitsToGrab);
        } catch (Exception e) {

        }
    }
}
