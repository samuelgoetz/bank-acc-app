package com.goetz.accsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.goetz.accsystem.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    //search all transaction by iban 
    List<Transaction> findAllByAccountIban(String iban);

    //search last Transaction from certain Customer 
    @Query(value = "SELECT * FROM transaction WHERE account_id = ?1 ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Optional<Transaction> findLatestTransactionByAccountId(Long id);
}