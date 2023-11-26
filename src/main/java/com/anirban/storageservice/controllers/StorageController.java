package com.anirban.storageservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anirban.storageservice.services.StorageService;

@RestController
public class StorageController {
	
	@Autowired
	private StorageService storageService;
	
	

}
