package com.todo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.service.configuration.ServiceDatabaseConfiguration;


@RestController
public class ServiceConfigurationController {

	@Autowired 
	private ServiceDatabaseConfiguration databaseConfiguration;
	
	@RequestMapping("/getDatabaseConfiguration")
	public ServiceDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}
}
