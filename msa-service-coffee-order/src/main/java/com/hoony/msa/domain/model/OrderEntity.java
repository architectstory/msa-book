package com.hoony.msa.domain.model;

import lombok.Data;

@Data
public class OrderEntity {
	private String id;
	private String orderNumber; //주문번호 
	private String coffeeName;  //커피종류 
	private String coffeeCount; //커피개수 
	private String customerName;//회원명  
}
