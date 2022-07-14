package com.aritra.aws.spring.boot.xray.dao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author arungupta
 */
@DynamoDBTable(tableName = "S3Tableslist")
public class S3Details {

	private String id;
	private Integer size ;
	

	public S3Details() {
	}
	
	public S3Details(String id, Integer size) {
		this.id = id;
		this.size = size;
		
	}

	@DynamoDBHashKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	
	@Override
	public String toString() {
		return "id: " + getId() 
		+ ", size: " + getSize();
	}

}