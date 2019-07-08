class QuickSortApp {
	public static void main(String[] args) {
		int maxSize = 16; // array size
		ArrayIns arr; // reference to array
		arr = new ArrayIns(maxSize); // create the array
//		for (int j = 0; j < maxSize; j++) // fill array with
//		{ // random numbers
//			long n = (int) (java.lang.Math.random() * 99);
//			arr.insert(n);
//		}
		
		for (int i = 11; i >= 0; i--) {
			arr.insert(i);
		}
		
		
		arr.display(); // display items
		arr.quickSort(); // quicksort them
		arr.display(); // display them again
		arr.displayCC();
	} // end main()
} // end class QuickSort2App