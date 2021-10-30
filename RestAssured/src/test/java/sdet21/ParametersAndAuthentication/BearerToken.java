package sdet21.ParametersAndAuthentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken 
{
	@Test
	public void bearerToken()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "Rest-SDET21-Bearer");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().all();
	}

}
