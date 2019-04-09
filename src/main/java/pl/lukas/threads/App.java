package pl.lukas.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Runnable worker1 = () -> {
            try {
                System.out.println("Robotnik 1 - Aktualny wątek " + Thread.currentThread().getName());
                System.out.println("Ładuje butlę z tlenem");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable worker2 = () -> {
            try {
                System.out.println("Robotnik 2 - Aktualny wątek " + Thread.currentThread().getName());
                System.out.println("Ładuje zapas pożywienia");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable worker3 = () -> {
            try {
                System.out.println("Robotnik 3 - Aktualny wątek " + Thread.currentThread().getName());
                System.out.println("Ładuje paliwo");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executorService.schedule(worker1,5,TimeUnit.SECONDS);
        executorService.shutdown();
    }
}