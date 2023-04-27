package com.mockito.SampleProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockito.SampleProject.Dto.FileUploadResponse;
import com.mockito.SampleProject.Service.FileService;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class FileController {

	@Autowired
	FileService fileService;

	@RequestMapping(value = { "/file/upload"}, method = {
			RequestMethod.POST }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "content-type=application/json")
	public ResponseEntity<List<FileUploadResponse>> response(
			@RequestParam("uploadFileDetails") String uploadFileDetails,
			@RequestParam(value = "file") MultipartFile[] file) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return fileService.upload(uploadFileDetails, file);
	}

}
