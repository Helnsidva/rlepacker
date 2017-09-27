package packrle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Repack {

	public static String repacker(String argData) {

		/*nonrepeating characters - @NSymbols if N < 10
									!N$Symbols else 
		  repeating chatacters - NSymbols if N < 10
		 						 #N$Symbols else */
		
		Pattern sample = Pattern.compile("[!]?[@]?[#]?[0-9]+[$]?");
		Matcher subString = sample.matcher(argData);
		StringBuilder outData = new StringBuilder(); //output string
		int searchInd = 0; //the index from which substrings are searched for
		
		while(subString.find(searchInd)) {
			
			String recString = new String();
			recString = subString.group();
			int stringBeginning = 0;
			
			String argNumb = new String(); /*number of repetitions or
										     string length*/
			
			if(recString.charAt(0) == '@') {
				
				argNumb = Character.toString(recString.charAt(1));
				stringBeginning = searchInd + 2;
				
			}
			else if (recString.charAt(0) == '!' || recString.charAt(0) == '#'){
				
				argNumb = recString;
				argNumb = argNumb.replaceAll("\\D+",""); /*delete all characters
														   except digits*/
				stringBeginning = searchInd + recString.length();
				
			}
			else {
				
				argNumb = Character.toString(recString.charAt(0));
				stringBeginning = searchInd + 1;
				
			}
			
			//nonrepeating characters
			if(recString.charAt(0) == '!' || recString.charAt(0) == '@') {
				
				//get string with the length
				StringBuilder argString = new StringBuilder();
				argString.append(argData.substring(stringBeginning, 
						stringBeginning + Integer.parseInt(argNumb)));
				searchInd = stringBeginning + Integer.parseInt(argNumb);
				outData.append(argString);
				
			}
			//repeating characters
			else {
				
				//get current symbol
				char argSym = argData.charAt(stringBeginning);
				for (int i = 0; i < Integer.parseInt(argNumb); i++) {
					
					outData.append(argSym);
					
				}
				searchInd = stringBeginning + 1;
				
			}
			
		}
		
		return outData.toString();
	    
	}
	
}
