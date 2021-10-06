package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;


@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {

    @Query( // Use this if you're working with multiple tables, joins etc.
            value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto("+
                    "at.mnemonic,"+"at.accountTypeName,"+"at.creationDate) "+
                    "FROM "+"AccountType at "+"WHERE at.mnemonic = :mnemonic"
    )
    AccountType getAccountTypeByMnemonic(String mnemonic);
}
