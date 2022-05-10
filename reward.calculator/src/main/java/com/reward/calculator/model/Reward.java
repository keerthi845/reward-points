package com.reward.calculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;


@Data
public class Reward {
    @JsonProperty("month")
    private String month = null;

    @JsonProperty("rewardPoint")
    private Long rewardPoint = null;

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reward reward = (Reward) o;
        return Objects.equals(this.month, reward.month) &&
                Objects.equals(this.rewardPoint, reward.rewardPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, rewardPoint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Reward {\n");

        sb.append("    month: ").append(toIndentedString(month)).append("\n");
        sb.append("    rewardPoint: ").append(toIndentedString(rewardPoint)).append("\n");
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

