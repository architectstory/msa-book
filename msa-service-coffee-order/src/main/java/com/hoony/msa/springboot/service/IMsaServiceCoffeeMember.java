package com.hoony.msa.springboot.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("msa-service-coffee-member")
public interface IMsaServiceCoffeeMember{

	@RequestMapping(value = "/coffeeMember/v1.0/{memberName}", method = RequestMethod.GET)
	boolean coffeeMember(@PathVariable("memberName") String memberName);
}
