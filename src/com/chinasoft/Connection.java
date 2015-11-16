package com.chinasoft;

public class Connection
{
	private String strConnection = null;
	
	private boolean isConnect = false;
	
	public boolean isConnect()
	{
		return isConnect;
	}

	public void setConnect(boolean isConnect)
	{
		this.isConnect = isConnect;
	}

	public Connection()
	{
		
	}
	
	public boolean open(String dbConnectionString)
	{
		strConnection = dbConnectionString;
		System.out.println(dbConnectionString);
		return true;
	}
	
	public void close()
	{
		this.strConnection = null;
	}
}
