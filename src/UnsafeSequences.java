public class UnsafeSequences {
    private int value;
    // should add synchronized
    public int getNext() {
        return value++;
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeSequences o = new UnsafeSequences();
        final UnsafeSequences o1 = o;
        Thread t1 = new Thread(()->{

            for (int i=0; i<10000; i++)
                o1.getNext();
        });

        Thread t2 = new Thread(()->{
            for (int i=0; i<10000; i++)
                o1.getNext();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        o = new UnsafeSequences();

        System.out.println(o1.getNext());
    }
}
