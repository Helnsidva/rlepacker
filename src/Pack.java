package packrle;

public class Pack {
	
	public static String packer(String argData) {
		
		/*nonrepeating characters - @NSymbols if N < 10
		 						 	!N$Symbols else 
		  repeating chatacters - NSymbols if N < 10
		  						 #N$Symbols else */
		
		StringBuilder outData = new StringBuilder(); //output string
		int counterIter = 0; 
		int counterRep = 1; //number of repeating characters
		int counterStr = 0; //number of nonrepeating characters
		StringBuilder unRep = new StringBuilder();
		
		for(counterIter = 0; counterIter < argData.length() - 1; counterIter++) {
			
			if(argData.charAt(counterIter) == argData.charAt(counterIter + 1)) {
				
				counterRep++;
				//saving string with nonrepeating characters
				if (counterStr != 0) {
					
					if (counterStr > 9) 
						outData.append("!" + counterStr + "$");
					else 
						outData.append("@" + counterStr);
					outData.append(unRep);
					counterStr = 0;
					unRep.delete(0, outData.length());
					
				}
				
			}
			else {
				
				//saving string with repeating characters
				if (counterRep != 1) {
					
					if (counterRep > 9) 
						outData.append("#" + counterRep + "$");
					else 
						outData.append(counterRep);
					outData.append(argData.charAt(counterIter));
					counterRep = 1;
					
				}
				else {
					
					counterStr++;
					unRep.append(argData.charAt(counterIter));
					
				}
				
			}
			
		}
		
		//check the last symbol
		//saving string with repeating characters
		if (counterRep != 1) {
			
			if (counterRep > 9) 
				outData.append("#" + counterRep + "$");
			else 
				outData.append(counterRep);
			outData.append(argData.charAt(counterIter));
			
		}
		//saving string with nonrepeating characters
		else {
			
			counterStr++;
			unRep.append(argData.charAt(counterIter));
			if (counterStr > 9) 
				outData.append("!" + counterStr + "$");
			else 
				outData.append("@" + counterStr);
			outData.append(unRep);
			
		}
		
		return outData.toString();
		
	}

}
