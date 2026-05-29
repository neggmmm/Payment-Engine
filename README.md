# Payment Engine
A console-based payment processing system built in Java.

## Features
- Multiple account types (Savings, Business) with different transaction limits
- Deposit, withdrawal, transfer operations
- Transaction history per account
- Reporting: total spent, largest transaction
- Custom exceptions for business rule violations

## How to use

1. Clone the repository:
   ```bash
   git clone https://github.com/neggmmm/Payment-Engine.git
   ```
2. Change into the project directory:
   ```bash
   cd payment_engine
   ```
3. Compile the Java source files:
   ```bash
   javac *.java Account/*.java AccountService/*.java Enums/*.java Exceptions/*.java Transaction/*.java Transaction/TransactionService/*.java
   ```
4. Run the application:
   ```bash
   java App
   ```

The application will start in the console and execute the built-in payment engine demo flow. You can modify the source files and rerun the compile/run commands to test changes.

## Sample Output
[+] Saving account created: [SAVINGS] negm | Balance: 56000.00 EGP
[+] Business account created

--- Transactions ---
[+] Deposited 5000.0 -> negm
[+] Withdrawn  2000.0 from negm
Transferred 3000.0 fromnegm to ahmed

--- Testing Exceptions ---
[â??] Insufficient funds is: negm | Requested: 932222.0 and your balance: 56000.0
[â??] Deposit amount must be positive

--- Negm's Statement ---
  DEPOSIT | 5000.00 EGP | COMPLETED | 2026-05-29
  WITHDRAWL | 2000.00 EGP | COMPLETED | 2026-05-29
  TRANSFER | 3000.00 EGP | COMPLETED | 2026-05-29

Total Spent:        5000.00 EGP
Largest Transaction: 5000.00 EGP

--- Final Balances ---
[SAVINGS] negm | Balance: 56000.00 EGP
[BUSINESS] ahmed | Balance: 103000.00 USD