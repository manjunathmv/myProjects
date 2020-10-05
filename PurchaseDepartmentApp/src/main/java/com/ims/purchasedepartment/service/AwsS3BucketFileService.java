package com.ims.purchasedepartment.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.apache.http.impl.client.BasicCredentialsProvider;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;



@Service
public class AwsS3BucketFileService {
	
	private  Logger logger = Logger.getLogger(AwsS3BucketFileService.class.getName());
	private AmazonS3 s3Client;
	
	@Value("${amazonProperties.endPointUrl}")
	private String endPointUrl;
	
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	
	@Value("${amazonProperties.accessKey}")
    private String accessKey;
  
	@Value("${amazonProperties.secrityKey}")
    private String secrityKey;
    
    
	
	@PostConstruct
	private void intializeAmazon() {
		AWSCredentials credentials= new BasicAWSCredentials(this.accessKey,this.secrityKey);
	  this.s3Client= new AmazonS3Client(credentials); 
			  }
	public String uploadFile(MultipartFile mPartFile) throws IOException {
		String fileUrl="";
	try {
		File nFile=convertMultiPartFile(mPartFile);
		String fileName=generateFileName(mPartFile);
		fileUrl= endPointUrl+ "/" +bucketName+ "/" +fileName;
		uploadFileToS3Bucket(fileName, nFile);
		nFile.delete();
	}catch (AmazonServiceException e) {
			logger.info("Error Message "+e.getErrorMessage());
			logger.info(" HTTP Status Code"+e.getStatusCode());
			logger.info("AWS Error Code"+e.getErrorCode());
			logger.info("Error type"+e.getErrorType());
			logger.info("Request ID "+e.getRequestId());
			
	}
		return fileUrl;
	}

	private void uploadFileToS3Bucket(String fileName,File file) {
		s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
	}
	
	private String generateFileName(MultipartFile multipartFile) {
		
		return new Date().getTime() +"-"+multipartFile.getOriginalFilename().replace(" ", "_");
	}
	
	
	private File convertMultiPartFile(MultipartFile mFile)  throws IOException {
		File conFile= new File(mFile.getOriginalFilename());
		FileOutputStream fOutputStream= new FileOutputStream(conFile);
		fOutputStream.write(mFile.getBytes());
		fOutputStream.close();
		return conFile; 		
	}
}
