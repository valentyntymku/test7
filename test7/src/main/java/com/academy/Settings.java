package com.academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hash
 *
 */
public class Settings {
	private String dbhost;
	private String dbuser;
	private String dbpassword;
	private String dbname;
	private String inputXml;
	private String outputXml;
	private String writeSqlTableCusts;
	private String writeSqlTableAccs;
	private String readSqlTableCusts;
	private String readSqlTableAccs;
	private String writeTxtCusts;
	private String writeTxtAccs;
	private String readTxtCusts;
	private String readTxtAccs;

	public Settings() {
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
			String str0 = this.getClass().getClassLoader().getResource("config.properties").getFile();
			str0 = str0.replace("%20", " ");
			File dest1 = new File(str0);
			File config = new File(str0);
			//File config = new File(this.getClass().getClassLoader().getResource("\\").getFile()+"..\\..\\config.properties");
			input = new FileInputStream(config);
			prop.load(input);
	 
			dbhost = prop.getProperty("dbhost");
			dbuser = prop.getProperty("dbuser");
			dbpassword = prop.getProperty("dbpassword");
			dbname = prop.getProperty("dbname");
			inputXml = prop.getProperty("inputXml");
			outputXml = prop.getProperty("outputXml");
			writeSqlTableCusts = prop.getProperty("writeSqlTableCusts");
			writeSqlTableAccs = prop.getProperty("writeSqlTableAccs");
			readSqlTableCusts = prop.getProperty("readSqlTableCusts");
			readSqlTableAccs = prop.getProperty("readSqlTableAccs");
			writeTxtCusts = prop.getProperty("writeTxtCusts");
			writeTxtAccs = prop.getProperty("writeTxtAccs");
			readTxtCusts = prop.getProperty("readTxtCusts");
			readTxtAccs = prop.getProperty("readTxtAccs");
			


	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
	}

	/**
	 * @return the dbhost
	 */
	public String getDbhost() {
		return dbhost;
	}

	/**
	 * @return the dbuser
	 */
	public String getDbuser() {
		return dbuser;
	}

	/**
	 * @return the dbpassword
	 */
	public String getDbpassword() {
		return dbpassword;
	}

	/**
	 * @return the dbname
	 */
	public String getDbname() {
		return dbname;
	}

	/**
	 * @return the inputXml
	 */
	public String getInputXml() {
		return inputXml;
	}

	/**
	 * @return the outputXml
	 */
	public String getOutputXml() {
		return outputXml;
	}

	/**
	 * @return the writeSqlTableCusts
	 */
	public String getWriteSqlTableCusts() {
		return writeSqlTableCusts;
	}

	/**
	 * @return the writeSqlTableAccs
	 */
	public String getWriteSqlTableAccs() {
		return writeSqlTableAccs;
	}

	/**
	 * @return the readSqlTableCusts
	 */
	public String getReadSqlTableCusts() {
		return readSqlTableCusts;
	}

	/**
	 * @return the readSqlTableAccs
	 */
	public String getReadSqlTableAccs() {
		return readSqlTableAccs;
	}

	/**
	 * @return the writeTxtCusts
	 */
	public String getWriteTxtCusts() {
		return writeTxtCusts;
	}

	/**
	 * @return the writeTxtAccs
	 */
	public String getWriteTxtAccs() {
		return writeTxtAccs;
	}

	/**
	 * @return the readTxtCusts
	 */
	public String getReadTxtCusts() {
		return readTxtCusts;
	}

	/**
	 * @return the readTxtAccs
	 */
	public String getReadTxtAccs() {
		return readTxtAccs;
	}

}
