import Account.Account;
import AccountService.AccountService;
import AccountService.AccountServiceImpl;
import Enums.Currency;
import Exceptions.InsufficientFundsException;
import Exceptions.InvalidTransactionException;
import Transaction.TransactionService.TransactionService;
import Transaction.TransactionService.TransactionServiceImpl;

public class App {
    public static void main(String[] args) {
        AccountService service = new AccountServiceImpl();
        TransactionService txService = new TransactionServiceImpl();

        Account negm = service.createSavingsAccount("negm", Currency.EGP, 56000);
        Account ahmed = service.createBusinessAccount("ahmed", Currency.USD, 100000);

        System.out.println("\n--- Transactions ---");
        txService.deposit(negm, 5000);
        txService.withdraw(negm, 2000);
        txService.transfer(negm, ahmed, 3000);

        // test exceptions
        System.out.println("\n--- Testing Exceptions ---");
        try {
            txService.withdraw(negm, 932222);
        } catch (InsufficientFundsException e) {
            System.out.println("[✗] " + e.getMessage());
        }

        try {
            txService.deposit(negm, -500);
        } catch (InvalidTransactionException e) {
            System.out.println("[✗] " + e.getMessage());
        }

        // reporting
        System.out.println("\n--- Negm's Statement ---");
        txService.getHistory(negm).forEach(tx -> System.out.printf("  %s | %.2f %s | %s | %s%n",
                tx.type(), tx.amount(), tx.currency(),
                tx.status(), tx.createdAt().toLocalDate()));

        System.out.printf("%nTotal Spent:        %.2f EGP%n", txService.getTotalSpent(negm));
        txService.getLargestTransaction(negm)
                .ifPresent(tx -> System.out.printf("Largest Transaction: %.2f EGP%n", tx.amount()));

        System.out.println("\n--- Final Balances ---");
        service.displayAllAccounts();
    }
}