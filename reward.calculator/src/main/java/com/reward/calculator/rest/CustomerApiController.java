package com.reward.calculator.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reward.calculator.model.RewardResponse;
import com.reward.calculator.service.CustomerRewardService;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Slf4j
@Controller
@Data
public class CustomerApiController implements CustomerApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    CustomerRewardService customerRewardService;

    public ResponseEntity<RewardResponse> getRewardsById(
            @Min(1L) @Max(10L) @ApiParam(value = "ID of pet that needs to be fetched", required = true)
            @PathVariable("customerId") Long customerId) {
        log.info("in controller");
        RewardResponse rewardResponse;
        if (customerId != null) {
            try {
                rewardResponse = customerRewardService.getRewards(customerId);
                if (rewardResponse == null) {
                    rewardResponse = new RewardResponse();
                    rewardResponse.setCustomerId(customerId);
                    rewardResponse.setMessage("No Result returned");
                }
                return new ResponseEntity<>(rewardResponse, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
