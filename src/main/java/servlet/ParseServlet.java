package servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xbag.XBag;
import xml.XML_Parser;

/**
 * Servlet implementation class ParseServlet
 */
public class ParseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Calıştı");
		
		String data = request.getReader().lines().collect(Collectors.joining());
	    XML_Parser parser = new XML_Parser();

		try {
			XML_Parser.customerParser(data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Executing Failed");
		}
	}*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String customerID = request.getParameter("customerID");
	    String customerName = request.getParameter("customerName");
	    String customerSurname = request.getParameter("customerSurname");
	    String customerEmail = request.getParameter("customerEmail");
	    String commandName = request.getParameter("commandName");

	    String xmlString = "<customer>" +
	            "<customerID>" + customerID + "</customerID>" +
	            "<customerName>" + customerName + "</customerName>" +
	            "<customerSurname>" + customerSurname + "</customerSurname>" +
	            "<customerEmail>" + customerEmail + "</customerEmail>" +
	            "<commandName>" + commandName + "</commandName>" +
	            "</customer>";

	    try {
	        XML_Parser.customerParser(xmlString);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Executing Failed");
	    }
	}


}
