package core;

import java.io.FileNotFoundException;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase {
	
	public void test1() throws FileNotFoundException {
		Balckjack b = new Balckjack();
		b.play("File2.txt");
		assertEquals(2,b.handcard2.size());
	}
	
	public void test2() throws FileNotFoundException {
		Balckjack b = new Balckjack();
		b.play("File2.txt");
		assertEquals(20,b.point);
	}
	
	public void test3() throws FileNotFoundException {
		Balckjack b = new Balckjack();
		b.play("File3.txt");
		assertEquals(19,b.point);
	}
	
	public void test4() throws FileNotFoundException {
		Balckjack b = new Balckjack();
		b.play("File4.txt");
		assertEquals(19,b.point);
		assertEquals(20,b.point2);
		
	}
	
	public void test5() throws FileNotFoundException {
		Balckjack b = new Balckjack();
		b.play("File5.txt");
		assertEquals(19,b.point);
		assertEquals(22,b.dealerpoint);
		assertEquals(18,b.dealerpoint2);
	}
}
