package com.academy;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author hash
 *
 */
@XmlRootElement(name = "Storage")
public class Storage {
	private static Storage instance;
	@XmlElement(name = "Customer")
	public static List<Customer> custs = new ArrayList<Customer>();
	@XmlElement(name = "Account")
	public static List<Account> accs = new ArrayList<Account>();

	/**
	 * @return the custs
	 */
	public static List<Customer> getCusts() {
		return custs;
	}

	/**
	 * @return the accs
	 */
	public static List<Account> getAccs() {
		return accs;
	}

	private Storage() {

	}

	public static Storage getInstance() {
		if (instance == null)
			instance = new Storage();
		return instance;
	}

	/**
	 * @param ipn
	 * @return
	 */
	public static Customer findCustomer(Long ipn) {
		for (Customer cust : custs) {
			if (cust.getIpn().equals(ipn))
				return cust;

		}
		System.out.println("Not found customer with ipn " + ipn);
		return null;
	}

	public static Integer findCustomerIndex(Long ipn) {
		for (Customer cust : custs) {
			if (cust.getIpn().equals(ipn)) {
				return custs.indexOf(cust);
			}
		}
		System.out.println("Not found customer with ipn " + ipn);
		return null;
	}

	public static Integer findAccountIndex(Long number) {
		for (Account acc : accs) {
			if (acc.getNumber().equals(number))
				return (Integer) accs.indexOf(acc);
		}
		System.out.println("Not found customer with number " + number);
		return null;
	}

	public static void printAll() {

		for (Customer cust : custs) {
			System.out.println(cust.toString());
		}

		for (Account acc : accs) {
			System.out.println(acc.toString());
		}

	}

	public static void clearAll() {
		custs.clear();
		accs.clear();
	}
}
