package sdet21.GenericUtilities;

import io.restassured.response.Response;

/**
 * This Class contains generic Rest Assured methods
 * @author Chethan
 *
 */	
public class RestAssuredUtilities 
{
	/**
	 * Method to return the data inside JSON path
	 * @param res
	 * @param jsonPath
	 * @return
	 */
	public String getJsonData(Response res, String jsonPath)
	{
		String value = res.jsonPath().get(jsonPath);
		return value;
	}

}
