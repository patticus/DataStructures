package hash;
import java.io.*;

class HashTable {
	private DataItem[] hashArray; // array holds hash table
	private int arraySize;
	private DataItem nonItem; // for deleted items
//-------------------------------------------------------------

	public HashTable(int size) // constructor
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1); // deleted item key is -1
	}

//-------------------------------------------------------------
	public void displayTable() {
		System.out.print("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}

//-------------------------------------------------------------
	public int hashFunc(int key) {
		return key % arraySize; // hash function
	}

//-------------------------------------------------------------
	
	public void insert(DataItem item) // insert a DataItem
//(assumes table not full)
	{
		int key = item.getKey(); // extract key
		int hashVal = hashFunc(key); // hash the key
//until empty cell or -1,
		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		hashArray[hashVal] = item; // insert item
	} // end insert()
//-------------------------------------------------------------

	public static int linearProbing(DataItem[] array, int size, int hashVal) {
		while (array[hashVal] != null) {
			++hashVal; // go to next cell
			hashVal %= size; // wraparound if necessary
		}
		return hashVal;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// Listing 11.1 - Created a new insert method for quadratic probing
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static int quadProbing(DataItem[] array, int size, int hashVal) {
		
		int quadProbe = 1;
		int start = hashVal;
		while(array[hashVal] != null)
		{
			hashVal += (quadProbe * quadProbe); //formula for going to the next cell using quadratic probing
			quadProbe++;
			hashVal %= size; // wraparound if necessary
		}
		return hashVal;
	}
	
	public void insertQuad(DataItem item)
	{
		int key = item.getKey();
		int hashVal = hashFunc(key);
//		int quadProbe = 1;
//		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)
//		{
//			hashVal += (quadProbe * quadProbe); //formula for going to the next cell using quadratic probing
//			quadProbe++;
//			hashVal %= arraySize; // wraparound if necessary
//		}
		hashVal = quadProbing(hashArray, arraySize, hashVal);	
		hashArray[hashVal] = item;
	} // end insert()

	public DataItem delete(int key) // delete a DataItem
	{
		int hashVal = hashFunc(key); // hash the key
		while (hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if (hashArray[hashVal].getKey() == key) {
				DataItem temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem; // delete item
				return temp; // return item
			}
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can’t find item
	} // end delete()
//-------------------------------------------------------------

	public DataItem find(int key) // find item with key
	{
		int hashVal = hashFunc(key); // hash the key
		while (hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if (hashArray[hashVal].getKey() == key)
				return hashArray[hashVal]; // yes, return item
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can’t find item
	}
//-------------------------------------------------------------
} // end class HashTable
////////////////////////////////////////////////////////////////