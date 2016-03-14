package contactManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utility.ReadWriteTextFile;


public class ContactImpl implements Contact{

	// instance variables
	private int id;
	private String name;
	private String notes;
	
	/**
	 *  Constructor
	 *  
	 *  @argument
	 *  	int id : Unique id of contact
	 *  	String name: Name of the Contact
	 *  	String notes: Name of the note
	 */
	public ContactImpl(int id, String name, String notes){
		this.id = id;
		this.name = name;
		this.notes = notes;
	}
	
	/**
	 * Constructor
	 * 
	 * @argument 
	 * 		int id : Unique id of contact
	 *  	String name: Name of the Contact
	 */
	public ContactImpl(int id, String name){
		this.id = id;
		this.name = name;
		this.notes = "";
	}
	
	/**
	* Returns the ID of the contact.
	*
	* @return the ID of the contact.
	*/
	public int getId(){
		return this.id;
	}
	/**
	* Returns the name of the contact.
	*
	* @return the name of the contact.
	*/
	public String getName(){
		return this.name;
	}
	/**
	* Returns our notes about the contact, if any.
	*
	* If we have not written anything about the contact, the empty
	* string is returned.
	*
	* @return a string with notes about the contact, maybe empty.
	*/
	public String getNotes(){
		return this.notes;
	}
	/**
	* Add notes about the contact.
	*
	* @param note the notes to be added
	*/
	public void addNotes(String note){
		this.notes = note;
	}
	
	public static Map<Integer, Contact> buildContactList(String fName){
		Map<Integer, Contact> contacts = new HashMap<Integer, Contact>();
		ReadWriteTextFile rwtf = new ReadWriteTextFile(fName);
		List<String> lines = rwtf.read();
	    for(String t : lines){
	    	t = t.trim();
	    	
	    	if (!(t.startsWith("#") || t.isEmpty())){
	    		System.out.println(t);
	    		String[] tempLineContent = t.split(",");
		    	if(tempLineContent[0].toUpperCase().startsWith("CONTACT") && (tempLineContent.length == 4 || tempLineContent.length ==3)){
		    		try{
		    			if(tempLineContent.length == 4){
		    				System.out.println(Integer.parseInt(tempLineContent[1].trim()) + tempLineContent[2].trim() + tempLineContent[3].trim());
		    				Contact c = new ContactImpl(Integer.parseInt(tempLineContent[1].trim()), tempLineContent[2].trim(), tempLineContent[3].trim());
		    				contacts.put(Integer.parseInt(tempLineContent[1].trim()), c);
		    			}
		    			else if(tempLineContent.length == 3){
		    				Contact c = new ContactImpl(Integer.parseInt(tempLineContent[1].trim()), tempLineContent[2].trim());
		    				contacts.put(Integer.parseInt(tempLineContent[1].trim()), c);
		    			}
		    			else{
		    				continue;
		    			}
		    		}
		    		catch(NumberFormatException e){
		    			continue;
		    		}
		    	}
		    	else{
		    		continue;
		    	}
		    }
		    //text.write(lines);
	    }
		return contacts;
	}
	
}
