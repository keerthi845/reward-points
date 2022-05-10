package com.reward.calculator.service;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.calculator.model.Reward;
import com.reward.calculator.model.RewardResponse;
import com.reward.calculator.repository.TransactionRepository;
import com.reward.calculator.repository.entity.Transaction;
import com.reward.calculator.vo.RewardsVO;

@Service
@Slf4j
public class CustomerRewardService {

	@Autowired
	TransactionRepository transactionRepository;

	public RewardResponse getRewards(Long custId) {

		List<RewardsVO> listRewardsVO = new ArrayList<>();
		RewardsVO rewardsVO;
		RewardResponse rewardResponse = null;
		List<Reward> listReward = new ArrayList<>();
		Reward reward;
		List<Transaction> listTransaction = transactionRepository.findAllByCustId(custId);
		if (listTransaction !=null && listTransaction.size() > 0) {
			for (Transaction transaction : listTransaction) {
				rewardsVO = new RewardsVO();
				rewardsVO.setCustId(transaction.getCustId());
				rewardsVO.setTransId(transaction.getTransId());
				rewardsVO.setTransAmount(transaction.getTransAmount());
				rewardsVO.setTransMonth(transaction.getTransDate().getMonth().toString());
				rewardsVO.setRewardPoints(calculateRewardPoints(transaction.getTransAmount()));
				listRewardsVO.add(rewardsVO);
			}
			Map<String, IntSummaryStatistics> rewardlist = listRewardsVO.stream().collect(Collectors
					.groupingBy(RewardsVO::getTransMonth, Collectors.summarizingInt(RewardsVO::getRewardPoints)));
			log.info("Rewardlist =={}", rewardlist);

			long total_reward_point = 0;
			for (Map.Entry<String, IntSummaryStatistics> entry : rewardlist.entrySet()) {
				reward = new Reward();
				reward.setMonth(entry.getKey());
				reward.setRewardPoint(entry.getValue().getSum());
				listReward.add(reward);
				total_reward_point = total_reward_point + entry.getValue().getSum();
			}
			rewardResponse = new RewardResponse();
			rewardResponse.setCustomerId(custId);
			rewardResponse.setRewards(listReward);
			rewardResponse.setTotalRewardPoint(total_reward_point);
		}
		return rewardResponse;
	}

	private int calculateRewardPoints(int transAmount) {
		int rewardPoints;
		if (transAmount <= 50) {
			rewardPoints = 0;
		} else if (transAmount <= 100) {
			rewardPoints = (transAmount - 50);
		} else {
			rewardPoints = (transAmount - 100) * 2 + 50;
		}

		return rewardPoints;
	}

}
