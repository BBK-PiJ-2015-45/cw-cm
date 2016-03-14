package contactManager;

import java.util.*;
import java.text.*;

public class PastMeetingImpl implements PastMeeting{
	
	//instance variables
	public int id;
	private Calendar date;
	private Set<Contact> contacts;
	private String notes;
	
	/**
	* Constructor
	*
	* @Parameter:
	* 	int id: the id of the meeting.
	* 	Calander date: date of the meeting 
	* 	Set<Contact> contacts: contact list of the meeting
	* 	String notes: note of the meeting
	*/
	public  PastMeetingImpl(int id, Calendar date, Set<Contact> contacts, String notes){
		this.id = id;
		this.date = date;
		this.contacts = contacts;
		this.notes = notes;
	}
	
	
	/**
	* Constructor
	*
	* @Parameter:
	* 	int id: the id of the meeting.
	* 	Calander date: date of the meeting 
	* 	Set<Contact> contacts: contact list of the meeting
	*
	*/
	public  PastMeetingImpl(int id, Calendar date, Set<Contact> contacts){
		this.id = id;
		this.date = date;
		this.contacts = contacts;
		this.notes = "";
	}
	
	/**
	* Constructor
	*
	* @Parameter:
	* 	int id: the id of the meeting.
	* 	String dateString: string representation of date and time of the meeting 
	* 	Set<Contact> contacts: contact list of the meeting
	* 	String notes: note of the meeting
	*/
	public  PastMeetingImpl(int id, String dateString, Set<Contact> contacts, String notes){
		this.id = id;
		this.date = PastMeetingImpl.meetingStringToCalendar(dateString);
		this.contacts = contacts;
		this.notes = notes;
	}
		
	/**
	* Constructor
	*
	* @Parameter:
	* 	int id: the id of the meeting.
	* 	String dateString: string representation of date and time of the meeting 
	* 	Set<Contact> contacts: contact list of the meeting
	* 	String notes: note of the meeting
	*/
	public  PastMeetingImpl(int id, String dateString, Set<Contact> contacts){
		this.id = id;
		this.date = PastMeetingImpl.meetingStringToCalendar(dateString);
		this.contacts = contacts;
		this.notes = "";
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
	* Set the date of the meeting.
	*
	* @return the date of the meeting.
	*/
	public void setDate(Calendar date){
		this.date = date;
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
	
	public static Calendar meetingStringToCalendar(String stringDate){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		 
		try {
		 
			Date date = formatter.parse(stringDate);
			cal.setTime(date);
			System.out.println(formatter.format(cal.getTime()));		 
		} catch (ParseException e) {
			return null;
		}
		return cal;
	}
	
}

