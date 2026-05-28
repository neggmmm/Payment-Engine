import Account.Account;
import AccountService.AccountService;
import AccountService.AccountServiceImpl;
import Enums.Currency;

public class App{
    public static void main(String[] args){
        AccountService service = new AccountServiceImpl();


        Account negm = service.createSavingsAccount("negm", Currency.EGP, 56000);
        Account ahmed = service.createBusinessAccount("ahmed", Currency.USD, 100000);

        System.out.println("-- ALL ACCOUNTS --");
        service.displayAllAccounts();

        System.out.println("FIND BY ID");
        System.out.println(service.findById(negm.getId()));
    }
}