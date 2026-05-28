package Account;

import Enums.Currency;

public class SavingsAccount extends Account {
    public SavingsAccount(String id, String name, Currency currency, double balance){
        super(id,name,currency,balance);
    }

    @Override
    public double getTransactionLimit(){
        return 10_000;
    }

    @Override
    public String getAccountType(){
        return "SAVINGS";
    }
}
