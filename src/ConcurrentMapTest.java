import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {
    public static void main(String[] args) throws InterruptedException {
        final Map<String, Integer> m = new ConcurrentHashMap<>();
        for (int i =1; i<10000000; i++) {
            String key = String.format("id%d", i);
            m.put(key, i);
        }


        Thread h1 = new Thread(()->{

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m.put("k5________", 1005);
        });

        Thread h2 = new Thread(()->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m.put("k6________", 1006);
        });

        h1.start();
        //h2.start();

        for (String key : m.keySet()) {
            if (key.equals("k5________") || key.equals("k6________"))
                System.out.println(key + ":" + m.get(key));
        }

//        m.forEach((e1, e2)->{
//            if (e1.equals("k5________") || e1.equals("k6________"))
//                System.out.println(e1 + ":" + e2);
//        });

        h1.join();
        //h2.join();


        //System.out.println(m);
    }
}
