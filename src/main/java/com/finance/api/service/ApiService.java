package com.finance.api.service;

import com.finance.api.model.FinanceDto;

public interface ApiService {
	
	public FinanceDto setFinance(String itemCode, String finance) throws Exception;
	
	public String getFinance(String itemCode) throws Exception;
}
