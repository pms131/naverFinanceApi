package com.finance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.finance.api.component.ApiProperty;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(ApiProperty.class)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class FinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceApiApplication.class, args);
	}

}
