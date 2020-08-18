package com.finance.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${naver.api.url}", name="FinanceApi")
public interface ApiClient {
	@GetMapping(value= "/itemSummary.nhn?itemcode={itemCode}", produces = "application/json")
	public String getFinance(@PathVariable("itemCode") String itemCode) throws Exception;
}
