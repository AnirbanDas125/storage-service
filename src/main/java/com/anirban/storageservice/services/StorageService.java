package com.anirban.storageservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anirban.storageservice.repository.StorageRepository;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepo;
}
