package sdet21.ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_Authentication 
{
	@Test
	public void oauth()
	{
		//Generate the token
		Response res = given()
		.formParam("client_id", "SDET21-RMGY-REST")
		.formParam("client_secret", "b7eb7a870b1f1a620c466df164903acb")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		res.then().log().all();
		
		//Store the token
		String Token=res.jsonPath().get("access_token");
		System.out.println(Token);
		
		//Create a new request to access the token
		given()
		.auth()
		.oauth2(Token)
		.pathParam("USER_ID", "1914")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();	
		
	}

}
