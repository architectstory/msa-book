package com.hoony.msa.domain.repository;

import com.hoony.msa.domain.model.OrderEntity;

public interface ICoffeeOrderRepository {

	public String coffeeOrderSave(OrderEntity orderEntity);

}
