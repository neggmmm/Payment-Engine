package AccountService;

import Account.Account;
import Enums.Currency;

public interface AccountService {

    Account createSavingsAccount(String name, Currency currency, double balance);

    Account createBusinessAccount(String name, Currency currency, double balance);

    Account findById(String id);

    void displayAllAccounts();
}
