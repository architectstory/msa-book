package com.hoony.msa.springboot.repository.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hoony.msa.domain.model.OrderEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class OrderEntityJPO extends OrderEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
	
    String orderNumber; //주문번호 
    String coffeeName;  //커피종류 
    String coffeeCount; //커피개수 
    String customerName;//회원명 
}