package com.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hash
 *
 */
public class MysqlUtil {
	private static Connection conn;
	private static Statement st;

	public MysqlUtil() {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
		} catch (Exception ex) {
			System.out.println("no driver");
			
		}

		try {
			Settings settings = new Settings();
			StringBuilder connString = new StringBuilder();
/*			connString.append("jdbc:mysql://");
			connString.append("localhost");
			connString.append("/");
			connString.append("hashcv");
			connString.append("?user=");
			connString.append("root");
			connString.append("&password=");
			connString.append("");*/
			
			
			
			connString.append("jdbc:mysql://");
			connString.append(settings.getDbhost());
			connString.append("/");
			connString.append(settings.getDbname());
			connString.append("?user=");
			connString.append(settings.getDbuser());
			connString.append("&password=");
			connString.append(settings.getDbpassword());
			
			conn = DriverManager
					.getConnection(connString.toString());
			st = getConnection().createStatement();

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static Statement getStatement() {
		return st;
	}
	
	/**
	 * @param sql
	 */
	public static void queryNoRs(String sql) {
		try {
			st.executeUpdate(sql);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	/**
	 * @param sql
	 * @return
	 */
	public static ResultSet queryRs(String sql) {
		try {
			return st.executeQuery(sql);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return null;
		}
		
		
	}
}