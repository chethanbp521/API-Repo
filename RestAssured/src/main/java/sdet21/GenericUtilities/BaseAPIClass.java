package sdet21.GenericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass 
{
	public DatabaseUtility dBLib = new DatabaseUtility();
	public RestAssuredUtilities restLib = new RestAssuredUtilities();
	public JavaUtility jLib = new JavaUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		dBLib.connectToDB();
		baseURI = "http://localhost";
		port = 8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dBLib.closeDB();
	}

}
