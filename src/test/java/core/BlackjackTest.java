package core;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase {
	
	public void TestWin1() {
		Blackjackwin win = new Balckjackwin();
		
		assertEquals(Dwin, win.Win((SK,HA),(HQ,CA));
	}
	
	public void TestWin2() {
		Blackjackwin win = new Balckjackwin();
		
		assertEquals(Pwin, win.Win((SK,HQ),(SQ,C5,DJ));
	}
	
	public void TestWin3() {
		Blackjackwin win = new Balckjackwin();
		
		assertEquals(Pwin, win.Win((S10,D3,SA),(SQ,C5,CA,D2));
	}
	
	public void TestWin4() {
		Blackjackwin win = new Balckjackwin();
		
		assertEquals(Pwin, win.Win((SK,HK,H6,C5),(CQ,D9));
	}
	
	public void TestWin5() {
		Blackjackwin win = new Balckjackwin();
		
		assertEquals(Pwin, win.Win((SK,HA),(HQ,CA));
	}

}
