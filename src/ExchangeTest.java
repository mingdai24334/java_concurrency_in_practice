import java.util.concurrent.Exchanger;

public class ExchangeTest {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        Runnable run1 = () -> {
            try {
                String msg = exchanger.exchange("from runner1");
                System.out.println("thread1: "+msg);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        };

        Runnable run2 = () -> {
            try {
                String msg = exchanger.exchange("from runner2");
                System.out.println("thread2: "+msg);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(run1);
        t1.start();

        Thread t2 = new Thread(run2);
        t2.start();

        t1.join();
        t2.join();
    }
}
