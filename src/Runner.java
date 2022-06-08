public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IntHolder thread1Val = new IntHolder(1);
        IntHolder thread2Val = new IntHolder(1);

        Thread thread1 = new Thread(new CounterIncrementRunnable(counter, thread1Val));
        Thread thread2 = new Thread(new CounterIncrementRunnable(counter, thread2Val));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("thread1 val: " + thread1Val.getInteger());
        System.out.println("thread2 val: " + thread2Val.getInteger());

        System.out.println("total counter val: " + (thread1Val.getInteger() + thread2Val.getInteger()));
    }
}
