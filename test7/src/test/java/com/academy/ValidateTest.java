/**
 * 
 */
package com.academy;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

//import com.sun.org.glassfish.gmbal.ParameterNames;

/**
 * @author hash
 *
 */
public class ValidateTest {

	
	//@ParameterNames
	/**
	 * Test method for {@link test3.Validate#isValidName(java.lang.String)}.
	 */
	//@Test(expected = NullPointerException.class)
	@Test
	public final void testIsValidName() {
		assertEquals(true, Validate.isValidName("James"));
		assertEquals(false, Validate.isValidName("james"));
	}

	/**
	 * Test method for {@link test3.Validate#isValidEmail(java.lang.String)}.
	 */
	@Test
	public final void testIsValidEmail() {
		assertEquals(true, Validate.isValidEmail("hash.cv@gmail.com"));
	}

}
