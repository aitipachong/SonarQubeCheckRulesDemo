package com.chinasoft.Correctness;

public class CorrectnessTest1
{
	/**
	 * 把一个局部变量放到方法的返回语句中。这对于方法中局部变量来说是没有意思的
	 * Correctness - Useless assignment in return statement
	 * @return
	 */
	public int bugDemo1()
	{
		int result = 10;
		return result;
	}
	
	private String strTest = "abcdefg";
	/**
	 * 无效的条件控制语句，注意if (argv.length == 1);以“;”结尾，下面的语句无论是否满足都会运行
	 * Correctness - Useless control flow to next line
	 */
	public void bugDemo2()
	{
		if(strTest.length() == 10);
			System.out.println("Hello, strTest字符串长度为：" + strTest.length());
	}
}
