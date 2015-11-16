package com.chinasoft.Correctness;

import java.util.Properties;

import org.eclipse.jdt.annotation.NonNull;

import com.chinasoft.Connection;

public class CorrectnessTest3<ParameterType, ReturnType>
{
	private Connection conn = null;
	private boolean connResult = false;
	/**
	 * 对象一直为Null（空指针引用）
	 * Correctness - Null pointer dereference
	 */
	public void bugDemo7()
	{
		connResult = conn.open("jdbc:mysql://172.16.3.46:3306/sonar?useUnicode=true&amp;characterEncoding=utf-8");
	}
	
	/**
	 * 在正常的null判断分支上，对象去除引用操作是受保护的，不被允许的，将抛出异常。
	 * Correctness - Null value is guaranteed to be dereferenced
	 */
	public void bugDemo8()
	{
		String var = "";
		int index = 2;
		if(index == -1)
		{
			var = String.class.getName();
			if(var.length() == 0)
			{
				var = null;
			}
		}
		else
		{
			var = Integer.class.getName();
			if(var.length() == 0)
			{
				var = null;
			}
		}
		
		if(var == null)
		{
			throw new NullPointerException("NULL");
		}
	}
	
	/**
	 * 调用equals的对象为null
	 * Correctness - Call to equals() with null argument
	 */
	public void bugDemo9()
	{
		String aa = null;
		if(aa.equals("abc"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}
	
	/**
	 * 可能的空指针引用
	 * Correctness - Possible null pointer dereference
	 * @throws Exception
	 */
	public void bugDemo10() throws Exception
	{
		Connection o = new Connection();
		checkInput(o, "some error message");
		doSomething(o.open("abc"));
	}
	private void checkInput(Object o, String message)
	{
		if(o == null)
		{
			throw new SomeRuntimeException(message);
		}
	}
	
	/**
	 * 方法中为null的参数没有被重新赋值
	 * Correctness - Method call passes null to a nonnull parameter
	 */
	public void bugDemo11()
	{
		String ss = null;
		sya(ss);
	}
	private void sya(String ad)
	{
		ad.getBytes();
	}
	
	/**
	 * 方法中为null的参数没有被重新赋值
	 * 
	 */
	public void calledAnywhereIDoNotCare() 
	{
	  //[...]
	  //parameter could be null but shouldn't ever be by logic
	  method(parameter); //FindBugs says the problem is here
	  //[...]
	}
	public final ReturnType method(final ParameterType parameter) 
	{
	  //this method do nothing but simply call anotherMethod()
	  return anotherMethod(parameter, false);
	}

	public final ReturnType anotherMethod(final ParameterType parameter, boolean boolParam) {
	  if (parameter == null) {
	    //just in case logic is wrong
	    throw new NullPointerException("I know it shouldn't be null by logic, but it is null!");
	  }
	  //do something very usefull
	  //[...]
	}
	
	/**
	 * 方法参数中声明为nonnull类型的参数为null
	 * Correctness - Method call passes null for nonnull parameter
	 */
	public void bugDemo12()
	{
		String ss = null;
		sya(ss);
	}	
	private void sya2(@NonNull String ad)
	{
		ad.getBytes();
	}
	
	/**
	 * 为空的对象调用close方法
	 * Correctness - close() invoked on a value that is always null
	 * @param properties
	 * @throws XXException
	 */
	private void bugDemo13(Properties properties) throws XXException 
	{
	    PersistenceManager pm = null;        

	    try {
	        pm = new PersistenceManager(distributedDatabase, "PeriodHelper: insertPeriod");

	        try {
	            pm.create(Tables.MY_TABLE);
	        } catch (ObjectAlreadyExistsException e) {
	            logger.warn("Could not create table! - "+e.getMessage(), e);
	            return;
	        }

	        pm.commit();
	        return;
	    } 
	    catch (Exception e) {
	        throw new XXException(e.getMessage(), e);
	    }
	    finally {
	        if (pm != null) 
	            pm.close();
	    }
	}
	
	

}

