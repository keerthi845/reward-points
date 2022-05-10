package com.reward.calculator.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.reward.calculator.repository.TransactionRepository;
import com.reward.calculator.repository.entity.Transaction;

@ExtendWith(MockitoExtension.class)
public class CustomerRewardServiceTest {
	@InjectMocks
	CustomerRewardService customerRewardService;
	@Mock
	private TransactionRepository transactionRepository;
	List<Transaction> transactionsList;

	@BeforeEach
	void setUp() {
		transactionsList = new ArrayList<>();
		Transaction transaction = new Transaction();
		transaction.setCustId(1);
		transaction.setTransAmount(195);
		transaction.setTransDate(LocalDate.of(2022, 3, 8));
		transaction.setTransId(1);
		transactionsList.add(transaction);
	}

	@Test
	public void testgetRewards() {
		when(transactionRepository.findAllByCustId(any())).thenReturn(transactionsList);
		assertNotNull(customerRewardService.getRewards(1L));
	}

}
