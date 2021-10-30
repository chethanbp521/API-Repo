package sdet21.ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet21.GenericUtilities.JavaUtility;
import sdet21.POJO_Class.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class RequestChaining_Get 
{
	@Test
	public void RequestChainingForGet()
	{
		JavaUtility jLib = new JavaUtility();
		
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary pLib = new ProjectLibrary("Chethan", "Aorus "+jLib.getRandomNumber(), "Completed", 20);
		
		//Create a new Project
		Response res = given()
					   .contentType(ContentType.JSON)
					   .body(pLib)
					   .when()
					   .post("/addProject");
				
		//Store the Project ID using JSON path
		String myProjID = res.jsonPath().get("projectId");
		System.out.println(myProjID);
				
		res.then().log().all();
			
		//2nd request to read the same project created in 1st request
		given()
		.pathParam("projID", myProjID)
				
		.when()
		.get("/projects/{projID}")
				
		.then().assertThat().statusCode(200).log().all();
	}
	
}