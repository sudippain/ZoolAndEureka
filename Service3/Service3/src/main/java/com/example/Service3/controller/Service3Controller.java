package com.example.Service3.controller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service3Controller {
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
		
	}
	
	
	  @Autowired private Environment env;
	 
	/*
	 * @Value("${server.port}") private String port;
	 */
	
	@RequestMapping(method = RequestMethod.GET,value = "/hello3")
	private String  hello() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "Service3 Hello");
		jsonObject.put("port", env.getProperty("local.server.port"));
		/* jsonObject.put("port",port ); */
		/* jsonObject.put("Another Port", env.getProperty("server.port")); */
		
		return jsonObject.toString();
		
	}
	

}
