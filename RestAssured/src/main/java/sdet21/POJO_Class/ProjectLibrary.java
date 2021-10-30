package sdet21.POJO_Class;

public class ProjectLibrary 
{
	//create global variables
	String createdBy;
	String projectName;
	String status;
	int teamSize;
		
	//initialise all the variables using a constructor
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) 
	{
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	//use getter and setter to access the variables
	public String getCreatedBy() 
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}

	public String getProjectName() 
	{
		return projectName;
	}

	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public int getTeamSize() 
	{
		return teamSize;
	}

	public void setTeamSize(int teamSize) 
	{
		this.teamSize = teamSize;
	}

}