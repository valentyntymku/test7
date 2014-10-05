package com.academy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import sun.misc.Resource;

/**
 * @author hash
 *
 */
public class IOTxt implements InputOutput {
	private static Settings settings = new Settings();
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#read()
	 */
	public void read() throws IOException {
		
		String str0 = this.getClass().getClassLoader()
						.getResource(settings.getReadTxtCusts()).getFile();
		str0 = str0.replace("%20", " ");
		File dest1 = new File(str0);
		
/*String str0 = this.getClass().getClassLoader()
.getResource("\\").getFile()
+ "..\\..\\"+settings.getReadTxtCusts();
str0 = str0.replace("%20", " ");
File dest1 = new File(str0);*/

		//File dest1 = new File(this.getClass().getClassLoader()
		//		.getResource("\\").getFile()
		//		+ "..\\..\\"+settings.getReadTxtCusts());
		
/*		File dest1 = new File(this.getClass().getClassLoader()
				.getResource("/").getFile()
				+ "customers.txt");*/
		//File dest1 = new File(this.getClass().getClassLoader().getResource("/").getFile()+ "..\\..\\"+"customers.txt");
		

		BufferedReader custReader = new BufferedReader(new FileReader(dest1));
		//BufferedReader custReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/customers.txt")));
		String str;
		while ((str = custReader.readLine()) != null) {
			Storage.getCusts().add(Customer.parseCust(str));
		}

		str0 = this.getClass().getClassLoader()
				.getResource(settings.getReadTxtAccs()).getFile();
		
		str0 = str0.replace("%20", " ");
		File dest2 = new File(str0);
		
		BufferedReader accReader = new BufferedReader(new FileReader(dest2));

		while ((str = accReader.readLine()) != null) {
			Storage.getAccs().add(Account.parseAcc(str));
		}

		custReader.close();
		accReader.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#write()
	 */
	public void write() throws IOException {
		BufferedWriter cw = new BufferedWriter(new FileWriter(settings.getWriteTxtCusts()));
		BufferedWriter ca = new BufferedWriter(new FileWriter(settings.getWriteTxtAccs()));
		for (Customer cust : Storage.getCusts()) {
			cw.write(cust.toString());
			cw.newLine();
		}

		for (Account acc : Storage.getAccs()) {
			ca.write(acc.toString());
			cw.newLine();
		}

		cw.close();
		ca.close();

	}

}
