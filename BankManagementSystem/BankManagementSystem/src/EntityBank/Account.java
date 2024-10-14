package EntityBank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Exception.*;

public class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private List<Transcation> transactions;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transcation("Deposit", amount));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        transactions.add(new Transcation("Withdrawal", amount));
    }

    public void saveAccountToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\CDAC\\Bank.txt", true))) {
            writer.write(this.toString());
            writer.newLine();
            writer.write("Balance: $" + balance);
            writer.newLine();
            writer.write("Transactions:");
            writer.newLine();
            for (Transcation transaction : transactions) {
                writer.write(transaction.toString());
                writer.newLine();
            }
            writer.write("-------------------------");
            writer.newLine();
            System.out.println("Account saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return customer + " (Account Number: " + accountNumber + ")";
    }
}

