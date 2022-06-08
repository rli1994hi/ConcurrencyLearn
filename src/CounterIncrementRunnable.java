public class CounterIncrementRunnable implements Runnable {
    private static final int INCREMENT_TIMES = 10_000;

    private Counter counter;

    public CounterIncrementRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < INCREMENT_TIMES; i++) {
            counter.increment();
        }
    }
}
