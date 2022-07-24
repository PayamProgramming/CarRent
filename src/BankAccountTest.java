import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(BankAccountParameterResolver.class)
class BankAccountTest {

    @BeforeAll
    static void beforeAll(BankAccount bankAccount) {
        assertEquals("Payam", bankAccount.getName());
        assertEquals(100000, bankAccount.getBalance());
        assertEquals(0, bankAccount.getMinBalance());
        assertEquals(50000000, bankAccount.getMaxBalance());
        assertTrue(bankAccount.isActive());
        System.out.println("Constructor Testing Passed .");
    }

    @AfterAll
    static void afterAll() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Testing Deposit")
    @Order(2)
    void deposit(BankAccount bankAccount) {
        int amount = 100;
        Assumptions.assumeTrue(bankAccount.getBalance() + amount <= bankAccount.getMaxBalance() && bankAccount.isActive());
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        assertEquals(100100, bankAccount.getBalance());
        bankAccount.deposit(100);
        assertEquals(100200, bankAccount.getBalance());

        int amount1 = 110000000;
        Assumptions.assumeTrue(bankAccount.isActive());
        Assumptions.assumeFalse(bankAccount.getBalance() + amount1 <= bankAccount.getMaxBalance() && bankAccount.isActive(), "MaxBalance of that account is full and you cant deposit " + amount1);
        bankAccount.deposit(amount1);
        assertEquals(100200, bankAccount.getBalance());

        int amount2 = 100;
        bankAccount.setActive(false);
        Assumptions.assumeTrue(bankAccount.getBalance() + amount2 <= bankAccount.getMaxBalance());
        Assumptions.assumeFalse(bankAccount.isActive());
        assertNotEquals(100100, bankAccount.deposit(amount2));
        assertEquals(100200, bankAccount.getBalance());

    }

    @Test
    @DisplayName("Testing Withdraw")
    @Order(1)
    void withdraw(BankAccount bankAccount) {
        int amount = 50000;
        Assumptions.assumeTrue(bankAccount.getBalance() - amount >= bankAccount.getMinBalance() && bankAccount.isActive());
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        assertEquals(50000, bankAccount.getBalance());
        bankAccount.withdraw(40000);
        assertEquals(10000, bankAccount.getBalance());

        int amount1 = 10010000;
        Assumptions.assumeTrue(bankAccount.isActive());
        Assumptions.assumeFalse(bankAccount.getBalance() - amount1 >= bankAccount.getMinBalance());
        bankAccount.withdraw(amount1);
        assertEquals(10000, bankAccount.getBalance());

        int amount2 = 2000;
        bankAccount.setActive(false);
        Assumptions.assumeFalse(bankAccount.isActive());
        Assumptions.assumeTrue(bankAccount.getBalance() - amount2 >= bankAccount.getMinBalance());
        bankAccount.withdraw(5000);
        assertEquals(10000, bankAccount.getBalance());


    }

    @Nested
    class CheckingAccountNumber {

        @RepeatedTest(10)
        void checkIfAccountNumberIsUnique(BankAccount bankAccount) {
            bankAccount.getAccountNumber();
            assertEquals(bankAccount.acc, bankAccount.getAccountNumber());
            System.out.print(bankAccount.acc + "*");
        }
    }


}