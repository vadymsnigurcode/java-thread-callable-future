package callableExample;

import java.util.concurrent.*;

public class MainCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FactorialTask task = new FactorialTask(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(task);

        System.out.println(future.get().intValue());
        executorService.shutdown();
    }
}
