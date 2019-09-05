package com.example.bucket.controller;

import com.example.bucket.service.AmazonClient;
import com.example.daolayer.Daolayer;
import com.example.dbentity.ImgLog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage/")
public class BucketController {
	
	@Autowired
	Daolayer dao;

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
    
    @GetMapping("/receive")
    public List<ImgLog> receive() {
        return dao.findAll();
    	
    }
    
    
}

/* 
 * 
 * amazonProperties:
     accessKey: AKIAY2HSDAGAW2WVDPHU
     bucketName: bjpanda
     endpointUrl: https://bjpanda.s3.amazonaws.com
    secretKey: Nqbx3PdFpg2HU68iKiRsBlq97Bc1MrLQw7PG5H0+
server:
  port: 8090
spring:
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    password: 51a510
    url: jdbc:mariadb://localhost:3306/demo
    username: root
  jpa:
    hibernate:
      ddl-auto: none
 */
