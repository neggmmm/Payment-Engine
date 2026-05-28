package AccountService;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import Account.*;
import Enums.Currency;
import Exceptions.AccountNotFoundException;

public class AccountServiceImpl implements AccountService{
   private HashMap<String, Account> accounts = new HashMap<>();

   public Account createSavingsAccount(String name, Currency currency, double balance){
    String id = UUID.randomUUID().toString();
    Account account = new SavingsAccount(id,name,currency,balance);
    accounts.put(id,account);
    System.out.println("[+] Saving account created: " + account);
    return account;
   }

   public Account createBusinessAccount(String name, Currency currency, double balance){
    String id = UUID.randomUUID().toString();
    Account account = new BusinessAccount(id,name,currency,balance);
    accounts.put(id,account);
    System.out.println("[+] Business account created");
    return account;
   }

   public Account findById(String id){
    return Optional.ofNullable(accounts.get(id)).orElseThrow(() -> new AccountNotFoundException(id));
   }

   public void displayAllAccounts(){
    accounts.values().stream().forEach(System.out::println);
   }
}
