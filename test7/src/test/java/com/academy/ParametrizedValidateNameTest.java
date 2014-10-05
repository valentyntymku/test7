package com.academy;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class ParametrizedValidateNameTest extends Assert {
	
	 @Parameterized.Parameters
	   public static Collection data() {
	      return Arrays.asList(new Object[][] {
	         { "James", true },
	         { "", false },
	         { " ", false },
	         { "sdrghet", false },
	         { "Hash", true }

	      });
	   }
	  
	public String inputString;
	public boolean expectedResult;
	
	public ParametrizedValidateNameTest(String inputString, boolean expectedResult){
	      this.inputString = inputString;
	      this.expectedResult = expectedResult;
	}
 

  @Test
  public void ValidateTest() {
    assertEquals(expectedResult, Validate.isValidName(inputString));
  }


}