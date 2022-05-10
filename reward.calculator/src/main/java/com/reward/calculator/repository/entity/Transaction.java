package com.reward.calculator.repository.entity;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass(TransactionId.class)
@Data
public class Transaction {
	@Id
	@Column(name = "cust_id")
	private int custId;
	@Column(name = "trans_amount")
	private int transId;
	@Column(name = "trans_amount")
	private LocalDate transDate;
	@Column(name = "trans_amount")
	private int transAmount;
}
