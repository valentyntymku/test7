package com.academy;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hash
 *
 */
public class IODatabase implements InputOutput {
	Settings settings = new Settings();
	private Statement st;
	// static Logger log = Logger.getLogger(IODatabase.class.getName());
	 static Logger log = LoggerFactory.getLogger(IODatabase.class);
	// private Logger log = LoggerFactory.getLogger;
	 //private static final Logger log = LoggerFactory.getLogger(TestLogger.class);
	 

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#read()
	 */
	public void read() throws IOException {

		
		MysqlUtil mysql = new MysqlUtil();
		
		ResultSet rs = mysql.queryRs("select * from "+settings.getReadSqlTableCusts());
		
		log.info("Read customers from database");

		try {
			while (rs.next()) {
				Storage.getCusts().add(new Customer(rs.getString("firstName"), rs
						.getString("lastName"), rs.getLong("ipn"), rs
						.getString("address"), rs.getString("phone"), rs
						.getString("email")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rs = mysql.queryRs("select * from "+settings.getReadSqlTableAccs());
		try {
			while (rs.next()) {
				Storage.getAccs().add(new Account(rs.getLong("number"),
						rs.getString("name"), Currencies.valueOf(rs
								.getString("currency")), rs.getDouble("debit"),
						rs.getDouble("creditLimit"), Storage.findCustomer(rs
								.getLong("ipn"))));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#write()
	 */
	public void write() throws IOException {
		MysqlUtil mysql = new MysqlUtil();
		mysql.queryNoRs("truncate table "+settings.getWriteSqlTableCusts());
		mysql.queryNoRs("truncate table "+settings.getWriteSqlTableAccs());

		for (Customer cust : Storage.getCusts()) {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append(settings.getWriteSqlTableCusts());
			sb.append(" (firstName, lastName, ipn, address, phone, email");
			sb.append(") VALUES ('");
			sb.append(cust.getFirstName());
			sb.append("', '");
			sb.append(cust.getLastName());
			sb.append("', '");
			sb.append(cust.getIpn());
			sb.append("', '");
			sb.append(cust.getAddress());
			sb.append("', '");
			sb.append(cust.getPhone());
			sb.append("', '");
			sb.append(cust.getEmail());
			sb.append("')");
			mysql.queryNoRs(sb.toString());
		}

		for (Account acc : Storage.getAccs()) {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append(settings.getWriteSqlTableAccs());
			sb.append(" (number, name, currency, debit, creditLimit, ipn");
			sb.append(") VALUES ('");
			sb.append(acc.getNumber());
			sb.append("', '");
			sb.append(acc.getName());
			sb.append("', '");
			sb.append(acc.getCurrency().toString());
			sb.append("', '");
			sb.append(acc.getDebit());
			sb.append("', '");
			sb.append(acc.getCreditLimit());
			sb.append("', '");
			sb.append(acc.getCustomer().getIpn());
			sb.append("')");
			mysql.queryNoRs(sb.toString());
		}

	}
}
