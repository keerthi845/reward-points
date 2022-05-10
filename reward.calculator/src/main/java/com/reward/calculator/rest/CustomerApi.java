/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.reward.calculator.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reward.calculator.model.RewardResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Validated
@Api(value = "customer")
@RequestMapping(value = "/v1")
public interface CustomerApi {

    @ApiOperation(value = "Find purchase order by ID", nickname = "getRewardsById", notes = "For valid response try integer IDs with value >= 1 and <= 10.         Other values will generated exceptions",
            response = RewardResponse.class, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RewardResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Order not found") })
    @RequestMapping(value = "/customer/reward/{customerId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<RewardResponse> getRewardsById(@Min(1L) @Max(10L) @ApiParam(value = "ID of pet that needs to be fetched",required=true) @PathVariable("customerId") Long customerId);

}
