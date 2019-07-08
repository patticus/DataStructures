package hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadInsertTest {

	@Test
	void testQuadProbing() {
		DataItem[] array = new DataItem[50];
		array[0] = new DataItem(4);		
		
		assertEquals(1, HashTable.quadProbing(array,  50,  0));
		array[1] = new DataItem(4);
		
		assertEquals(4, HashTable.quadProbing(array,  50,  0));
		array[4] = new DataItem(4);

		assertEquals(9, HashTable.quadProbing(array,  50,  0));
		array[9] = new DataItem(4);
	}

}
