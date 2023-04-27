package com.mockito.SampleProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mockito.SampleProject.Dto.FileUploadResponse;

@Service
public class FileService {

	@Autowired
	StorageService storageService;
	
	public ResponseEntity<List<FileUploadResponse>> upload(String uploadFileDetails ,MultipartFile[] file){
		List<FileUploadResponse> responseList=new ArrayList<>();
		if(file.length>0) {
			String folderName=uploadFileDetails;
			for(MultipartFile partFile:file) {
				FileUploadResponse upload=storageService.storeFile(partFile, folderName);
				responseList.add(upload);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseList);
	}
}
