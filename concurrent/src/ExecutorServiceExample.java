import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        int x = 1127;

        Future<Integer> f1 = service.submit(() -> f(x));
        Future<Integer> f2 = service.submit(() -> g(x));

        System.out.println(f1.get() + f2.get());

        service.shutdown();


    }

    public static int f(int x) {
        return x++;
    }

    public static int g(int x) {
        return x--;
    }
}
