package com.academy;

import java.sql.Connection;

public class ConnectionFactory {
	public static Connection getConnection(){
		MysqlUtil mysql = new MysqlUtil();
		return mysql.getConnection();
		
	}
	


}
