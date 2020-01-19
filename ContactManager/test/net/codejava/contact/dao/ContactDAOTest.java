package net.codejava.contact.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	//the ContactDAOimpl requires a data source object
	//sa we define a data source object to specify the collection information for the relational database
	private DriverManagerDataSource dataSource;
	private String driverClassName ="com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql://localhost:3306/contactdb";
	
	private ContactDAOImpl dao;
	
		
	@Test
	void testSave() {
	dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername("root");
    dataSource.setPassword("root");
    
    dao = new ContactDAOImpl(dataSource);
    Contact contact = new Contact("Hans Larsson", "steve@apple.com", "Cupertino, CA", "122344555767657");
 
    int result = dao.save(contact);
    assertTrue(result > 0);
    
	}
/*
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}
	*/

}
