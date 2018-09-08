package com.hoony.msa.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoony.msa.domain.repository.ICoffeeOrderRepository;
import com.hoony.msa.domain.service.CoffeeOrder;

@Service
@Transactional
public class CoffeeOrderServiceImpl extends CoffeeOrder{
 
	public CoffeeOrderServiceImpl(ICoffeeOrderRepository iCoffeeOrderRepository) {
		super(iCoffeeOrderRepository);
	}
}
