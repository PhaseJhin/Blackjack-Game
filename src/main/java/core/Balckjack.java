package core;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Balckjack {
	
	private int[] card = new int[52];
	private String[] suit = {"S","C","D","H"};
	private String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private ArrayList<Integer> handcard = new ArrayList<Integer>();
	private int point;
	private int dealerpoint = 0;
	private int cardNum;
	
	public void play() {
		shuffle();
		dealt();
		morecard();
		showhandcards();
		dealercard();
		result();
	}
	private void shuffle() {
		for(int x = 0; x<52;x++) {
			card[x]=x;
		}
		
		for(int y=0;y<100;y++) {
			Random i = new Random();
			
			int x1 = Math.abs(i.nextInt()%52);
			int x2 = Math.abs(i.nextInt()%52);
			
			int j = card[x2];
			card[x2] = card[x1];
			card[x1] = j;
			
			
		}
	}
	private void dealt() {
		handcard.add(card[0]);
		handcard.add(card[1]);
		point += countpoint(card[0]);
		point += countpoint(card[1]);
		cardNum = 2;
	}
	private int countpoint(int i) {
		int j = 0;
		if (i%13+1>10) {
			j =10;
		}else {
			j = (i+1)%13;
		}
		
		return j;
	}
	
	private void morecard(){
		while(true) {
			
			if (point >= 21) {
				break;
			}
			
			System.out.println("Hit? (iput N to stand)");
			if (new Scanner(System.in).next().equalsIgnoreCase("N")) {
				break;
			}else {
				handcard.add(card[cardNum]);
				point += countpoint(card[cardNum]);
				cardNum++;
			}
			
		}
		
	}
	
	private void showhandcards() {
		for (Integer in:handcard) {
			System.out.print(suit[in/13]+" "+rank[in%13]+"\t");
		}
		System.out.println("CurentPoint" + point);
	}
	
	private void dealercard() {
		Random i = new Random();
		dealerpoint = Math.abs(i.nextInt())%10+16;
		System.out.println("\n Dealerpoint:"+dealerpoint);
	}
	
	private void result() {
		if(point > 21) {
			System.out.println("Player lost");
		}else if(point == dealerpoint) {
			System.out.println("Player lost");
		}else if(dealerpoint > 21) {
			System.out.println("Player Win");
		}else if(point > dealerpoint) {
			System.out.println("Player Win");
		}else {
			System.out.println("Player lost");
		}
	}
	
	public static void main(String[] args) {
		new Balckjack();
	}
	
}
