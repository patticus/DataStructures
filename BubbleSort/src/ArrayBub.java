
public class ArrayBub {
	// bubbleSort.java
	// demonstrates bubble sort
	// to run this program: C>java BubbleSortApp
	////////////////////////////////////////////////////////////////
	private int[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayBub(int max) // constructor
	{
		a = new int[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(int value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
	for(int j=0; j<nElems; j++) // for each element,
	System.out.print(a[j] + " "); // display it
	System.out.println("");
	}

	// --------------------------------------------------------------
	public void bubbleSort() {
		int out, in;
		for (out = nElems - 1; out > 1; out--) // outer loop (backward)
			for (in = 0; in < out; in++) // inner loop (forward)
				if (a[in] > a[in + 1]) // out of order?
					swap(in, in + 1); // swap them
	} // end bubbleSort()
		// --------------------------------------------------------------
	
	private void swap(int one, int two) {
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	
	public void bidirectionalSort() { //Problem 3.1 -- Add another out index (outBack) to go backwards through the array and swap the smaller number to the left
		int in, out, outBack;
		for (out = nElems - 1, outBack = 0; outBack < out; out--, outBack++) {
			for (in = outBack; in < out; in++) {
				if (a[in] > a[in + 1])
					swap(in, in + 1);
					display(); //Displays the number list after each swap, with the largest number getting pushed to the right
			}
			for (in = out; in > outBack; in--) {
				if (a[in - 1] > a[in])
					swap(in - 1, in);
					display(); //Displays the list after swap, with lowest number getting pushed to the left
			}
		}
	}
	// --------------------------------------------------------------
} // end class ArrayBub
		////////////////////////////////////////////////////////////////

