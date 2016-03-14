package unitTests;

import  contactManager.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

/**
 * JUnit test for FutureMeetingImpl
 * 
 * @Author ttadde01
 *
 */
public class JUnitTestFutureMeeting {
    /**
     * An Array of FutureMeeting.
     */
    private FutureMeetingImpl[] futureMeeting = new FutureMeetingImpl[4];
    
    /**
     * An Array of id.
     */
    private int[] id = {1,2};
    
    /**
     * An Array of String used to store date.
     */
    private Calendar[] date = new Calendar[4];
	
	/**
     * An Array of String used to store notes.
     */
    private String[] notes = {"Past meeting notes 1", "Past meeting notes 2"} ;
    
    /**
     * FutureMeeting's list of contacts.
     */
    private Set<Contact> contactList;
    
    /**
     * Needed initialisations before each test.
     * 
     * @throws Exception 
     */
    @Before
    public void before() {
        // Initialise date
    	for(int i = 0 ; i < date.length; i++){
        	date[i] = new GregorianCalendar(2015, 03, 22 -1, 9, 30, 00);
    	}
        
        // Initilise contacts
        contactList = new HashSet<Contact>();
        contactList.add(new ContactImpl(0, "First contact", notes[0]));
        contactList.add(new ContactImpl(1, "Second contact", notes[1]));

        // Initialise meeting
        futureMeeting[0] = new FutureMeetingImpl(id[0], date[0], contactList, notes[0]);
        futureMeeting[1] = new FutureMeetingImpl(id[1], date[1], contactList);
    }
    
    /**
     * Test getId of FutureMeeting class implementation.
     */
    @Test
    public void testGetId() {
        int returndId = futureMeeting[0].getId();
        System.out.println("return id = " + returndId);
        assertEquals(id[0], returndId);
    }

    /**
     * Test getContacts of FutureMeeting class implementation.
     */
    @Test
    public void testGetContacts() {
        Set<Contact> returnedContactList = futureMeeting[0].getContacts();
        assertEquals(returnedContactList, contactList);
    }
    
    /**
     * Test getDate of FutureMeeting class implementation.
     */
    @Test
    public void testGetDate() {
        Calendar returnedDate = futureMeeting[0].getDate();
        assertEquals(date[0], returnedDate);
    }
    
    /**
     * Test setDate of FutureMeeting class implementation.
     */
    @Test
    public void testSetDate() {
    	Calendar date1 = new GregorianCalendar(2008, 01, 01, 23, 59, 59);
    	futureMeeting[0].setDate(date1);
        Calendar returnedDate = futureMeeting[0].getDate();
        assertEquals(date1, returnedDate);
    }

   /**
     * Test getNotes of FutureMeeting class implementation.
     */
    @Test
    public void testGetNotes() {
        String returnedNotes = futureMeeting[0].getNotes();
        assertEquals(notes[0], returnedNotes);
    }
    
    /**
     * Test setNotes of FutureMeeting class implementation.
     */
    @Test
    public void testSetNotes() {
    	futureMeeting[0].setNotes("New notes1");
        String returnedNotes = futureMeeting[0].getNotes();
        assertEquals(returnedNotes, "New notes1");
    }
    
    
    /**
     * Test FutureMeeting constractor with empty notes ie "".
     */
    @Test
    public void testFutureMeetingWithEmptyNotes() {
        String returnedNotes = futureMeeting[1].getNotes();
        assertEquals(returnedNotes, "");
    }
    
    
}
