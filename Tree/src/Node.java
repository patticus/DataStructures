
// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
import java.io.*;
import java.util.*; // for Stack class
////////////////////////////////////////////////////////////////

class Node {
	public String sData;
	public int iData; // data item (key)
	public double dData; // data item
	public Node leftChild; // this node’s left child
	public Node rightChild; // this node’s right child

	
	public Node(String letter) {
		this.sData = letter;
	}
	
	public void displayNode() // display ourself
	{
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
	
	
	public char toChar() {
		return (char)iData;
	}
	
	public boolean hasTwoChildren() {
		return (this.leftChild != null && this.rightChild != null);
	}
} // end class Node
////////////////////////////////////////////////////////////////