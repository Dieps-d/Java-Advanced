package Chapter9;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/14
 *
 * <h3>Exceptions</h3>
 * <ul>
 *     <li>InsufficientFundsException: Thrown when trying to withdraw more than is available</li>
 *     <li>IlligalArgumentException:Thrown when trying to deposit or withdraw negative amounts</li>
 * </ul>
 **/
enum AccountType{
    DEBIT,SAVINGS,CREDIT,CHEQUE,LOAN
}

public class BankAccount {
    private String accountNumber;
    private String AccountHolder;
    private AccountType accountType;
    private double balance;

    //overloaded contructer

    public BankAccount(String accountNumber, String accountHolder, AccountType accountType,
                       double balance) {
        setAccountType(accountType);
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setBalance(balance);
    }


    //getters and setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        //Provide logic to assign the account prefix
        //SV-4568793
        String accPrefix;

        if (getAccountType()==AccountType.SAVINGS){
           accPrefix="SV-";
        } else if (getAccountType()==AccountType.CHEQUE) {
            accPrefix="CQ-";
        } else if (getAccountType()==AccountType.CREDIT) {
            accPrefix="CR-";
        } else if (getAccountType()==AccountType.LOAN) {
            accPrefix="LN-";
        } else   {
            accPrefix="DB-";
        }
        this.accountNumber=accPrefix+accountNumber;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        AccountHolder = accountHolder;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount)throws IllegalArgumentException{
        if (amount<=0){
            throw new IllegalArgumentException("Cannot deposit negative or zero (R0) amount.+" +
                    "["+amount+"]");

        }
        this.balance+=amount;
    }
    public void withdraw(double amount)throws IllegalArgumentException,InsifficientFundsException{
        if (amount<=0){
            throw new IllegalArgumentException("Cannot withdraw negative or zero (R0) amount.+" +
                    "["+amount+"]");

        }
        if (amount>getBalance()){
            throw new InsifficientFundsException("Insufficient funds...\nCurrent Balance: "+getBalance()+
                    "\n Requested Amount: "+amount);
        }
        this.balance-=amount;
    }

    public String displayDetails(){
        return String.format("""
               Account Number          : %s
               Account Holder          : %s
               Account Type            : %s
               Balance                 : %.2f""",
                getAccountHolder(),getAccountNumber(),getAccountType(),getBalance());
    }
}
