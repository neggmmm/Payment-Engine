package Transaction.TransactionService;

import java.util.List;
import java.util.Optional;

import Account.Account;
import Transaction.Transcation;

public interface TransactionService {
    void deposit(Account account, double amount);
    void withdrawl(Account account, double amount);
    void transfer(Account from, Account to, double amount);
    List<Transcation> getHistory(Account account);
    Optional<Transcation> getLargestTransaction(Account account);
    double getTotalSpent(Account account);
}
