package com.reward.calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RewardResponse {
	@JsonProperty("customerId")
	private Long customerId = null;

	@JsonProperty("rewards")
	@Valid
	private List<Reward> rewards = null;

	@JsonProperty("totalRewardPoint")
	private Long totalRewardPoint = null;

	@JsonProperty("message")
	private String message = null;

	public RewardResponse customerId(Long customerId) {
		this.customerId = customerId;
		return this;
	}
   public RewardResponse rewards(List<Reward> rewards) {
		this.rewards = rewards;
		return this;
	}

	public RewardResponse addRewardsItem(Reward rewardsItem) {
		if (this.rewards == null) {
			this.rewards = new ArrayList<Reward>();
		}
		this.rewards.add(rewardsItem);
		return this;
	}

	public RewardResponse totalRewardPoint(Long totalRewardPoint) {
		this.totalRewardPoint = totalRewardPoint;
		return this;
	}

	/**
	 * Get totalRewardPoint
	 * 
	 * @return totalRewardPoint
	 **/

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RewardResponse rewardResponse = (RewardResponse) o;
		return Objects.equals(this.customerId, rewardResponse.customerId)
				&& Objects.equals(this.rewards, rewardResponse.rewards)
				&& Objects.equals(this.totalRewardPoint, rewardResponse.totalRewardPoint)
				&& Objects.equals(this.message, rewardResponse.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, rewards, totalRewardPoint);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RewardResponse {\n");

		sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
		sb.append("    rewards: ").append(toIndentedString(rewards)).append("\n");
		sb.append("    totalRewardPoint: ").append(toIndentedString(totalRewardPoint)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
