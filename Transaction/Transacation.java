package Transaction;

import java.time.LocalDateTime;
import Enums.Currency;
import Enums.TransactionStatus;
import Enums.TransactionType;

public record Transcation(
    String id,
    String fromAccount,
    String toAccountId,
    double amount,
    Currency currency,
    TransactionType type,
    TransactionStatus status,
    LocalDateTime createdAt
){}
