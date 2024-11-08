package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // saldo inicial de la cuenta
        ExecutorService executor = Executors.newFixedThreadPool(3); // pool de 3 hilos

        List<Future<String>> results = new ArrayList<>();

        // Crear varias tareas de transacción
        results.add(executor.submit(new TransactionTask(account, "deposit", 200)));
        results.add(executor.submit(new TransactionTask(account, "withdraw", 150)));
        results.add(executor.submit(new TransactionTask(account, "withdraw", 100)));
        results.add(executor.submit(new TransactionTask(account, "deposit", 300)));
        results.add(executor.submit(new TransactionTask(account, "withdraw", 500)));
        results.add(executor.submit(new TransactionTask(account, "deposit", 400)));
        results.add(executor.submit(new TransactionTask(account, "withdraw", 700))); // debe fallar por fondos insuficientes

        // Obtener y mostrar los resultados
        for (Future<String> result : results) {
            try {
                System.out.println("Transaction result: " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Transaction failed: " + e.getMessage());
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
