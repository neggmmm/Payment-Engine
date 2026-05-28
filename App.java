import Account.Account;
import Account.BusinessAccount;
import Account.SavingsAccount;
import Enums.Currency;

public class App{
    public static void main(String[] args){
        Account saving = new SavingsAccount("ACC_S001", "Negm", Currency.EGP, 24500);
        Account business = new BusinessAccount("ACC_B001", "Ahmed", Currency.USD, 56000);

        System.out.println(saving);
        System.out.println(business);

        System.out.println("Saving limit: " + saving.getTransactionLimit());
        System.out.println("Business limit: " + business.getTransactionLimit());
    }
}