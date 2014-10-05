package com.academy;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author hash
 *
 */
@XmlType(propOrder = { "firstName", "lastName", "ipn", "address", "phone",
		"email" }, name = "customer")
@XmlRootElement
public class Customer {

	private String firstName;
	private String lastName;
	private Long ipn;
	private String address;
	private String phone;
	private String email;

	public Customer() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName);
		sb.append(Util.DELIM);
		sb.append(lastName);
		sb.append(Util.DELIM);
		sb.append(ipn);
		sb.append(Util.DELIM);
		sb.append(address);
		sb.append(Util.DELIM);
		sb.append(phone);
		sb.append(Util.DELIM);
		sb.append(email);
		return sb.toString();
	}
	
	/**
	 * @param string of Customer
	 * @return New Customer
	 * arr[0] - firstName
	 * arr[1] - lastName
	 * arr[2] - ipn
	 * arr[3] - address
	 * arr[4] - phone
	 * arr[5] - email
	 */
	public static Customer parseCust(String str) {
		String[] arr = str.split(Util.READDELIM);
		return new Customer(arr[0], arr[1], Long.parseLong(arr[2]), arr[3], arr[4], arr[5]);
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param ipn
	 * @param address
	 * @param phone
	 * @param email
	 */
	public Customer(String firstName, String lastName, Long ipn,
			String address, String phone, String email) {

		if (Validate.isValidName(firstName))
			this.firstName = firstName;
		if (Validate.isValidName(lastName))
			this.lastName = lastName;
		if (Validate.isValidIpn(ipn))
			this.ipn = ipn;
		if (Validate.isValidAddress(address))
			this.address = address;
		if (Validate.isValidPhone(phone))
			this.phone = phone;
		if (Validate.isValidEmail(email))
			this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (Validate.isValidName(firstName))
			this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (Validate.isValidName(lastName))
			this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (Validate.isValidEmail(email))
			this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (Validate.isValidAddress(address))
			this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (Validate.isValidPhone(phone))
			this.phone = phone;
	}

	public Long getIpn() {
		return ipn;
	}

	public void setIpn(Long ipn) {
		this.ipn = ipn;
	}

}
