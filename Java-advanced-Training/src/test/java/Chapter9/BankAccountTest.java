package Chapter9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/14
 **/

public class BankAccountTest {
    BankAccount objAcc;

    @BeforeEach
    void setUpAccount(){
        objAcc= new BankAccount("Jessica Jones","5986745",AccountType.SAVINGS,15000) ;
    }
    @Test
    void testDeposit(){
        //Arrange

        double amountToDeposit=600;
        double expectedBalance=15600;

        //actual
        objAcc.deposit(amountToDeposit);
        double actualBalance=objAcc.getBalance();

        //assert
        assertEquals(expectedBalance,actualBalance);
    }

    @Test
    void testInvalidDeposit(){
        assertThrows(IllegalArgumentException.class,()-> objAcc.deposit(-500));

    }
    @Test
    void testWithdraw(){
        double amounttowithdraw =1500;
        double expectedBalance=13500;
        //actual

        try {
            objAcc.withdraw(amounttowithdraw);
            double actualBalance= objAcc.getBalance();

            assertEquals(expectedBalance,actualBalance);
        }catch (InsifficientFundsException e){
            System.err.println(e.getMessage());
        }
    }

@Test
    void testInvalidWithdrawalNegativeAmount(){
        assertThrows(IllegalArgumentException.class,
                ()-> objAcc.withdraw(-100));
    }

    @Test
    void testwithdrawalInssuficientFunds(){
        double amounttowithdraw=objAcc.getBalance()+1;
        assertThrows(InsifficientFundsException.class,
                ()->objAcc.withdraw(amounttowithdraw));
    }
    @AfterEach
    void getAccountDetails(){
        System.err.println(objAcc.displayDetails());
    }
}
