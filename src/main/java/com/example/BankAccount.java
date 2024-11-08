package com.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) throws Exception {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
            } else {
                throw new Exception("Insufficient funds. Available balance: " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}
