package com.finance.api.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("naver.api")
public class ApiProperty {
	private String url;

}
