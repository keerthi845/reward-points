package com.reward.calculator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reward.calculator.repository.entity.Transaction;
import com.reward.calculator.repository.entity.TransactionId;

public interface TransactionRepository extends CrudRepository<Transaction, TransactionId> {

	@Query(nativeQuery = true,value = "SELECT * FROM TRANSACTION WHERE CUST_ID = ?1 AND TRANS_DATE> DATEADD('MONTH',-3, CURRENT_DATE)")
	List<Transaction> findAllByCustId(Long custId);

}
