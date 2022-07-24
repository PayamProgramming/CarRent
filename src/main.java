import java.util.Random;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("PayamAghaei", 3000000);
        System.out.println(bankAccount.getName() + " Has Logged In !" + "\n*********\n");
        System.out.println(bankAccount.deposit(2000000));
        System.out.println(bankAccount.deposit(400000000));
        System.out.println(bankAccount.deposit(30000000));
        System.out.println(bankAccount.withdraw(4000000));
        System.out.println(bankAccount.withdraw(35000000));
        System.out.println("You're accountNumber is : " + bankAccount.getAccountNumber());

        System.out.println(bankAccount.getName() + " Has Logged Of !"  + "\n*********\n");

        BankAccount bankAccount1 = new BankAccount("SahelAhmadzada" , 300 );
        System.out.println(bankAccount1.getName() + " Has Logged In !"  + "\n*********\n");
        bankAccount1.setActive(false); ;
        System.out.println(bankAccount1.deposit(3000));
        System.out.println("You're accountNumber is : " + bankAccount1.getAccountNumber());
        System.out.println(bankAccount1.withdraw(2000));
    }
}
