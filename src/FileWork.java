package packrle;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWork {

	public static String fileReader(String fileName) {
		
		StringBuilder outData = new StringBuilder();
		try(FileReader reader = new FileReader(fileName)) {
			
            int c;
            while((c = reader.read())!=-1){
            	
                outData.append((char)c);
                
            } 
            
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
            
        }   
		return outData.toString();
		
	}
	
	public static boolean fileRecorder(String fileName, String check) {
		
		 try(FileWriter writer = new FileWriter(fileName, false)) {
			 
			 String text = check;
	         writer.write(text);
	         writer.flush();
	         return true;
	         
	     }
	     catch(IOException ex){
	             
	         System.out.println(ex.getMessage());
	         return false;
	         
	     } 
		
	}
	
	public static long fileSize(String argName) {
		
		File f = new File(argName);
		return f.length();
		
	}
	
}
