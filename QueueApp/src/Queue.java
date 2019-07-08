// queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

//--------------------------------------------------------------
	public Queue(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

//--------------------------------------------------------------
	public void insert(long j) // put item at rear of queue
	{
		if (rear == maxSize - 1) // deal with wraparound
			rear = -1;
		queArray[++rear] = j; // increment rear and insert
		nItems++; // one more item
	}

//--------------------------------------------------------------
	public long remove() // take item from front of queue
	{
		long temp = queArray[front++]; // get value and incr front
		if (front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item
		return temp;
	}

//--------------------------------------------------------------
	public long peekFront() // peek at front of queue
	{
		return queArray[front];
	}

//--------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

//--------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}

//--------------------------------------------------------------
	public int size() // number of items in queue
	{
		return nItems;
	}
	
	
	//Problem 4.1 code
	
	private int adjust(int index) {
        return (index + maxSize) % maxSize; // the modulus operator % deals with the wrap around
    }
	
	public void displayQueue() { //Main display method for the contents of the queue 
        System.out.print("First Item: ");

        if (!isEmpty()) {
            for (int i = 0; i < nItems; i++) { //loops through the array and prints out the queue list starting from the first item
                System.out.println(queArray[adjust(front + i)]); //uses the adjust method when printing the list to account for the wrap around
            }
        }
        else {
        	System.out.println("No items in the queue");
        }
        
    }
//--------------------------------------------------------------
} // end class Queue
////////////////////////////////////////////////////////////////