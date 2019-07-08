package hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void testLinearProbing() {
		DataItem[] array = new DataItem[5];
		array[0] = new DataItem(4);
		array[1] = new DataItem(4);
		
		int nextHashValue = HashTable.linearProbing(array,  5,  0);
		
		
		assertEquals(2, nextHashValue);
	}

}
