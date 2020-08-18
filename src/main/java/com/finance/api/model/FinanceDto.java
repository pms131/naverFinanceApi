package com.finance.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="finance")
public class FinanceDto {
	
	@Id
    @Column(name = "itemCode")
	private String itemCode;
	
	private long marketSum;
	
	private double per;
	
	private int eps;
	
	private int now;
	
	private int diff;
	
	private double rate;
	
	private long quant;
	
	private long amount;
	
	private int high;
	
	private int low;
	
	private int risefail;
	
	private LocalDateTime rgstDate;
	
	private LocalDateTime modDate;
	
}
