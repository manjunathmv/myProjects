package com.ims.purchasedepartment.controller;

import java.io.IOException;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ims.purchasedepartment.service.AwsS3BucketFileService;

@RestController
@RequestMapping("/test/storage/")
public class AwsS3BucketFileController {

	private AwsS3BucketFileService s3FileService;

	
	@Autowired
	AwsS3BucketFileController(AwsS3BucketFileService s3FileService){
		this.s3FileService=s3FileService;
	}

	@PostMapping("/uploadFile")
	 public String uploadFile(@RequestPart(value="file") MultipartFile file) throws IOException {
		return this.s3FileService.uploadFile(file);
		 
	 }
}
