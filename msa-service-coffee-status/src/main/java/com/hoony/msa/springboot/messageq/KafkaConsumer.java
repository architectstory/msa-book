package com.hoony.msa.springboot.messageq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.hoony.msa.springboot.repository.ICoffeeStatusMapper;
import com.hoony.msa.springboot.repository.dvo.OrderStatusDVO;

@Service
public class KafkaConsumer {
 
	@Autowired
	ICoffeeStatusMapper iCoffeeStatusMapper;
	
	@KafkaListener(topics="hoony-kafka-test")
    public void processMessage(String kafkaMessage) {
		
		System.out.println("kafkaMessage : =====> " + kafkaMessage);
		
		OrderStatusDVO orderStatusDVO = new OrderStatusDVO();
		orderStatusDVO.setOrderHistory(kafkaMessage);
		
		iCoffeeStatusMapper.insertCoffeeOrderStatus(orderStatusDVO);
    }
}