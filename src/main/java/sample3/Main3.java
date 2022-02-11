package sample3;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main3 {

    public static void main(String[] args){
        // TODO Auto-generated method stub
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        // Future эквивалентен контейнеру, используемому для хранения результатов выполнения Executor

        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new OneTask(i)));
        }

        for (Future<String> fs : results) {
            if (fs.isDone()) {
                try {
                    System.out.println(fs.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Future result is not yet complete");
            }
        }
        exec.shutdown();
    }
}
