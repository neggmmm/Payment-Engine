package Exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String accountName, double amount, double balance){
        super("Insufficient funds is: " + accountName + " | Requested: "+ amount+ " and your balance: " + balance);
    }
}
