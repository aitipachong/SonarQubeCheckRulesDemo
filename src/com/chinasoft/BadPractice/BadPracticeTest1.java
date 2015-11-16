package com.chinasoft.BadPractice;

import com.chinasoft.C;
import com.chinasoft.D;

public class BadPracticeTest1
{
	/**
	 * 比较字符串对象使用了==或!=
	 * Bad practice - Comparison of String objects using == or !=
	 */
	public void bugDemo16()
	{
		C c = new C();
		c.MySqlConnectinString = "abc";
		D d = new D();
		d.OracleConnectionString= "abc";
		if(c.MySqlConnectinString == d.OracleConnectionString)
		{
			System.out.println("equal");
		}
	}
	
	
	public void bugDemo17()
	{
		boolean result = parametersEquals("abc", "abcd");
	}
	
	private boolean parametersEquals(String a, String b)
	{
		if(a == b) 
			return true;
		else
			return false;
	}
}
