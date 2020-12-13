public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal cach = new ThreadLocal();

        Thread t1 = new Thread(()->{
            Thread.currentThread().setName("thread1");
            cach.set(1);
            System.out.println(Thread.currentThread().getName() + ": " + cach.get());
        });

        Thread t2 = new Thread(()->{
            Thread.currentThread().setName("thread2");
            cach.set(2);
            System.out.println(Thread.currentThread().getName() + ": " + cach.get());
        });

        t1.start();
        t2.start();
    }
}
