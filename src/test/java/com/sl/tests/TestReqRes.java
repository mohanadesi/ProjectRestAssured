package com.sl.tests;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class TestReqRes {

	public static void main(String[] args) {
	
		
		String C_ID="4";
		String expFirstName="Eve";
		String BaseURL="https://reqres.in";
		RestAssured.baseURI=BaseURL;
		
		
		
		io.restassured.response.Response response = RestAssured
		.given()
		.when()
		.get("/api/users/"+C_ID);
		
		System.out.println(response.asString());
		
		JsonPath jsonPath = response.jsonPath();
		String actFirstName = jsonPath.getString("data.firstname");
		if(expFirstName.equals(actFirstName)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
	}

	

}
