package Transaction.TransactionService;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import Account.Account;
import Enums.TransactionStatus;
import Enums.TransactionType;
import Transaction.Transacation;

public class TransactionServiceImpl implements TransactionService {
    public void deposit(Account account, double amount){
        account.credit(amount);
          Transacation tx = new Transacation(
            UUID.randomUUID().toString(),
            null,
            account.getId(),
            amount,
            account.getCurrency(),
            TransactionType.DEPOSIT,
            TransactionStatus.COMPLETED,
            LocalDateTime.now()
        );
        account.addTransaction(tx);
        System.out.println("[+] Deposited "+ amount+ " -> "+ account.getName());
    }

    public void withdrawl(Account account, double amount){
        account.debit(amount);

        Transacation tx = new Transacation(
            UUID.randomUUID().toString(),
            account.getId(),
            null,
            amount,
            account.getCurrency(),
            TransactionType.WITHDRAWL,
            TransactionStatus.COMPLETED,
            LocalDateTime.now()
        );
        account.addTransaction(tx);
        System.out.println("[+] Withdrawn  "+ amount+ " from "+ account.getName());
    }

    public void transfer(Account from,Account to, double amount){
        from.debit(amount);
        to.credit(amount);
         Transacation tx = new Transacation(
            UUID.randomUUID().toString(),
            from.getId(),
            to.getId(),
            amount,
            from.getCurrency(),
            TransactionType.TRANSFER,
            TransactionStatus.COMPLETED,
            LocalDateTime.now()
        );
        from.addTransaction(tx);
        to.addTransaction(tx);
        System.out.println("Transferred "+ amount+ " from" +from.getName()+ " to "+ to.getName());
    }

    public List<Transacation> getHistory(Account account){
        return account.getTransactionHistory();
    }

    public Optional<Transacation> getLargestTransaction(Account account){
        return account.getTransactionHistory().stream().max(Comparator.comparingDouble(Transacation::amount));
    }

    public double getTotalSpent(Account account){
        return account.getTransactionHistory()
        .stream().filter(tx-> tx.type() == TransactionType.WITHDRAWL || tx.type() == TransactionType.TRANSFER)
        .mapToDouble(Transacation::amount).sum();
    }
}
