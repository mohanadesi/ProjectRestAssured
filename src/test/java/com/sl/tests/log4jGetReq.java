package com.sl.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sl.listeners.RestAssuredListener;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;

public class log4jGetReq {
	
	private static final Logger logger = LogManager.getLogger(log4jGetReq.class);
	
	@Test
	public void test_1() {
		
		logger.info("test_1 execution started..,");
		// TODO Auto-generated method stub
		Response response = get("https://reqres.in/api/users?page=2");
		
			System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusLine());
			System.out.println(response.getHeader("content-type"));
	
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			
			logger.info("test_1 execution ended...");
	}
	
	
	@Test
	public void test_2() {
		logger.info("test_2 execution started..,");
		baseURI = "https://reqres.in";
		given().filter(new RestAssuredListener()).contentType(ContentType.JSON)
		.get("/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data[1].id", equalTo(8));
		
		logger.info("test_2 execution ended..,");
	}
	@Test
	public void test_3() {
		logger.info("test_3 execution started..,");
		baseURI = "https://reqres.in";
		given().filter(new RestAssuredListener()).contentType(ContentType.JSON)
		.get("/api/users?page=2")
		.then()
		.assertThat().statusCode(201);
		
		logger.info("test_3 execution ended..,");
	}
	

}
