package com.mockito.SampleProject.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mockito.SampleProject.Dto.FileUploadResponse;
import com.mockito.SampleProject.Dto.StorageProperties;

@Service("storageService")
public class StorageService {

	private final Path dirLocation;
    
	@Autowired
	public  StorageService(StorageProperties properties) {
		this.dirLocation = Paths.get(properties.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.dirLocation);
			Files.createDirectories(Paths.get(properties.getUploadDir())).toAbsolutePath().normalize();
		} catch (Exception e) {

		}
	}

	public FileUploadResponse storeFile(MultipartFile file, String folderName) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String extension = extension(fileName).orElse(null);
		String appendFileName = fileName.split(Pattern.quote("."))[0].concat("-" + System.currentTimeMillis()) + "."
				+ extension;
		String location = null;
		String message = "";
		try {
			String folderPath = this.dirLocation + "\\" + folderName;
			Path path = Paths.get(folderPath);
			if (!Files.exists(path)) {
				path = Files.createDirectory(path);
			}
			Path pathLocation = path.resolve(appendFileName);
			location = pathLocation.toString();
			System.out.println("location" + pathLocation + ":" + file.getInputStream());
			Files.copy(file.getInputStream(), pathLocation, StandardCopyOption.REPLACE_EXISTING);
			message = "file upload successfull";
			FileUploadResponse fileUploadResponse = new FileUploadResponse();
			fileUploadResponse.setFileName(appendFileName);
			fileUploadResponse.setFilePath(location);
			fileUploadResponse.setFileType(file.getContentType());
			fileUploadResponse.setFileSize(file.getSize());
			fileUploadResponse.setMessage(message);
			fileUploadResponse.setOriginalFileName(fileName);
			fileUploadResponse.setUploadedDateAndTime(LocalDateTime.now());
			return fileUploadResponse;
		} catch (Exception e) {
			throw new RuntimeException("file upload name not exits");
		}
	}

	public Optional<String> extension(String fileName) {
		return Optional.ofNullable(fileName).filter(f -> f.contains("."))
				.map(f -> f.substring(fileName.lastIndexOf(".") + 1));
	}
}
