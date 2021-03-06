package SemaphoreLearn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
            System.out.printf("[%s] [%s] Grabbing semaphore for %d permits%n",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
                    Thread.currentThread().getName(),
                    permitsToGrab); // TODO: set up log format

            semaphore.acquire(permitsToGrab);
            System.out.printf("[%s] [%s] Grabbed semaphore for %d permits%n",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
                    Thread.currentThread().getName(),
                    permitsToGrab);
        } catch (Exception e) {

        }
    }
}
