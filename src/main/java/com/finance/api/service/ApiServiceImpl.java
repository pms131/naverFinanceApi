package com.finance.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.api.client.ApiClient;
import com.finance.api.model.FinanceDto;
import com.finance.api.repository.ApiRepository;
import com.finance.api.util.ApiUtil;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	ApiRepository apiRepository;
	
	@Autowired
	private ApiClient apiClient;
	
	@Autowired
	ApiUtil apiUtil;
	
	LocalDateTime sysDate = LocalDateTime.now(); 
	
	@Override
	public FinanceDto setFinance(String itemCode, String str) throws Exception {
		FinanceDto obj = apiUtil.strToObj(str, FinanceDto.class);
		obj.setItemCode(itemCode);
		obj.setRgstDate(sysDate);
		obj.setModDate(sysDate);
		return apiRepository.save(obj);
	}

	@Override
	public String getFinance(String itemCode) throws Exception {
		return apiClient.getFinance(itemCode);
	}
	

}
