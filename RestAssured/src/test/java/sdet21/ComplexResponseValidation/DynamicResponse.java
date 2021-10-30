package sdet21.ComplexResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponse 
{
	@Test
	public void dynamicResponse()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		String expData = "Apple";
		
		//Store the response
		Response res = when().get("/projects");
		
		//Get all the project names and store it in List
		List<String> pNames = res.jsonPath().get("projectName");
		
		for(String actData : pNames)
		{
			if(actData.equalsIgnoreCase(expData))
			{
				Assert.assertEquals(actData, expData);
				System.out.println(actData +" Project data present");
				break;
			}
		}
		
		//Validation
		res.then().log().all();
	}

}
