package com.hoony.msa.domain.service;

import com.hoony.msa.domain.model.CoffeeOrderCVO;
import com.hoony.msa.domain.model.OrderEntity;
import com.hoony.msa.domain.repository.ICoffeeOrderRepository;

public class CoffeeOrder implements ICoffeeOrder {

	private ICoffeeOrderRepository iCoffeeOrderRepository;

	public CoffeeOrder(ICoffeeOrderRepository iCoffeeOrderRepository) {
		this.iCoffeeOrderRepository = iCoffeeOrderRepository;
	}
	
	@Override
	public String coffeeOrder(CoffeeOrderCVO coffeeOrderCVO) {
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderNumber(coffeeOrderCVO.getOrderNumber());
		orderEntity.setCoffeeName(coffeeOrderCVO.getCoffeeName());
	    orderEntity.setCoffeeCount(coffeeOrderCVO.getCoffeeCount());
	    orderEntity.setCustomerName(coffeeOrderCVO.getCustomerName());
	    
		iCoffeeOrderRepository.coffeeOrderSave(orderEntity);
		
		return orderEntity.getId();
	}
}
