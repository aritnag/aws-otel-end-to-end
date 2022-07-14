package com.aritra.aws.spring.boot.xray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.xray.interceptors.TracingInterceptor;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.aritra.aws.spring.boot.xray.dao.UpdateDynamoDb;
import com.aritra.aws.spring.boot.xray.service.clients.TestClient;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;

@Slf4j
@Service
@Transactional
@XRayEnabled
public class TestService {

	@Autowired
	private TestClient testClient;
	
	@Autowired
	private UpdateDynamoDb updateDynamoDb;

	
	public int test(String bucket) {
        
        
        S3Client s3Client = S3Client.builder()
									.region(Region.EU_WEST_1)
									.overrideConfiguration(ClientOverrideConfiguration.builder()
											.addExecutionInterceptor(new TracingInterceptor())
											.build())
								.build();		
		s3Client.listBuckets();	
        
		testClient.getNordcloud();
        
		log.debug("Serviced");
        return updateDynamoDb.fetchrecord(s3Client.listBuckets().buckets().size());
	}
	
}
