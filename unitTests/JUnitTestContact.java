package unitTests;

import contactManager.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import contactManager.Contact;

/**
 * Unit test to test the ContactImpl class.
 * 
 * @Author ttadde01
 *
 */
public class JUnitTestContact {
	
	/**
	 * Array of int used to represent id of contacts
	 */
	private int[] id = {1,2};

	/**
	 * Array of Contact used for testing..
	 */
	private ContactImpl[] contact = new ContactImpl[2];
	
	/**
	 * Array of String used to represent name of contacts.
	 */
	private String[] name = {"Contact name1", "Contact name2"};
	
	/**
	 * Array of String used to represent notes on contacts.
	 */
	private String[] notes = {"Notes on contact 1",  ""};
	
	/**
	 * Initialise array of Contact.
	 */
	@Before
	public void before() {
		this.contact[0] = new ContactImpl(this.id[0],this.name[0],this.notes[0]);
		this.contact[1] = new ContactImpl(this.id[1], this.name[1]);
	}
	
	/**
	 * Test getID of Contact class implementation.
	 */
	@Test
	public void testGetId() {
		int returnedID = contact[0].getId();
		assertEquals(id[0], returnedID);
	}
	
	/**
	 * Test setID of Contact class implementation.
	 */
	@Test
	public void testSetId() {
		contact[0].setId(10);
		int returnedID = contact[0].getId();
		assertEquals(returnedID, 10);
	}
	
	/**
	 * Test getName of Contact class implementation.
	 */
	@Test
	public void testGetName() {
		String returnedName = contact[0].getName();
		assertEquals(name[0], returnedName);
	}
	
	/**
	 * Test setName of Contact class implementation.
	 */
	@Test
	public void testSetName() {
		contact[0].setName("New Name1");
		String returnedName = contact[0].getName();
		assertEquals(returnedName, "New Name1");
	}
	
	/**
	 * Test getNotes of Contact class implementation.
	 */
	@Test
	public void testGetNotes() {
		String returnedNotes = contact[0].getNotes();
		assertEquals(notes[0], returnedNotes);
	}
	
	/**
	 * Test setNotes of Contact class implementation.
	 */
	@Test
	public void testSetNotes() {
		contact[0].setNotes("New note1");
		String returnedNotes = contact[0].getNotes();
		assertEquals(returnedNotes, "New note1");
	}
	
	/**
	 * Test Contact constractor with empty notes ie "".
	 */
	@Test
	public void testContactWithEmptyNotes() {
		String foundNotes = contact[1].getNotes();
		assertEquals("", foundNotes);
	}
}