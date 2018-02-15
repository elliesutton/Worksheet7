import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Ellen Sutton
 * 
 * This class contains the tests for worksheet2
 */

public class Worksheet2Test {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(System.out);
	}
	
	//tests for Ex1
	
	@Test 
	public void test1() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>());
		Tree<Integer> expected = new Tree<Integer>(-5, new Tree<Integer>(), new Tree<Integer>());
		Tree<Integer> actual = Worksheet2.negateAll(t);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test2() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(-2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> expected = new Tree<Integer>(-1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(-3, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actual = Worksheet2.negateAll(t);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test3() {
		Tree<Integer> t = new Tree<Integer>(1, 
				new Tree<Integer>(-2, new Tree<Integer>(), new Tree<Integer>(4, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> expected = new Tree<Integer>(-1, 
				new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>(-4, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(-3, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actual = Worksheet2.negateAll(t);
		
		assertEquals(expected, actual);
	}
	
	
	
	//tests for Ex2
	
	@Test
	public void test4() {
		Tree<Integer> t = new Tree<Integer>();
		boolean expected = true;
		boolean actual = Worksheet2.allPositive(t);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test5() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		boolean expected = true;
		boolean actual = Worksheet2.allPositive(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(-3, new Tree<Integer>(), new Tree<Integer>()));
		
		boolean expected = false;
		boolean actual = Worksheet2.allPositive(t);
		
		assertEquals(expected, actual);
	}
	
	@Test //t = [1,[2],[3[-5, ]]
	public void test7() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(-5, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		boolean expected = false;
		boolean actual = Worksheet2.allPositive(t);
		
		assertEquals(expected, actual);
	}
	
	
	
	//tests for Ex3
	
	
	@Test
	public void test8() {
		Tree<Integer> t = new Tree<Integer>();
		Tree<Integer> expected = new Tree<Integer>();
		Tree<Integer> actual = Worksheet2.mirror(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test9() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> expected = new Tree<Integer>(1, new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actual = Worksheet2.mirror(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test10() {
		Tree<Integer> t = new Tree<Integer>(1, 
				new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>(4, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> expected = new Tree<Integer>(1, 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(2, new Tree<Integer>(4, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		Tree<Integer> actual = Worksheet2.mirror(t);
		
		assertEquals(expected, actual);
	}
	
	
	
	//tests for Ex4
	@Test
	public void test11() {
		Tree<Integer> t = new Tree<Integer>();
		List<Integer> expected = new List<Integer>();
		List<Integer> actual = Worksheet2.postorder(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test12() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		List<Integer> expected = new List<Integer>(2, new List<Integer>(3, new List<Integer>(1, new List<Integer>())));
		
		List<Integer> actual = Worksheet2.postorder(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test13() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(-5, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		List<Integer> expected = new List<Integer>(2, new List<Integer>(-5, new List<Integer>(3, new List<Integer>(1,
				new List<Integer>()))));
		
		List<Integer> actual = Worksheet2.postorder(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test14() {
		Tree<String> t = new Tree<String>("one", new Tree<String>("two", new Tree<String>(), new Tree<String>()), 
				new Tree<String>("three", new Tree<String>(), new Tree<String>()));
		
		List<String> expected = new List<String>("two", new List<String>("three", new List<String>("one", new List<String>())));
		
		List<String> actual = Worksheet2.postorder(t);
		
		assertEquals(expected, actual);
	}
	
	
	
	//tests for Ex5
	@Test
	public void test15() {
		Tree<Integer> t = new Tree<Integer>();
		boolean expected = true;
		boolean actual = Worksheet2.isSearchTree(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test16() {
		Tree<Integer> t = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		boolean expected = false;
		boolean actual = Worksheet2.isSearchTree(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test17() {
		Tree<Integer> t = new Tree<Integer>(2, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		boolean expected = true;
		boolean actual = Worksheet2.isSearchTree(t);
		
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test18() {
		Tree<Integer> t = new Tree<Integer>(2, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(5, new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		boolean expected = true;
		boolean actual = Worksheet2.isSearchTree(t);
		
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test19() {
		Tree<Integer> t = new Tree<Integer>(2, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(5, new Tree<Integer>(-3, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		boolean expected = false;
		boolean actual = Worksheet2.isSearchTree(t);
		
		
		assertEquals(expected, actual);
	}
	
	
	
	
	//tests for Ex6
	
	@Test
	public void test20() {
		Tree<Integer> t = new Tree<Integer>();
		String expected = "\n";
		Worksheet2.printDescending(t);
		
		assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void test21() {
		Tree<Integer> t = new Tree<Integer>(2, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()));
		
		
		String expected = "\n3\n2\n1\n";
		Worksheet2.printDescending(t);
		
		assertEquals(expected, outContent.toString());
		
	}
	
	@Test
	public void test22() {
		Tree<Integer> t = new Tree<Integer>(2, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(5, new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		
		String expected = "\n5\n3\n2\n1\n";
		Worksheet2.printDescending(t);
		
		assertEquals(expected, outContent.toString());
		
	}
	
	@Test
	public void test23() {
		
		Tree<Integer> t = new Tree<Integer>(10, new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(15, new Tree<Integer>(12, new Tree<Integer>(), new Tree<Integer>()), 
						new Tree<Integer>(18, new Tree<Integer>(), new Tree<Integer>())));
		
		String expected = "\n18\n15\n12\n10\n5\n";
		Worksheet2.printDescending(t);
		
		assertEquals(expected, outContent.toString());
	}
	
	
	
	//tests for Ex7
	
	@Test
	public void test24() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>());
		
		int expected = 5;
		int actual = Worksheet2.max(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test25() {
		Tree<Integer> t = new Tree<Integer>(2, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(7, new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		int expected = 7;
		int actual = Worksheet2.max(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test26() {
		Tree<Integer> t = new Tree<Integer>(2, new Tree<Integer>(1, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(7, new Tree<Integer>(), new Tree<Integer>(9, new Tree<Integer>(), new Tree<Integer>())));
		
		int expected = 9;
		int actual = Worksheet2.max(t);
		
		assertEquals(expected, actual);
	}
	
	
	
	//tests for Ex8
	
	@Test
	public void test27() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>());
		
		int x = 5;
		
		Tree<Integer> expected = new Tree<Integer>();
		Tree<Integer> actual = Worksheet2.delete(t,  x);
		
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	public void test28() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(4, 
				new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>(6, 
						new Tree<Integer>(7, new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()));
		
		int x = 6;
		
		Tree<Integer> expected = new Tree<Integer>(5, new Tree<Integer>(4, 
				new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(7, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actual = Worksheet2.delete(t, x);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test29() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(4, 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>()), new Tree<Integer>(6, new Tree<Integer>(), new Tree<Integer>()));
		
		int x = 4;
		
		Tree<Integer> expected = new Tree<Integer>(5, new Tree<Integer>(3, 
				new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(6, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actual = Worksheet2.delete(t, x);
		
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	public void test30() {
		Tree<Integer> t = new Tree<Integer>(10, new Tree<Integer>(7, 
				new Tree<Integer>(4, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()),
						new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(8, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(12, new Tree<Integer>(), new Tree<Integer>()));
		
		int x = 7;
		
		Tree<Integer> expected = new Tree<Integer>(10, new Tree<Integer>(5, 
				new Tree<Integer>(4, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()),
						new Tree<Integer>()), new Tree<Integer>(8, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(12, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actual = Worksheet2.delete(t, x);
		
		assertEquals(expected, actual);
		
	}


	
	//tests for Ex9
	
	@Test
	public void test31() {
		Tree<String> t = new Tree<String>();
		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(t);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test32() {
		Tree<String> t = new Tree<String>("one", new Tree<String>("two", new Tree<String>(), new Tree<String>()), 
				new Tree<String>("three", new Tree<String>(), new Tree<String>()));
		
		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(t);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test33() {
		Tree<Integer> t = new Tree<Integer>(10, new Tree<Integer>(7, 
				new Tree<Integer>(4, new Tree<Integer>(2, new Tree<Integer>(), new Tree<Integer>()),
						new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(8, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(12, new Tree<Integer>(), new Tree<Integer>()));
		
		boolean expected = false;
		boolean actual = Worksheet2.isHeightBalanced(t);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test34() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(4, 
				new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()),
				new Tree<Integer>()), new Tree<Integer>());
		
		boolean expected = false;
		boolean actual = Worksheet2.isHeightBalanced(t);
		
		assertEquals(expected, actual);		
	}
	
	
	//tests for Ex10
	
	@Test
	public void test35() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(4, 
				new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>());
		
		Tree<Integer> expectedTree = new Tree<Integer>(4, new Tree<Integer>(3, 
				new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>(5, 
						new Tree<Integer>(), new Tree<Integer>()));
		
		boolean expectedHB = true;
		
		Tree<Integer> actualTree = Worksheet2.insertHB(3, t);
		boolean actualHB = Worksheet2.isHeightBalanced(actualTree);
		
		assertEquals(expectedTree, actualTree);
		assertEquals(expectedHB, actualHB);	
	}
	
	
	@Test
	public void test36() {
		Tree<Integer> t = new Tree<Integer>(10, new Tree<Integer>(5, new Tree<Integer>(2, 
				new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>(8, new Tree<Integer>(), 
						new Tree<Integer>())), new Tree<Integer>(12, new Tree<Integer>(), 
								new Tree<Integer>()));
		
		Tree<Integer> expectedTree = new Tree<Integer>(8, new Tree<Integer>(5, new Tree<Integer>(2, 
				new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>(6, new Tree<Integer>(), 
						new Tree<Integer>())), new Tree<Integer>(10, new Tree<Integer>(), 
								new Tree<Integer>(12, new Tree<Integer>(), new Tree<Integer>())));
		
		boolean expectedHB = true;
		
		Tree<Integer> actualTree = Worksheet2.insertHB(6, t);
		boolean actualHB = Worksheet2.isHeightBalanced(actualTree);
		
		assertEquals(expectedTree, actualTree);
		assertEquals(expectedHB, actualHB);
		
	}
		

	
	@Test
	public void test37() {
		Tree<Integer> t = new Tree<Integer>(5, new Tree<Integer>(4, new Tree<Integer>(3, 
				new Tree<Integer>(), new Tree<Integer>()), new Tree<Integer>()), new Tree<Integer>(6, 
						new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> expectedTree = new Tree<Integer>(4, new Tree<Integer>(3, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actualTree = Worksheet2.deleteHB(t, 6);
		
		boolean expectedHB = true;
		boolean actualHB = Worksheet2.isHeightBalanced(actualTree);
		
		
		assertEquals(expectedTree, actualTree);
		assertEquals(expectedHB, actualHB);
		
	}
	
	@Test
	public void test38() {
		Tree<Integer> t = new Tree<Integer>(10, new Tree<Integer>(5, new Tree<Integer>(), new Tree<Integer>()), 
				new Tree<Integer>(15, new Tree<Integer>(12, new Tree<Integer>(), new Tree<Integer>()), 
						new Tree<Integer>(18, new Tree<Integer>(), new Tree<Integer>())));
		
		Tree<Integer> expectedTree = new Tree<Integer>(15, new Tree<Integer>(10, new Tree<Integer>(), new Tree<Integer>(12, new Tree<Integer>(), new Tree<Integer>())), 
				new Tree<Integer>(18, new Tree<Integer>(), new Tree<Integer>()));
		
		Tree<Integer> actualTree = Worksheet2.deleteHB(t, 5);
		
		boolean expectedHB = true;
		boolean actualHB = Worksheet2.isHeightBalanced(actualTree);
		
		
		assertEquals(expectedTree, actualTree);
		assertEquals(expectedHB, actualHB);
		
	}
	

}