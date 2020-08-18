package com.finance.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finance.api.component.ApiProperty;
import com.finance.api.model.FinanceDto;
import com.finance.api.service.ApiServiceImpl;
import com.finance.api.util.ApiUtil;

@RestController
@Component
@EnableJpaRepositories("com.finance.api.repository")
@RequestMapping(value = "/api")
public class ApiController {
	
	@Autowired
	ApiServiceImpl apiServiceImpl;

	
	@Autowired
	ApiProperty apiProperty;
	
	ApiUtil apiUtil;

	static final String KOSDAQ = "KQ";
	static final String KOSPI = "KS";
	
	@GetMapping(value = "/insertFinance")
	public ResponseEntity<ArrayList<FinanceDto>> getFinance(RedirectAttributes redirect) throws JSONException {
		//ModelAndView mv = new ModelAndView();
		ArrayList<String> itemCodeList = new ArrayList<String>();
		ArrayList<FinanceDto> financeList = new ArrayList<FinanceDto>();
		//Map<String, String> paramMap = new HashMap<String, String>();

		/* OkHttpClient client = new OkHttpClient(); */
		//final String url = apiProperty.getUrl();
		

		/*
		 * Request request = new Request.Builder() .url(url + itemCode) .get() .build();
		 */

		try {
			/** TODO : itemCode 받아오는 로직 추가 S **/
			
			itemCodeList.add("131390");
			itemCodeList.add("005930");
			
			/** itemCode 받아오는 로직 추가 E **/
			
			if (itemCodeList != null) {
				for (String itemCode: itemCodeList) {
					String str = apiServiceImpl.getFinance(itemCode);
					
					FinanceDto finance = apiServiceImpl.setFinance(itemCode, str);
					
					financeList.add(finance);
					//paramMap.put(itemCode, finance);
				}

				/** 파라미터를 URL에 노출시키지 않기위해, addFlashAttribute 활용 **/
				//redirect.addFlashAttribute("paramMap", paramMap);
				//mv.setViewName("redirect:/api/saveFinance");
				return new ResponseEntity<ArrayList<FinanceDto>>(financeList, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<ArrayList<FinanceDto>>(HttpStatus.EXPECTATION_FAILED);
	}

    // Feign Client 요청에 응답을 주기 위한 컨트롤러
    @RequestMapping("/testfeign")
    public String testFeign(String itemCode) {
        return "Hello Feign Cleint~ " + itemCode;
    }
}
