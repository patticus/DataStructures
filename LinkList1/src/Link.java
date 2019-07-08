// sortedList.java
// demonstrates sorted list
// to run this program: C>java SortedListApp
////////////////////////////////////////////////////////////////
class Link {
	public long dData; // data item
	public Link next; // next link in list
// -------------------------------------------------------------

	public Link(long dd) // constructor
	{
		dData = dd;
	}

// -------------------------------------------------------------
	public void displayLink() // display this link
	{
		System.out.print(dData + " ");
	}
}