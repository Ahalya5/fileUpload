package com.mockito.SampleProject.Dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class FileUploadResponse {
	 private String fileName;
	    private String filePath;
	    private String message;
	    private String originalFileName;
	    private String fileType;
	    private Long fileSize;
	    private LocalDateTime uploadedDateAndTime;

}
