public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(new CounterIncrementRunnable(counter));
        Thread thread2 = new Thread(new CounterIncrementRunnable(counter));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("counter val: " + counter.get());
    }
}
