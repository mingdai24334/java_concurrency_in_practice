import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(10);

        List<Thread> l = new ArrayList<>();
        for (int i=0; i<10; i++) {
            Thread t = new Thread(()->{
               System.out.println("thread: "+Thread.currentThread().getName());
               endGate.countDown();
            });
            l.add(t);
            t.start();
        }

        startGate.countDown();
        endGate.await();


        System.out.println("Done");
    }
}
