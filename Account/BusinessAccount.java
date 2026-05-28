package Account;

import Enums.Currency;

public class BusinessAccount extends Account {

    public BusinessAccount(String id, String name, Currency currency, double balance){
        super(id,name,currency,balance);
    }

    @Override
    public double getTransactionLimit(){
        return 100_000;
    }

    @Override
    public String getAccountType(){
        return "BUSINESS";
    }
    
}
