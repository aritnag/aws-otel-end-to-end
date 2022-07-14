package com.aritra.aws.spring.boot.xray.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UpdateDynamoDb {

   
	private static AmazonDynamoDB dynamodbClient;
	
	private static AmazonDynamoDB getClient() {
		
		
		dynamodbClient = AmazonDynamoDBClientBuilder.standard()
	            .withRegion(Regions.EU_WEST_1)
	            .build();
		
		return dynamodbClient;
	}
	
	public int fetchrecord(Integer size) {
		DynamoDBMapper mapper = new DynamoDBMapper(getClient());
        String uniqueID = "123456";
        log.debug(("unique id"+ uniqueID));
        S3Details bookkey = new S3Details();
        bookkey.setId(uniqueID);
		DynamoDBQueryExpression<S3Details> queryExpression = new DynamoDBQueryExpression<S3Details>()
        .withHashKeyValues(bookkey);
        List<S3Details> latestReplies =  mapper.query(S3Details.class, queryExpression);
        log.debug("size"+latestReplies.size());
        return latestReplies.size();
	}
}
