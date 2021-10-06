package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {


    private static final long serialVersionUID = -7131672569842668713L;
    private Long AccountTypeId;
    private Integer amount;
    private LocalDate creationDate;

    public AccountTransactionDto( Integer amount, LocalDate creationDate) {
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public AccountTransactionDto( Long AccountTypeId, Integer amount) {
        this.AccountTypeId = AccountTypeId;
        this.amount = amount;
        this.creationDate = LocalDate.now();
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setAmount(accountTransaction.getAmount());
        this.setcreationDate(accountTransaction.getcreationDate());
    }

    public AccountTransactionDto() {

    }

    @ApiModelProperty(position = 1,
            value = "Account Type ID fo the account transaction",
            name = "accountTypeId",
            notes = "Uniquely identifies the account type of the account on which a transaction was performed",
            dataType = "java.lang.Long",
            example = "3",
            required = true)
    public Long getAccountTypeId() {
        return AccountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        AccountTypeId = accountTypeId;
    }





    @ApiModelProperty(
            position = 3,
            value = "Amount",
            name = "Amount",
            notes = "Amount on the member's account",
            dataType = "java.lang.String",
            example = "200",
            required = true
    )
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @ApiModelProperty(
            position = 4,
            value = "Transaction Date",
            name = "creationDate",
            notes = "The date the transaction occurred",
            dataType = "java.lang.String",
            example = "2021-02-01",
            required = true
    )
    public LocalDate getcreationDate() {
        return creationDate;
    }

    public void setcreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @JsonIgnore
    public AccountTransaction getTransaction() {
        return new AccountTransaction(getAccountTypeId(),getAmount(),getcreationDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(AccountTypeId, that.AccountTypeId)  && Objects.equals(amount, that.amount) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountTypeId, amount, creationDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "AccountTypeId=" + AccountTypeId +
                ", amount=" + amount +
                ", creationDate=" + creationDate +
                '}';
    }
}
