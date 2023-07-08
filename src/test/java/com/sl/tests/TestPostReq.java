package com.sl.tests;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestPostReq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String BaseURL = "https://reqres.in";
		RestAssured.baseURI = BaseURL;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Mohana");
		jsonObject.put("job", "Automation-Engineer");
		
		Response response = RestAssured
				.given()
				.header("Content-Type","application/json")
				.body(jsonObject.toString())
				.when()
				.post("/api/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.getString("id"));
		System.out.println(jsonPath.getString("name"));
	}

}
