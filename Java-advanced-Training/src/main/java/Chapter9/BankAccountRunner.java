package Chapter9;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/14
 **/

public class BankAccountRunner {
    public static void main(String[] args) {

        try {
            BankAccount objAcc=new BankAccount("Jessica Jones","5986745",AccountType.CHEQUE,15000);
            objAcc.deposit(500);
            System.out.println(objAcc.displayDetails());
        }catch (InsifficientFundsException|IllegalArgumentException e) {
            System.err.println(e.getMessage());

    }
    }
}
