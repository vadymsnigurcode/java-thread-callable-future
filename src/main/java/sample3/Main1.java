package sample3;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main1 {

    public static void main(String[] args) {
        Callable<String> oneCallable = new OneTask(1);
        FutureTask<String> ft= new FutureTask<String>(oneCallable);
        // FutureTask <String> - это оболочка, которая создается путем принятия Callable <String>, которая реализует как Future, так и Runnable интерфейсы

        new Thread(ft).start();

        while(!ft.isDone()){
            try {
                System.out.println ("Проверить, завершено ли выполнение потока ...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String result = "";
        try {
            result = ft.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
