package com.anirban.storageservice.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anirban.storageservice.entity.ImageData;
import com.anirban.storageservice.repository.StorageRepository;
import com.anirban.storageservice.util.ImageUtil;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepo;
	
	//This class called MultipartFile is responsible for handling large byte objects such as images
    public String uploadImage(MultipartFile multipartFile) throws IOException {
    
		ImageData imageData = new ImageData();
		imageData.setName(multipartFile.getOriginalFilename());
		imageData.setType(multipartFile.getContentType());
		//we cannot set this large byte file like this, we have to compress it before that		
		imageData.setImageData(ImageUtil.compressImage(multipartFile.getBytes()));
    	storageRepo.save(imageData);
    	
        return multipartFile.getOriginalFilename()+" UpLoaded Successfully...!";
	}
    
    public byte[] downloadImage(String name) {
    	
    	Optional<ImageData> opImageData = storageRepo.findByName(name);
    	
    	if(opImageData.isEmpty()) {
    		throw new RuntimeException("Image not found by name");
    	}
    	
    	  return ImageUtil.decompressImage(opImageData.get().getImageData());
    }
}
