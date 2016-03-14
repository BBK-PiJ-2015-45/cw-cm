package contactManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


public class FutureMeetingImpl implements FutureMeeting{
	
	//instance variables
	public int id;
	private Calendar date;
	private Set<Contact> contacts;
	private String notes;
	
	/**
	* Constructor
	*
	* @argument 
	*			int id 
	*			Calendar date
	*			Set<Contact> contacts
	*			String notes
	*/
	public  FutureMeetingImpl(int id, Calendar date, Set<Contact> contacts, String notes){
		this.id = id;
		this.date = date;
		this.contacts = contacts;
		this.notes = notes;
	}
	
	
	/**
	* Constructor
	*
	* @argument 
	*			int id 
	*			Calendar date
	*			Set<Contact> contacts
	*			String notes
	*/
	public  FutureMeetingImpl(int id, Calendar date, Set<Contact> contacts){
		this.id = id;
		this.date = date;
		this.contacts = contacts;
	}

	
	//Getter methods
	
	/**
	* Returns the id of the meeting.
	*
	* @return the id of the meeting.
	*/
	public int getId(){
		return this.id;
	}
	
	/**
	* Return the note of the meeting.
	*
	* @return the note of the meeting.
	*/
	public String getNotes(){
		return this.notes;
	}
	
	/**
	* Return the date of the meeting.
	*
	* @return the date of the meeting.
	*/
	public Calendar getDate(){
		return this.date;
	}
	
	/**
	* Return the details of people that attended the meeting.
	*
	* The list contains a minimum of one contact (if there were
	* just two people: the user and the contact) and may contain an
	* arbitraty number of them.
	*
	* @return the details of people that attended the meeting.
	*/
	public Set<Contact> getContacts(){
		return this.contacts;
	}
	
	
	//Setter methods

	/**
	* Sets the id of the meeting.
	*
	* @argument
	* 		int id: the id of the meeting.
	*/
	public void setId(int id ){
		this.id = id;
	}
	
	/**
	* Sets the id of the meeting.
	*
	* @argument 
	* 		String note: the note of the meeting.
	*/
	public void setNotes(String notes){
		this.notes = notes;
	}
	
	/**
	* Set the date of the meeting.
	*
	* @argument
	* 		String date: the date of the meeting in the format dd/MM/yyyy.
	*/
	public void setDate(String dateStringFromat){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	 
		try {
	 
			Date date = formatter.parse(dateStringFromat);
			this.date.setTime(date);
			System.out.println(date);
			System.out.println(formatter.format(date));
	 
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Sets the details of people that attended the meeting.
	*
	* @argument
	* 		Set<Contact> contacts: The list of people that attended the meeting. Contains a minimum of one contact (if there were
	* 				just two people: the user and the contact) and may contain an
	* 				arbitrary number of them.
	*/
	public void setContacts(Set<Contact> contacts){
		this.contacts = contacts;
	}
}

