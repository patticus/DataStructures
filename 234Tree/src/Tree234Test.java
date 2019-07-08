import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tree234Test {

	@Test
	void testfindMin() {
		Tree234 t = new Tree234();
		
		t.insert(30);
		t.insert(40);
		t.insert(50);
		t.insert(60);
//		t.insert(70);
		
		assertTrue(t.findMin() == 30);
	}

}
