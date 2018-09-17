package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Balckjack {
	
	private ArrayList<Integer> card = new ArrayList<Integer>(52);
	private String[] suit = {"S","C","D","H"};
	private String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private ArrayList<Integer> handcard = new ArrayList<Integer>();
	private ArrayList<Integer> Dhandcard = new ArrayList<Integer>();
	private int point;
	private int dealerpoint;
	private int cardNum;
	

	public void ccard() {
		for(int x = 0; x<52;x++) {
			card.add(x);
		}
	}
	public void play() {
		System.out.println("Welcome to Balckjack");
		ccard();
		shuffle();
		playerdealt();
		dealercard();
		morecard();
		showhandcards();
		outresult();
		result();
	}
	private void shuffle() {
		
		Collections.shuffle(card);
		/*for(int x = 0; x<52;x++) {
			card[x]=x;
		}
		
		for(int y=0;y<26;y++) {
			Random i = new Random();
			
			int x1 = Math.abs(i.nextInt()%52);
			int x2 = Math.abs(i.nextInt()%52);
			
			int j = card[x2];
			card[x2] = card[x1];
			card[x1] = j;
			
			
		}
		*/
	}
	private void playerdealt() {
		handcard.add(card.get(0));
		card.remove(0);
		handcard.add(card.get(0));
		card.remove(0);
		point += countpoint(handcard.get(0));
		point += countpoint(handcard.get(1));
		cardNum = 2;

		System.out.print("\nPlayer hand card :");
		for (Integer in:handcard) {
			System.out.print(suit[in/13]+""+rank[in%13]+"\t");
		}
		System.out.println(" \nCurentPoint :" + point);
	}
	private int countpoint(int i) {
		int j = 0;
		if(i%13 ==1) {
			j=11;
		}
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
			
			System.out.println("\nHit? (iput N to stand and input anything else to Hit)");
			if (new Scanner(System.in).next().equalsIgnoreCase("N")) {
				break;
			}else {
				handcard.add(card.get(0));
				card.remove(0);
				point += countpoint(card.get(handcard.size()-1));
				cardNum++;
			}
			
		}
		
	}
	
	private void showhandcards() {
		System.out.print("\nPlayer hand card :");
		for (Integer in:handcard) {
			System.out.print(suit[in/13]+""+rank[in%13]+"\t");
		}
		System.out.println(" \nCurentPoint :" + point);
	}
	
	private void dealercard() {
		Dhandcard.add(card.get(0));
		card.remove(0);
		Dhandcard.add(card.get(0));
		card.remove(0);
		dealerpoint += countpoint(Dhandcard.get(0));
		dealerpoint += countpoint(Dhandcard.get(1));
		System.out.print(" \nDealer First Card :");
		System.out.print(suit[Dhandcard.get(0)/13]+""+rank[(Dhandcard.get(0)%13)]+"\t");
		//Random i = new Random();
		//dealerpoint = Math.abs(i.nextInt())%10+16;
	}
	
	private void result() {
		if(point > 21) {
			System.out.println("\nPlayer lost");
		}else if(point == dealerpoint) {
			System.out.println("\nPlayer lost");
		}else if(dealerpoint > 21) {
			System.out.println("\nPlayer Win");
		}else if(point > dealerpoint) {
			System.out.println("\nPlayer Win");
		}else {
			System.out.println("\nPlayer lost");
		}
	}
	private void outresult() {
		System.out.print("\nDealer hand card :");
		for(int i=0; i< Dhandcard.size() ; i++) {
				System.out.print(suit[Dhandcard.get(i)/13]+""+rank[Dhandcard.get(i)%13]+"\t");
		}
		System.out.println("\nDealerpoint:"+dealerpoint);
	}
	
	public static void main(String[] args) {
		boolean playagain = true;
		while (playagain == true) {
			Balckjack game = new Balckjack();
			game.play();
			System.out.println("\nDo you want to play again ? (Y/N)");
			if (new Scanner(System.in).next().equalsIgnoreCase("N")) {
				playagain = false;
			} 
			else{
				playagain = true;
			}
			
		}
		
	}
	
}
