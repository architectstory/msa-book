package com.hoony.msa.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoony.msa.domain.model.CoffeeOrderCVO;
import com.hoony.msa.springboot.messageq.KafkaProducer;
import com.hoony.msa.springboot.service.CoffeeOrderServiceImpl;
import com.hoony.msa.springboot.service.IMsaServiceCoffeeMember;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CoffeeOrderRestController {
	
	@Autowired
	private CoffeeOrderServiceImpl coffeeOrderServiceImpl;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
	private IMsaServiceCoffeeMember iMsaServiceCoffeeMember;
	
	@HystrixCommand
	@RequestMapping(value = "/coffeeOrder", method = RequestMethod.POST)
	public ResponseEntity<CoffeeOrderCVO> coffeeOrder(@RequestBody CoffeeOrderCVO coffeeOrderCVO) {
		
		//is member
		if(iMsaServiceCoffeeMember.coffeeMember(coffeeOrderCVO.getCustomerName())) {
			System.out.println(coffeeOrderCVO.getCustomerName() + " is a member!");
		}
		
		//coffee order
		coffeeOrderServiceImpl.coffeeOrder(coffeeOrderCVO);

		//kafka
		kafkaProducer.send("hoony-kafka-test", coffeeOrderCVO);
		
		return new ResponseEntity<CoffeeOrderCVO>(coffeeOrderCVO, HttpStatus.OK);
	}
}
