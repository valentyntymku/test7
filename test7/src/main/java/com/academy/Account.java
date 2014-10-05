package com.academy;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author hash
 *
 */
@XmlType(propOrder = { "number", "name", "currency", "debit", "creditLimit",
		"customer" }, name = "account")
@XmlRootElement
public class Account {

	private Long number;
	private String name;
	private Currencies currency;
	private double debit;
	private double creditLimit;
	private Customer customer;

	public Account() {
	}

	/**
	 * @param number
	 * @param name
	 * @param currency
	 * @param debit
	 * @param creditLimit
	 * @param customer
	 */
	public Account(Long number, String name, Currencies currency, double debit,
			double creditLimit, Customer customer) {

		this.number = number;
		this.name = name;
		this.currency = currency;
		this.debit = debit;
		this.creditLimit = creditLimit;
		this.customer = customer;
		// this.customerIpn = customer.getIpn();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(number);
		sb.append(Util.DELIM);
		sb.append(name);
		sb.append(Util.DELIM);
		sb.append(currency.toString());
		sb.append(Util.DELIM);
		sb.append(debit);
		sb.append(Util.DELIM);
		sb.append(creditLimit);
		sb.append(Util.DELIM);
		sb.append(customer.getIpn());
		return sb.toString();

	}

	/**
	 * @param String of Account
	 * @return New Account, parsed from string
	 * arr[0] - number
	 * arr[1] - name
	 * arr[2] - currency
	 * arr[3] - debit
	 * arr[4] - creditLimit
	 * arr[5] - Customer
	 */
	public static Account parseAcc(String str) {
		String[] arr = str.split(Util.READDELIM);

		return new Account(Long.parseLong(arr[0]), arr[1],
				Currencies.valueOf(arr[2]), Double.parseDouble(arr[3]),
				Double.parseDouble(arr[4]), Storage.findCustomer(Long
						.parseLong(arr[5])));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Currencies getCurrency() {
		return currency;
	}

	public void setCurrency(Currencies currency) {
		this.currency = currency;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
}
