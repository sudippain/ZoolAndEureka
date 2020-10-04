package com.example.Service2.controller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Service2.feginInterface.Service3Fegin;

@RestController
public class Service2Controller {
	
		
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	
	@Autowired
	private Environment env;
	
	@Autowired
	private Service3Fegin service3fegin;
	
	@RequestMapping(method = RequestMethod.GET,value = "/hello2")
	private String  hello() throws JSONException {
		 JSONObject jsonObject = new JSONObject();
		 jsonObject.put("message", "Service2 Hello");
		 jsonObject.put("port", env.getProperty("local.server.port"));
			/*
			 * jsonObject.put("message-3", new JSONObject( restTemplate.exchange(
			 * "http://localhost:8183/hello3",
			 * HttpMethod.GET,null,String.class).getBody()));
			 */
		 
		 jsonObject.put("message-3",new JSONObject(service3fegin.hello()));
	     return jsonObject.toString();

	}

}
