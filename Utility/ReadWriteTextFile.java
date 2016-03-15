package Utility;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
public class ReadWriteTextFile {
  
  public static void main(String... aArgs) throws IOException{
	String fName = "C:\\Users\\Baller\\Documents\\java_projects\\CW4\\src\\test.txt";
    ReadWriteTextFile text = new ReadWriteTextFile(fName);
    
    //
    List<String> lines = text.read();
    for(String t : lines){
    	System.out.println(t);
    }
    text.write(lines);
  }

  //final static String FILE_NAME = "C:\\Users\\Baller\\Documents\\java_projects\\CW4\\src\\test.txt";
  //final static String OUTPUT_FILE_NAME = "C:\\Users\\Baller\\Documents\\java_projects\\CW4\\src\\output_test.txt";
  
  private String fileName;
  
  
  public ReadWriteTextFile(String fileName){
	  this.fileName = fileName;
  }
  
  
  

  /**
   * Description: Method that reads the content of a file given as an argument.
   * 
   * @Argument :
   * 				fileName : String representation of the file's full path.
   * 
   * @Return : file content as a List<String> object.
  */  
  public List<String> read(){
	List<String> fileContent= null;
	try{
		Path path = Paths.get(this.fileName);
	    return Files.readAllLines(path, StandardCharsets.UTF_8);
	}
	catch(IOException e){
		System.out.println("Error reading from file fileName. Please check that the file is readeable!\nExiting now!");
		System.exit(1);
	}
	finally{
		
	}
	return fileContent;
  }
  
  /**
   * Description: Method that writes the content of List<String> to a file given as an argument.
   * @param aLines : an object of List<String>
   * @param aFileName : String representation of the file to write to.
   * @throws IOException
   */
  public void write(List<String> aLines){
	try{
		Path path = Paths.get(this.fileName);
	    Files.write(path, aLines, StandardCharsets.UTF_8);
	}
	catch(IOException e){
		System.out.println("Error writing to file fileName. Please check that the file is writable!\nExiting now!");
		System.exit(1);
	}
	finally{
		
	}
    
  }
} 
