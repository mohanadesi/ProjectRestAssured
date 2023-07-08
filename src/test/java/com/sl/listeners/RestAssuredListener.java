package com.sl.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestAssuredListener implements Filter{
	private static final Logger logger = LogManager.getLogger(RestAssuredListener.class);
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		Response response = ctx.next(requestSpec,responseSpec);
		
		//if(response.getStatusCode()!= 201) {
			
			//System.out.println("Log error message is getting printed after TestFailure");
			
			logger.info("\n Method => " +requestSpec.getMethod() +"\n URI => "+requestSpec.getURI()+"\n RequestBody => "+requestSpec.getBody()+
					"\n RequestBody => "+response.getBody().prettyPrint());
			
			
			
		//}
		
		return response;
	}
	
	

}
