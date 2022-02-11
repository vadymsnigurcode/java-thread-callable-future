package sample3;

import java.util.concurrent.Callable;

public class OneTask implements Callable<String> {// callable имеет <V>, этот V является типом возвращаемого значения функции вызова
    private int id;

    public OneTask(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {// Здесь вы можете выбросить исключение, но функция run интерфейса Runnable не может
        int i = 5;
        while (i >= 0) {
            System.out.println("Thread " + id + " is working");
            Thread.sleep(1000);
            i--;
        }
        return "result of Test2" + id; // Функция запуска интерфейса Runnable не имеет возвращаемого значения
    }
}

