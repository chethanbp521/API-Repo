package sdet21.EndToEnd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet21.GenericUtilities.BaseAPIClass;
import sdet21.GenericUtilities.Endpoints;
import sdet21.POJO_Class.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateNewProjectAndVerifyInDatabase extends BaseAPIClass
{
	@Test
	public void createProjectAndVerifyInDB() throws Throwable
	{
		//Create a Project via API
		ProjectLibrary pLib = new ProjectLibrary("Chethan", "Aorus "+jLib.getRandomNumber(), "Created", 25);
		
		Response res = given()
					   .contentType(ContentType.JSON)
					   .body(pLib)
					   .when()
					   .post(Endpoints.addProject);
		
		res.then().log().all();
		
		//Store the expected data
		String expData = restLib.getJsonData(res, "projectName");
		System.out.println(expData);
		
		//Verify in database
		String query = "select * from project";
		String actData = dBLib.executeQueryAndGetData(query, 4, expData);
		
		//Validate
		Assert.assertEquals(actData, expData);
		System.out.println("Successfully Validated");
		
		
	}

}
