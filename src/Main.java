package packrle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void parsing(String[] args) {
		
		int actionFlag = 0;
		String inputName = new String();
		String outputName = new String();
		outputName = "output.txt";
		
		Pattern sample = Pattern.compile("^(-z|-u)$");
		Matcher subString = sample.matcher(args[0]);
		if(!subString.find()) {
			
			System.out.println("Error");
			return;
			
		}
		if(args[0].equals("-u")) 
			actionFlag = 1;
		
		if (args.length == 4) {
			
			if(!args[1].equals("-out")) {
				
				System.out.println("Error");
				return;
				
			}

			sample = Pattern.compile("^.+(.txt)$");
			subString = sample.matcher(args[2]);
			if(!subString.find()) {
				
				System.out.println("Error");
				return;
				
			}
			outputName = args[2];
			
			subString = sample.matcher(args[3]);
			if(!subString.find()) {
				
				System.out.println("Error");
				return;
				
			}
			inputName = args[3];
			
		}
		else {
			
			sample = Pattern.compile("^.+(.txt)$");
			subString = sample.matcher(args[1]);
			if(!subString.find()) {
				
				System.out.println("Error");
				return;
				
			}
			inputName = args[1];
			
		}
		String fileData = new String();
		fileData = FileWork.fileReader(inputName);
		if(actionFlag == 0) {
		
			String packData = new String();
			packData = Pack.packer(fileData);
			FileWork.fileRecorder(outputName, packData);
			
		}
		else {
			
			String repackData = new String();
			repackData = Repack.repacker(fileData);
			FileWork.fileRecorder(outputName, repackData);
			
		}
		
	}

	
	public static void main(String[] args) {
		
		//allowable command - pack-rle [-z|-u] [-out outputname.txt] inputname.txt
		if(args.length != 2 && args.length != 4) {
			System.out.println("Error");
			return;
		}
		parsing(args);
		
	}

}
