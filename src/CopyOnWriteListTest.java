import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> l = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3));

        new Thread(()->{
            //System.out.println(Thread.currentThread().getName());
            l.forEach(e1->{
                System.out.print(e1);
            });
            System.out.println();

        }).start();

//        try {
//                    Thread.sleep(1000);
//        } catch (InterruptedException e) {
//                    e.printStackTrace();
//        }

        l.add(4);

        new Thread(()->{
            //System.out.println(Thread.currentThread().getName());
            l.forEach(e1->{
                System.out.print(e1);
            });
            System.out.println();

        }).start();

        l.add(5);

        new Thread(()->{
            //System.out.println(Thread.currentThread().getName());
            l.forEach(e1->{
                System.out.print(e1);

            });
            System.out.println();

        }).start();


    }
}
