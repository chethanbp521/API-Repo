package sdet21.ComplexResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponse 
{
	@Test
	public void staticResponse()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		String expData = "TY_PROJ_001";
		
		//Store all the responses
		Response res = when()
					   .get("/projects");
		
		//Store the data using JSON path
		String actData = res.jsonPath().get("[0].projectId");
		System.out.println(actData);
		
		//Validate
		Assert.assertEquals(actData, expData);
		System.out.println(actData + "data verified");
		
		res.then().log().all();
		
		}

}
