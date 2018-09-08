package com.hoony.msa.springboot.messageq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoony.msa.domain.model.CoffeeOrderCVO;

@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public CoffeeOrderCVO send(String kafkaTopic, CoffeeOrderCVO coffeeOrderCVO) {
	    	    
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";
		try {
			jsonInString = mapper.writeValueAsString(coffeeOrderCVO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	    kafkaTemplate.send(kafkaTopic, jsonInString);
	    
	    System.out.println("KafkaProducer send data from msa-service-coffee-order: " + coffeeOrderCVO);
	    
	    return coffeeOrderCVO;
	}
}