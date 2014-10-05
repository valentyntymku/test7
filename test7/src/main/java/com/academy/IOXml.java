package com.academy;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author hash
 *
 */
public class IOXml  implements InputOutput {
	private static Settings settings = new Settings();
	//private File fileOutputXML = new File(this.getClass().getClassLoader().getResource("\\").getFile()+"..\\..\\"+settings.getOutputXml());
	//private File fileInputXML = new File(this.getClass().getClassLoader().getResource("\\").getFile()+"..\\..\\"+settings.getInputXml());
	
	/* (non-Javadoc)
	 * @see com.valentyn_tymku.bank.InputOutput#read()
	 */
	public void read() throws IOException {
		try {
			File fileInputXML = new File(this.getClass().getClassLoader().getResource("\\").getFile()+"..\\..\\"+settings.getInputXml());
			Storage stor = (Storage) unmarshalIt(Storage.class, fileInputXML);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
/*		try {
			File file = new File("customers.xml");
			File file1 = new File("accounts.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			custs.add(customer);

			jaxbContext = JAXBContext.newInstance(Account.class);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Account account = (Account) jaxbUnmarshaller.unmarshal(file1);
			accs.add(account);

		} catch (JAXBException exception) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE,
					"marshallExample threw JAXBException", exception);
		}*/

	}
	/* (non-Javadoc)
	 * @see com.valentyn_tymku.bank.InputOutput#write()
	 */
	public void write() throws IOException {
		
		try {
			//File fileOutputXML = new File(this.getClass().getClassLoader().getResource("\\").getFile()+"..\\..\\"+settings.getOutputXml());
			File fileOutputXML = new File(settings.getOutputXml());
			marshalIt(Storage.getInstance(), fileOutputXML);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		/*try {
			File fileCustomers = new File("customersW.xml");
			File fileAccounts = new File("accountsW.xml");
			
			//for (Customer cust : custs) {
				JAXBContext context = JAXBContext.newInstance(Storage.class);
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						Boolean.TRUE);
				marshaller.marshal(Storage.custs, fileCustomers);
			//}

		//	for (Account acc : accs) {
			//	context = JAXBContext.newInstance(Account.class);
			//	marshaller = context.createMarshaller();
			//	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			//			Boolean.TRUE);
			//	marshaller.marshal(accs, fileAccounts);
			//}

		} catch (JAXBException exception) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE,
					"marshallExample threw JAXBException", exception);
		}
*/
	}
	
	public static void marshalIt(Object objectName, File fileOutputXML) throws JAXBException {
		 
		JAXBContext jaxbContext = JAXBContext.newInstance(objectName.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 		marshaller.marshal(objectName, fileOutputXML);
 	}
 
	public static Object unmarshalIt(Class<?> className, File inputFile) throws JAXBException {
 
		JAXBContext jaxbContext = JAXBContext.newInstance(className);
 		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
 		return unmarshaller.unmarshal(inputFile);
 	}

}
