package com.reward.calculator.repository.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;

@Data
public class TransactionId implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cust_id")
    private int custId;
    @Column(name = "trans_id")
    private int transId;
    @Column(name = "trans_date")
    private LocalDate transDate;
}
