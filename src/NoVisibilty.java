public class NoVisibilty {
    private static boolean ready = false;
    private static int value;

    public static void main(String[] args) {
        new Thread(()->{
            while (!ready) {
                Thread.yield();
            }
            System.out.println(value);
        }).start();

        ready = true;
        value = 40;
    }
}
