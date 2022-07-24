import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BankAccount {

    private String name;
    private int accountNumber;
    private int balance;
    private int minBalance;
    private int maxBalance;
    private boolean isActive;

    int minRandom = 100000;
    int maxRandom = 999999;
    Random rnd = new Random();
    int acc = rnd.nextInt(maxRandom - minRandom + 1) + minRandom;

    public BankAccount(String name, int balance) {
        this.name = name;
        this.accountNumber = acc;
        this.balance = balance;
        this.minBalance = 0;
        this.maxBalance = 50000000;
        this.isActive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(int minBalance) {
        this.minBalance = minBalance;
    }

    public int getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(int maxBalance) {
        this.maxBalance = maxBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int deposit(int amount) {
        if (getBalance() + amount <= getMaxBalance() && isActive() == true) {
            setBalance(getBalance() + amount);
            System.out.println(getName() + " Has deposited " + amount);
        } else if (getBalance() + amount >= getMaxBalance())
            System.out.println("MaxBalance of that account is full and you cant deposit " + amount);
        else if (isActive() == false)
            System.out.println("Your Acount is not Active !");
        System.out.println("You're Balance is : " + getBalance());
        return getBalance();
    }

    public int withdraw(int amount) {
        if (getBalance() - amount >= getMinBalance() && isActive() == true) {
            setBalance(getBalance() - amount);
            System.out.println(getName() + " has withdrawed " + amount);
        } else if (getBalance() - amount <= getMinBalance())
            System.out.println("You're balance is " + getBalance() + " So you cant withdraw " + amount);
        else if (isActive() == false)
            System.out.println("Your Acount is not Active !");
        System.out.println("You're Balance is : " + getBalance());
        return getBalance();
    }
}
