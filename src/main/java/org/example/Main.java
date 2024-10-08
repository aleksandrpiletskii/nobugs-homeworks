package org.example;

import org.example.task1.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setBalance(1000);
        account1.print();
    }
}