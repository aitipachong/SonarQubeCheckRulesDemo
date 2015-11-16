package com.chinasoft;

public class B extends A
{
	public String ConnectionString = "";
	
	private boolean isConnect = false;

	public void setConnectionString(String strConn)
	{
		ConnectionString = strConn;
	}
	
	public boolean isConnect()
	{
		return isConnect;
	}

	public void setConnect(boolean isConnect)
	{
		this.isConnect = isConnect;
	}
}
