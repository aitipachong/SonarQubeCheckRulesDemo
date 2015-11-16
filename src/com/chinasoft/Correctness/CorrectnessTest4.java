package com.chinasoft.Correctness;

import com.chinasoft.B;

public class CorrectnessTest4
{
	/**
	 * 子类中定义了和父类中同名的字段。在调用时会出错
	 * Correctness - Class defines field that masks a superclass field
	 */
	public void bugDemo14()
	{
		B b = new B();
		b.setConnect(true);
		b.setConnectionString("abcdefg");
	}

	/**
	 * 在方法中定义的局部变量和类变量或者父类变量同名，从而引起字段混淆
	 * Correctness - Method defines a variable that obscures a field
	 */
	private String b = "abcd"; 
	public void bugDemo15()
	{
		int b = 0;
		System.out.println(b);
	}
}
