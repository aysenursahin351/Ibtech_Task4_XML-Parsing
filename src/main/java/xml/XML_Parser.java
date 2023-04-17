package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import command.CommandExecutor;
import model.Customer;
import xbag.XBag;
import xbag.XBagKey;

import org.xml.sax.InputSource;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class XML_Parser {

	/*public XBag parseCustomerFromForm(String xmlData) {
	    XBag xbag = null;
	    try {
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document document = dBuilder.parse(new InputSource(new StringReader(xmlData)));
	        document.getDocumentElement().normalize();
	        Node customerNode = document.getElementsByTagName("Customer").item(0);
	        if (customerNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element customerElement = (Element) customerNode;
	            int id = Integer.parseInt(customerElement.getAttribute("id"));
	            String firstName = customerElement.getAttribute("firstName");
	            String lastName = customerElement.getAttribute("lastName");
	            String email = customerElement.getAttribute("email");
	            xbag = new XBag();
	            xbag.add(XBagKey.FIRSTNAME, firstName);
	            xbag.add(XBagKey.LASTNAME, lastName);
	            xbag.add(XBagKey.EMAIL, email);
	            xbag.add(XBagKey.CUSTOMER_ID, id);
	        }
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return xbag;
	}
*/
public static void customerParser(String body) throws Exception {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(body.trim())));
		document.getDocumentElement().normalize();
				
		String commandName =  document.getDocumentElement().getElementsByTagName("commandName").item(0).getTextContent();
		System.out.println(commandName);
		
		int customerId;
		String customerID = document.getDocumentElement().getElementsByTagName("customerID").item(0).getTextContent();
		String customerName = document.getDocumentElement().getElementsByTagName("customerName").item(0).getTextContent();
		System.out.println(customerName);
		String customerSurname = document.getDocumentElement().getElementsByTagName("customerSurname").item(0).getTextContent();
		System.out.println(customerSurname);
		String customerEmail = document.getDocumentElement().getElementsByTagName("customerEmail").item(0).getTextContent();
		System.out.println(customerEmail);
		customerId=Integer.parseInt(customerID);
		//Customer customer = new Customer( customerId,  customerName,  customerSurname, customerEmail);
		XBag bag = new XBag();
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setEmail(customerEmail);
		customer.setFirstName(customerName);
		customer.setLastName(customerSurname);
		CommandExecutor command=new CommandExecutor();
		bag.add(XBagKey.CUSTOMER_ID, customer.getId());
		bag.add(XBagKey.FIRSTNAME, customer.getFirstName());
		bag.add(XBagKey.LASTNAME, customer.getFirstName());
		bag.add(XBagKey.EMAIL, customer.getEmail());
		
		 command.executeBag(commandName, bag);

	}
    
}
