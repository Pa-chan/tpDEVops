package datastruct;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyUnsortedListTest {

	@Test
	void simple_equality() {
		Integer[][] e = new Integer[][] {
			new Integer[] {},
			new Integer[] {0},
			new Integer[] {10},
			new Integer[] {0,32432,5632453},
			new Integer[] {654186416,84648+868746,89674676*7,9767676*76,76*767*67*68979454,676748641+6,684864687},
		};
		for (Integer[] ve : e) {
			MyUnsortedList<Integer> mil1 = MyUnsortedList.of(ve), mil2 = MyUnsortedList.of(ve);
			assertEquals(mil1, mil2);
		}
	}
	
	@Test
	void simple_append() {
		MyUnsortedList<Integer> mil1 = MyUnsortedList.of(), mil2 = MyUnsortedList.of(1,2);
		mil1.append(1);
		mil1.append(2);
		assertEquals(mil1, mil2);
	}
	
	@Test
	void simple_pop() { // popLast did not decrease size
		MyUnsortedList<Integer> mil1 = MyUnsortedList.of(1, 2, 3), mil2 = MyUnsortedList.of(1,2);
		mil1.popLast();
		assertEquals(mil1, mil2);
	}
	
	@Test
	void simple_remove() {
		MyUnsortedList<Integer> mil1 = MyUnsortedList.of(1, 2, 3), mil2 = MyUnsortedList.of(1,3);
		Integer mv = mil1.remove(1);
		Integer ref = 2;
		assertEquals(mv, ref);
		assertEquals(mil1, mil2);
	}
	
	@Test
	void simple_prepend() {
		MyUnsortedList<Integer> mil1 = MyUnsortedList.of(1, 2, 3), mil2 = MyUnsortedList.of(2,3);
		mil2.prepend(1);
		assertEquals(mil1, mil2);		
	}
	
	@Test
	void all_remove() {
		MyUnsortedList<Integer> mil = MyUnsortedList.of(1);
		Integer mv = mil.popLast();
		Integer ref = 1;
		assertEquals(mv, ref);
		assertTrue(mil.isEmpty());
	}
	
	@Test
	void cant_insert() {
		assertThrows(IndexOutOfBoundsException.class, () -> MyUnsortedList.of().insert(1, -1));
		assertThrows(IndexOutOfBoundsException.class, () -> MyUnsortedList.of().insert(1, 2));
	}

	@Test
	void cant_popLast() {
		assertThrows(EmptyListException.class, () -> MyUnsortedList.of().popLast());
	}
	
	@Test
	void cant_pop() {
		assertThrows(EmptyListException.class, () -> MyUnsortedList.of().pop());
	}
	
	@Test
	void cant_remove() {
		assertThrows(IndexOutOfBoundsException.class, () -> MyUnsortedList.of().remove(0));
		assertThrows(IndexOutOfBoundsException.class, () -> MyUnsortedList.of().remove(-1));
	}
	
	public static final int SIZE_TEST = 100;
	
	@Test
	void simple_size() {
		MyUnsortedList<Integer> mil = MyUnsortedList.of();
		for(int i = 0; i < SIZE_TEST; i+=1) {
			assertEquals(mil.size(), i);
			mil.append(i);
		}
		assertEquals(SIZE_TEST, mil.size());
	}
	
	@Test
	void simple_to_string() {
		MyUnsortedList<Integer> mil = MyUnsortedList.of();
		assertEquals("MyUnsortedList { size = 0, [] }", mil.toString());
		mil.append(1);
		assertEquals("MyUnsortedList { size = 1, [1] }", mil.toString());
		mil.append(2);
		assertEquals("MyUnsortedList { size = 2, [1, 2] }", mil.toString());
	}
	
	@Test
	void simple_different() {
		assertNotEquals(MyUnsortedList.of(), null);
		assertNotEquals(MyUnsortedList.of(1), MyUnsortedList.of());
		assertNotEquals(MyUnsortedList.of(), MyUnsortedList.of(1));
		assertNotEquals(MyUnsortedList.of(2), MyUnsortedList.of(1));
	}
}
