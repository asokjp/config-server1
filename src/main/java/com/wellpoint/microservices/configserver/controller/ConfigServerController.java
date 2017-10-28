package com.wellpoint.microservices.configserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigServerController {
	
	@RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
	public String healthCheck()

	{
		return "okay";
	}

}
