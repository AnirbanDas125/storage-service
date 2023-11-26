package com.anirban.storageservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anirban.storageservice.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData,Long> {
	
	public Optional<ImageData> findByName(String name);

}
