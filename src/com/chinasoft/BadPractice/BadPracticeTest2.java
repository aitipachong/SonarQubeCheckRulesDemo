package com.chinasoft.BadPractice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.D;



public class BadPracticeTest2
{
	/**
	 * 在HttpSession对象中保存非连续的对象
	 * Bad practice - Store of non serializable object into HttpSession
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void bugDemo18(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.setAttribute("D", new D());
	}
	
	/**
	 * 使用了java预留关键字
	 * Bad practice - Use of identifier that is a keyword in later versions of Java
	 */
	public void bugDemo19()
	{
		String byte = "abcd";
		System.out.println(byte);
	}
}
