package com.chinasoft.Correctness;

public class CorrectnessTest2
{
	/**
	 * 格式字符串定义错误
	 * Correctness - No previous argument for format string
	 */
	public void bugDemo3()
	{
		String str = null;
		str = String.format("Hi,%<s %s", "Hello", "Correctness");
		System.out.println(str);
	}
	
	/**
	 * String的format操作缺少必要的参数
	 * Correctness - Format string references missing argument
	 */
	public void bugDemo4()
	{
		String str = null;
		str = String.format("Hi,%s %s", "Hello");
		System.out.println(str);
	}
	
	/**
	 * 错误使用参数类型来格式化字符串
	 * Correctness - Format string placeholder incompatible with passed argument
	 */
	public void bugDemo5()
	{
		String str = null;
		str = String.format("Hi,%d\n", "Hello");
		System.out.println(str);
	}
	
	/**
	 * 格式字符串参数的数量与占位符数量不一致
	 * Correctness - Number of format-string arguments does not correspond to number of placeholders
	 */
	public void bugDemo6()
	{
		String str = null;
		str = String.format("Hi,Hell%d Co%s%sectness", 0,"r");
		System.out.println(str);
	}
}
