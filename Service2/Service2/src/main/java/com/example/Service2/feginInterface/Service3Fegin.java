package com.example.Service2.feginInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service3")
public interface Service3Fegin {

	@GetMapping("/hello3")
	 String hello();
}
