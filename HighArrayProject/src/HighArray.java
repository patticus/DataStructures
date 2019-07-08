
public class HighArray {

	private long[] longArray; // ref to array a
	private int nElems; // number of data items
	// -----------------------------------------------------------

	public HighArray(int max) // constructor
	{
		longArray = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	public boolean find(long searchKey) { // find specified value
		for (int i = 0; i < nElems; i++) {
			if (longArray[i] == searchKey) {
				return true;
			}
		}
		return false;
		
	} // end find()
	
	public void insert(long value) {
		longArray[nElems] = value;
		nElems++;
	}
	
	
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++) {
			//uses for loop to go through values and look for it
			if (value == longArray[j]) {
				break; //breaks out of for loop
			}
		}
		if (j == nElems) {
			return false; //can't find it
		} 
		else {
			for (int k = j; k < nElems; k++) {
				longArray[k] = longArray[k +1];
			}
			nElems--;
			return true;
		}
	}
	
	public void display() {
		for (int j=0; j<nElems; j++) {
			System.out.print(longArray[j] + " "); //display it
		}		
		System.out.println("");
	}	
	
	public void getMax(){ //Problem 2.1: Method to find the max value within the array and display the value
	    long maxValue = longArray[0]; 
	    for (int i = 1; i < nElems; i++){ 
	      if(longArray[i] > maxValue){ 
	         maxValue = longArray[i]; 
	      }else if (nElems == 0){
	    	  maxValue = -1;
	      }
	      
	    } 
	    
	    System.out.println("Max Entry is: "+ maxValue);
	  }
	
	public void removeMax(){ //Problem 2.2: Method finds the max value and deletes it
	    long maxValue = longArray[0]; 
	    for (int i = 1; i < nElems; i++){ 
	      if(longArray[i] > maxValue){ 
	         maxValue = longArray[i]; 
	      }else if (nElems == 0){
	    	  maxValue = -1;
	      }      
	    } 	    
	    delete(maxValue);
	  }
	
	public void noDups() { //Problem 2.6: Method finds duplicates in the array and dele
		for (int i = 1; i < nElems; i++) {
			for (int p = i+1; p < nElems; p++) {
				if (longArray[i] == longArray[p]) {
					System.out.println("Duplicate Removed: "+ longArray[p]);
					delete(longArray[p]);
				}
			}
		}
		
	}
}

