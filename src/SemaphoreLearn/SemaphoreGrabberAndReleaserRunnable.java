package SemaphoreLearn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;

public class SemaphoreGrabberAndReleaserRunnable implements Runnable {
    private Semaphore semaphore;
    private int permitsToGrab;
    private int permitsToRelease;

    public SemaphoreGrabberAndReleaserRunnable(Semaphore semaphore, int permitsToGrab, int permitsToRelease) {
        this.semaphore = semaphore;
        this.permitsToGrab = permitsToGrab;
        this.permitsToRelease = permitsToRelease;
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

            System.out.printf("[%s] [%s] Releasing semaphore for %d permits%n",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
                    Thread.currentThread().getName(),
                    permitsToRelease);
            semaphore.release(permitsToRelease);
            System.out.printf("[%s] [%s] Released semaphore for %d permits%n",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
                    Thread.currentThread().getName(),
                    permitsToRelease);

        } catch (Exception e) {

        }
    }

}
