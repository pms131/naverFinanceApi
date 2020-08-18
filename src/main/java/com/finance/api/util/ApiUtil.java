package com.finance.api.util;

import java.lang.reflect.Type;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ApiUtil {
	
	public <T>T strToObj(String str, Class<T> type) {
		Gson gson = new Gson();
		
		T obj = gson.fromJson(str, (Type)type);
		
		return obj;
	}
}
