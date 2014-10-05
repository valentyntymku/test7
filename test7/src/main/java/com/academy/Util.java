package com.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author hash
 *
 */
public class Util {

	public static final String DELIM = "|";
	public static final String READDELIM = "\\|";

	/**
	 * @return
	 */
	public static long generateID() {
		Random rand = new Random();
		return Math.abs(rand.nextLong());
	}
}
