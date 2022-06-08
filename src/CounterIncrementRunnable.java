public class CounterIncrementRunnable implements Runnable {
    private static final int INCREMENT_TIMES = 10_000;

    private final Counter counter;
    private IntHolder result;

    private final ThreadLocal<Counter> counterThreadLocal = new ThreadLocal<>(){
        @Override
        protected Counter initialValue()
        {
            return new Counter();
        }
    };

    public CounterIncrementRunnable(Counter counter, IntHolder result) {
        this.counter = counter;
        this.result = result;
    }

    @Override
    public void run() {
        System.out.println("starting..." + Thread.currentThread().getName());

        for (int i = 0; i < INCREMENT_TIMES; i++) {
            counterThreadLocal.get().increment();
        }

        this.result.setInteger(counterThreadLocal.get().get());
    }
}
