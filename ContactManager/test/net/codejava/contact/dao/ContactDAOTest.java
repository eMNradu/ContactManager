package net.codejava.contact.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	//the ContactDAOimpl requires a data source object
	//so we define a data source object to specify the collection information for the relational database
	private DriverManagerDataSource dataSource;
	private String driverClassName ="com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql://localhost:3306/contactdb";
	private String userpass ="root";
	private ContactDAOImpl dao;
	
	//dataSource is reusable so it is better to have it initialize before each class is executed
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
	    dataSource.setUrl(url);
	    dataSource.setUsername(userpass);
	    dataSource.setPassword(userpass);	    
	    dao = new ContactDAOImpl(dataSource);
	}
/*		
	@Test
	void testSave() {
    Contact contact = new Contact("Sylvester Scorillo", "dek.whip@nospa.com", "Ego, DA", "000 909 000");
    int result = dao.save(contact);
    
    assertTrue(result > 0);
    
	} 

	@Test
	void testUpdate() {
		Contact contact = new Contact(1, "Marcus Aurelius", "marcus.aurelius@romeemp.com", "Rome, VIA", "777 7232 3232");
		 int result = dao.update(contact);
		
		 assertTrue(result > 0);
	} */

	@Test
	void testGet() {
		Integer id = 5;		
		Contact contact = dao.get(id);
		if(contact != null) {
			System.out.println(contact.toString());
		}
		assertNotNull(contact);
		
	}
  
	@Test
	void testDelete() {
		
		Integer id = 5;
		int result = 0;
		Contact contact = dao.get(id);
		if(contact != null) {
			System.out.println(contact.toString());
			 result = dao.delete(id);
		}
		
		assertTrue(result > 0);
	} 
/*
	@Test
	void testList() {
		fail("Not yet implemented");
	}
	*/

}
