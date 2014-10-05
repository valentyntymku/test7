package com.academy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IOServlet
 */
//@WebServlet("/IOServlet")
public class IOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storage = Storage.getInstance();
	private static List<Customer> custs = storage.getCusts();
	private static List<Account> accs = storage.getAccs();
	private static InputOutput input;
	private static InputOutput output;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IOServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String readMethod = request.getParameter("readMethod");
		if (readMethod != null && readMethod.length() > 0) {
			custs.clear();

			switch (readMethod) {
			case "db":
				input = new IODatabase();
				break;
			case "txt":
				input = new IOTxt();
				break;
			case "xml":
				input = new IOXml();
				break;
			default:
				input = new IODatabase();
			}
			input.read();

			request.setAttribute("customers", Storage.getCusts());
			request.setAttribute("accounts", Storage.getAccs());
			request.getRequestDispatcher("/customers.jsp").forward(
					request, response);
		}
		// ****************************************************************************
		String writeMethod = request.getParameter("writeMethod");
		if (writeMethod != null && writeMethod.length() > 0) {
			switch (writeMethod) {
			case "db":
				output = new IODatabase();
				break;
			case "txt":
				output = new IOTxt();
				break;
			case "xml":
				output = new IOXml();
				break;
			default:
				output = new IODatabase();
			}
			output.write();
			
			request.setAttribute("customers", Storage.getCusts());
			request.setAttribute("accounts", Storage.getAccs());
			request.getRequestDispatcher("/customers.jsp").forward(
					request, response);

		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
