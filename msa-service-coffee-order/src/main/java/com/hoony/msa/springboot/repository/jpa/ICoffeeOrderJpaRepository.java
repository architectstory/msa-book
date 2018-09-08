package com.hoony.msa.springboot.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoffeeOrderJpaRepository extends CrudRepository<OrderEntityJPO, String>{
	
}

