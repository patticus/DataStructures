// quickSort2.java
// demonstrates quick sort with median-of-three partitioning
// to run this program: C>java QuickSort2App
////////////////////////////////////////////////////////////////
class ArrayIns {
	private long[] theArray; // ref to array theArray
	private int nElems; // number of data items
	private int copy = 0;
	private int comparison = 0;
	private int swap = 0;
//--------------------------------------------------------------

	public ArrayIns(int max) // constructor
	{
		theArray = new long[max]; // create the array
		nElems = 0; // no items yet
	}

//--------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}

//--------------------------------------------------------------
	public void display() // displays array contents
	{
		System.out.print("A=");
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(theArray[j] + " "); // display it
		System.out.println("");
	}
	
	public void displayCC() {
		System.out.println("Swaps: "+ swap);
		System.out.println("Copies: "+ copy);
		System.out.println("Comparisons: "+ comparison);
	}

//--------------------------------------------------------------
	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

//--------------------------------------------------------------
	public void recQuickSort(int left, int right) {
		int size = right - left + 1;
		if (size <= 3) // manual sort if small
			manualSort(left, right);
		else // quicksort if large
		{
			long median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	} // end recQuickSort()
		// --------------------------------------------------------------

	public long medianOf3(int left, int right) {
		int center = (left + right) / 2;
		// order left & center
		comparison++;
		if (theArray[left] > theArray[center]) {
			swap(left, center);	
		}
		// order left & right
		comparison++;
		if (theArray[left] > theArray[right]) {
			swap(left, right);
		}
		// order center & right
		comparison++;
		if (theArray[center] > theArray[right]) {
			swap(center, right);
		}
		swap(center, right - 1); // put pivot on right
		return theArray[right - 1]; // return median value
	} // end medianOf3()
		// --------------------------------------------------------------

	public void swap(int dex1, int dex2) // swap two elements
	{
		long temp = theArray[dex1]; // A into temp
		theArray[dex1] = theArray[dex2]; // B into A
		theArray[dex2] = temp; // temp into B
		copy = copy + 3;
		swap++;
	} // end swap(
		// --------------------------------------------------------------

	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left; // right of first elem
		int rightPtr = right - 1; // left of pivot
		while (true) {
			comparison++;
			while (theArray[++leftPtr] < pivot) {
				comparison++;
			}
			comparison++;
			while (theArray[--rightPtr] > pivot) {
				comparison++;
			}
			
			if (leftPtr >= rightPtr) // if pointers cross,
				break; // partition done
			else // not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		swap(leftPtr, right - 1); // restore pivot
		return leftPtr; // return pivot location
	} // end partitionIt()
		// --------------------------------------------------------------

	public void manualSort(int left, int right) {
		int size = right - left + 1;
		if (size <= 1)
			return; // no sort necessary
		if (size == 2) { // 2-sort left and right
			comparison++;
			if (theArray[left] > theArray[right]) {
				swap(left, right);
			}
			return;
		} else // size is 3
		{ // 3-sort left, center, & right
			comparison++;
			if (theArray[left] > theArray[right - 1]) {
				swap(left, right - 1); // left, center
			}
			comparison++;
			if (theArray[left] > theArray[right]) {
				swap(left, right); // left, right
			}
			comparison++;
			if (theArray[right - 1] > theArray[right]) {
				swap(right - 1, right); // center, right
			}
		}
	} // end manualSort()
		// --------------------------------------------------------------
} // end class ArrayIns
	////////////////////////////////////////////////////////////////