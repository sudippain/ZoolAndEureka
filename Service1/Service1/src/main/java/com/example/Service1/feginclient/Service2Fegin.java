package com.example.Service1.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="service2")
public interface Service2Fegin {
	
	@GetMapping("/hello2")
	String hello();
	

}
