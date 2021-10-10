package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "HR")
public class AccountTransaction implements Serializable
{
    private static final long serialVersionUID = 4148515931201071681L;



    private Long transactionId;
    private AccountType accountType;
    private Long memberId;
    private Integer amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long accountTypeId, Integer amount, LocalDate localDate) {
    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Integer amount,
                              LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @Column(name = "TRANSACTION_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }



    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "AMOUNT")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getcreationDate() {
        return transactionDate;
    }

    public void setcreationDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }


    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType()
    {
        return accountType ;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}