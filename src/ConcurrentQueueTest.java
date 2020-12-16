import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueTest {
    public static void main(String[] args) {
        Random r = new Random();
        ConcurrentLinkedQueue<Integer> q = new ConcurrentLinkedQueue<>();

        for (int i= 10; i<1000; i++)
            q.add(i);

        new Thread(()->{
            for (int i = 0; i< 10; i++) {
                int j = r.nextInt(9);
                q.add(j);
                System.out.println(Thread.currentThread().getName()+": "+j);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    ;
//                }
            }

            for (int i = 0; i< 20; i++) {

                int k = q.remove();
                System.out.println(Thread.currentThread().getName()+": removed: "+k);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    ;
//                }
            }
        }).start();

        for (Integer i : q) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
