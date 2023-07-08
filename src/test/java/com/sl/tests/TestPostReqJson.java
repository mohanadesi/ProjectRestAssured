package com.sl.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class TestPostReqJson {

	public static void main(String[] args) {
		String BaseURL = "https://reqres.in";
		RestAssured.baseURI = BaseURL;
		LibraryReqResData lib = new LibraryReqResData();
		String userData = lib.ReadFileToString();
		
		Response response = RestAssured
				.given()
				.header("Content-Type","application/json")
				.body(userData)
				.when()
				.post("/api/users");
			
				System.out.println(response.getStatusCode());
				System.out.println(response.getBody().asString());
				
				JsonPath jsonPath = response.jsonPath();
				System.out.println(jsonPath.getString("id"));
				System.out.println(jsonPath.getString("name"));
		

	}

}
