package sdet21.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * Class containing generic methods to access the Database
 * @author Chethan
 *
 */
public class DatabaseUtility 
{
	Connection con;
	ResultSet result;
	
	/**
	 * Method to Connect to the Database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
		
	}
	
	/**
	 * Method to Close the Database
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	/**
	 * This method will execute the query and return the value
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		Boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(columnIndex);
			if(actData.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(expData + " data verified in Database");
			return expData;
		}
		else
		{
			System.out.println(expData + "data not verified in Database");
			return "";
		}
	}
	

}
