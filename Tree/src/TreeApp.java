
// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
import java.io.*;
import java.util.*; // for Stack class
////////////////////////////////////////////////////////////////

class TreeApp {
	public static void main(String[] args) throws IOException {
		int value;
		Tree theTree = new Tree();
		theTree.insert(4, "D");
		theTree.insert(7, "G");
		theTree.insert(8, "H");
		theTree.insert(1, "A");
		theTree.insert(2, "B");
		theTree.insert(3, "C");
		theTree.insert(5, "E");
		theTree.insert(6, "F");
		
		
//		theTree.insert(12);
//		theTree.insert(37);
//		theTree.insert(43);
//		theTree.insert(30);
//		theTree.insert(33);
//		theTree.insert(87);
//		theTree.insert(93);
//		theTree.insert(97);
		while (true) {
			System.out.print("Enter first letter of show, ");
			System.out.print("insert, find, delete, or traverse: ");
			int choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				//theTree.insert(value);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = getInt();
				Node found = theTree.find(value);
				if (found != null) {
					System.out.print("Found: ");
					found.displayNode();
					System.out.print("\n");
				} else
					System.out.print("Could not find ");
				System.out.print(value + '\n');
				break;
			case 'd':
				System.out.print("Enter value to delete: ");
				value = getInt();
				boolean didDelete = theTree.delete(value);
				if (didDelete)
					System.out.print("Deleted " + value + '\n');
				else
					System.out.print("Could not delete ");
				System.out.print(value + '\n');
				break;
			case 't':
				System.out.print("Enter type 1, 2 or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.print("Invalid entry\n");
			} // end switch
		} // end while
	} // end main()
		// -------------------------------------------------------------

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	// -------------------------------------------------------------
	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	// -------------------------------------------------------------
	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
	// -------------------------------------------------------------
} // end class TreeApp
	////////////////////////////////////////////////////////////////