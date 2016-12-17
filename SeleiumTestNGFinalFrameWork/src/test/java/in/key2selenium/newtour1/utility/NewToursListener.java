package in.key2selenium.newtour1.utility;

import java.io.IOException;

import org.testng.IClass;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class NewToursListener extends TestListenerAdapter implements ISuiteListener

{
	static int passCount=0;
	static int failCount=0;
	static int skipCount=0;
	
	
	@Override
	  public void onTestStart(ITestResult tr) {
		
		System.out.println(tr.getMethod()+"........started");
	   
	  }
	
	@Override
	  public void onTestSuccess(ITestResult tr) {
		
		log("Test '"+ tr.getMethod() +"' Passed");
		
	   
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  log("Test '"+tr.getName() + "' FAILED");
		  log(tr.getTestClass());
		  System.out.println("..........");
		  
		  try{
			  BrowserSelection.getScreenshot();
		  }
		  catch(IOException e)
		  {
			  e.printStackTrace();
		  }
		  failCount++;
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  
		  skipCount++;
	   
	  }
	  
	  private void log(String methodName){
		  System.out.println(methodName);
	  }

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}
	  
	  
}
