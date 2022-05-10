package com.reward.calculator.vo;

import lombok.Data;

@Data
public class RewardsVO {

	private int custId;
	private int transId;
	private String transMonth;
	private int transAmount;
	private int rewardPoints;

}
