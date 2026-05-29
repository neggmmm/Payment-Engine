package Transaction.TransactionService;

import java.util.List;
import java.util.Optional;

import Account.Account;
import Transaction.Transacation;

public interface TransactionService {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    void transfer(Account from, Account to, double amount);
    List<Transacation> getHistory(Account account);
    Optional<Transacation> getLargestTransaction(Account account);
    double getTotalSpent(Account account);
}
