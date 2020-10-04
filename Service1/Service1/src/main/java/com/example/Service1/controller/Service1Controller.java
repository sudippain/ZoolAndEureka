package com.example.Service1.controller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Service1.feginclient.Service2Fegin;

@RestController
public class Service1Controller {

	@Autowired
	private Environment env;
	@Autowired
	RestTemplate restTemplate;

	/*
	 * @RequestMapping(method = RequestMethod.GET,value = "/hello1") private String
	 * hello() throws JSONException { JSONObject jsonObject = new JSONObject();
	 * 
	 * jsonObject.put("message", "Service 1 Hello"); jsonObject.put("message-2", new
	 * JSONObject( restTemplate.exchange( "http://localhost:8182/hello2",
	 * HttpMethod.GET,null,String.class).getBody())); return jsonObject.toString();
	 * 
	 * }
	 */
	@Autowired
	private Service2Fegin service2Fegin;

	@RequestMapping(method = RequestMethod.GET, value = "/hello1")
	private String hello() throws JSONException {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("message", "Service 1 Hello");
		jsonObject.put("port", env.getProperty("local.server.port"));
		jsonObject.put("message-2", new JSONObject(service2Fegin.hello()));
		return jsonObject.toString();

	}

}
