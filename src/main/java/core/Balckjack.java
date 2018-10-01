package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Balckjack {
	
	private ArrayList<String> card = new ArrayList<String>(52);
	private String[] suit = {"S","C","D","H"};
	private String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	public ArrayList<String> handcard = new ArrayList<String>();
	public ArrayList<String> handcard2 = new ArrayList<String>();
	public ArrayList<String> Dhandcard = new ArrayList<String>();
	public ArrayList<String> Dhandcard2 = new ArrayList<String>();
	public int point = 0;
	public int point2 = 0;
	public int dealerpoint = 0;
	public int dealerpoint2 = 0;
	private String[] commands;
	int counter = 4;
	public boolean Ace;
	
	//private int cardNum;
	


	
	public void play(String s) throws FileNotFoundException {
		System.out.println("Welcome to Balckjack");
		fileinput(s);
		result();
	}
	
	public void ccard() {
		for(int i=0;i<suit.length;i++) {
			for(int j=0;j<rank.length;j++) {
				String tmep = suit[i] + rank[j];
				card.add(tmep);
			}
		}
		
	}
	
	private void shuffle() {
		Collections.shuffle(card);
	}
	
	private void fileinput(String s) throws FileNotFoundException {
		System.out.print("\n Do you want file input or console input ?(F/C) :");
		String temp = new Scanner(System.in).next();
		
		if (temp.equalsIgnoreCase("F")) {
			//System.out.print("\n Please input file name :");
			//Scanner sc = new Scanner(System.in);
			File fs =new File (s);
			Scanner fl = new Scanner(fs);
			commands  =fl.nextLine().split("\\s+");
			
			if (determineCardValue2(commands[0].substring(1))== 11) {
				Ace=true;
			
			}
			handcard2.add(commands[0]);
			handcard2.add(commands[1]);
			
			Dhandcard2.add(commands[2]);
			Dhandcard2.add(commands[3]);
			
			point += determineCardValue2(commands[0].substring(1));
			point += determineCardValue2(commands[1].substring(1));
			
			dealerpoint += determineCardValue2(commands[2].substring(1));
			dealerpoint += determineCardValue2(commands[3].substring(1));
			
			if(handcard2.get(0).charAt(1)==handcard2.get(1).charAt(1)) {
				//System.out.println("Do you want to split (Y/N)");
				if (commands[counter].equalsIgnoreCase("D")) {
					counter++;
					
					handcard.add(handcard2.get(0));
					handcard2.remove(0);
					
					point -= determineCardValue(handcard2.get(0));
					point2 += determineCardValue(handcard.get(0));
					
					handcard2.add(commands[counter]);
					counter++;
					point += determineCardValue(handcard2.get(handcard2.size()-1));
					
					handcard.add(commands[counter]);
					counter++;
					point2 += determineCardValue(handcard.get(handcard.size()-1));
					
					System.out.print("\nPlayer split hand card !!!");
					
					System.out.print("\nPlayer First hand card :");
					System.out.print(handcard);
					
					System.out.print("\nPlayer Second hand card :");
					System.out.print(handcard2);
					
					System.out.println(" \nCurent First hand Point :" + point);
					System.out.println(" \nCurent Second hand Point :" + point2);
				}
					
			}
			
			hitcard();
			
			if(Dhandcard2.get(0).charAt(1)==Dhandcard2.get(1).charAt(1)) {
				
					
					Dhandcard.add(Dhandcard2.get(0));
					Dhandcard2.remove(0);
					
					dealerpoint -= determineCardValue(Dhandcard2.get(0));
					dealerpoint2 += determineCardValue(Dhandcard.get(0));
					
					Dhandcard2.add(commands[counter]);
					counter++;
					
					dealerpoint += determineCardValue(Dhandcard2.get(Dhandcard2.size()-1));
					
					Dhandcard.add(commands[counter]);
					counter++;
					dealerpoint2 += determineCardValue(Dhandcard.get(Dhandcard.size()-1));
					
					System.out.print("\nDealer split hand card !!!");
					
					System.out.print("\nDealer First hand card :");
					System.out.print(Dhandcard);
					
					System.out.print("\nDealer Second hand card :");
					System.out.print(Dhandcard2);
					
					System.out.println(" \nCurent First hand Point :" + dealerpoint);
					System.out.println(" \nCurent Second hand Point :" + dealerpoint2);
				
					hitcard();
			}
			
			
			/*
			System.out.print("\nPlayer hand card :");
			System.out.print(handcard2.get(0)+ " ");
			System.out.print(handcard2.get(1)+ " ");
			
			System.out.print("\n Dealer hand card :");
			System.out.print(Dhandcard2.get(0)+ " ");
			System.out.print(Dhandcard2.get(1)+ " ");
			
			System.out.println(" \n Player CurentPoint :" + point);
			System.out.println("Dealer CurentPoint :" + dealerpoint);
			*/
			
			
		}
		if (temp.equalsIgnoreCase("C")) {
			ccard();
			shuffle();
			playerdealt();
			dealercard();
			morecard();
			showhandcards();
			outresult();
		}
	}
	
	private void playerdealt() {
		handcard.add(card.get(0));
		card.remove(0);
		handcard.add(card.get(0));
		card.remove(0);
		point += determineCardValue(handcard.get(0));
		point += determineCardValue(handcard.get(1));
		//cardNum = 2;

		System.out.print("\nPlayer hand card :");
		System.out.print(handcard);
		System.out.println(" \nCurentPoint :" + point);
		
		if(handcard.get(0).charAt(1)==handcard.get(1).charAt(1)) {
			System.out.println("Do you want to split (Y/N)");
			if (new Scanner(System.in).next().equalsIgnoreCase("Y")) {
				
				handcard2.add(handcard.get(0));
				handcard.remove(0);
				
				point -= determineCardValue(handcard2.get(0));
				point2 += determineCardValue(handcard2.get(0));
				
				handcard.add(card.get(0));
				point += determineCardValue(card.get(0));
				card.remove(0);
				
				handcard2.add(card.get(0));
				point2 += determineCardValue(card.get(0));
				card.remove(0);
				
				System.out.print("\nPlayer split hand card !!!");
				
				System.out.print("\nPlayer First hand card :");
				System.out.print(handcard);
				
				System.out.print("\nPlayer Second hand card :");
				System.out.print(handcard2);
				
				System.out.println(" \nCurent First hand Point :" + point);
				System.out.println(" \nCurent Second hand Point :" + point2);
			}
				
		}
	}
	private int determineCardValue(String rank) throws NumberFormatException {
		  
		  int value = 0;
		  
		  try {
		   if(rank.equalsIgnoreCase("S10") || rank.equalsIgnoreCase("C10") || rank.equalsIgnoreCase("D10") || rank.equalsIgnoreCase("H10")) {
			   value = 10;
		   }else {
			   value = Integer.parseInt(Character.toString(rank.charAt(1)));
			   return value;
		   }
		   
		  } catch (NumberFormatException e) {
		  
		   if(rank.charAt(1) == 'K' || rank.charAt(1) == 'Q' || rank.charAt(1) == 'J') {
		    value = 10;
		   } else if (rank.charAt(1) == 'A') {
			   Ace = true;
			   value = 11;
		   } 
//	
		   return value;
		   
		  }
		  return value;
		  
		 }
	
	private int determineCardValue2(String rank) throws NumberFormatException {
		  
		  int value = 0;
		  
		  try {
		   
		   value = Integer.parseInt(rank.substring(0, rank.length()));
		   return value;
		   
		  } catch (NumberFormatException e) {
		   
		   if(rank.charAt(0) == 'K' || rank.charAt(0) == 'Q' || rank.charAt(0) == 'J' || rank.charAt(0) == '1') {
		    value = 10;
		   } else if (rank.charAt(0) == 'A') {
		    value = 11;
		    Ace = true;
		   } else {
		    value = Integer.parseInt(rank.substring(0,1));
		   }
		   
		   return value;
		   
		  }
		  
		 }
	
	private void morecard(){
		while(true) {
			
			if (point >= 21) {
				break;
			}
			
			System.out.println("\nHit? (iput N to stand and input anything else to Hit)");
			if (new Scanner(System.in).next().equalsIgnoreCase("N")) {
					while(true) {
					if (point2 > 0) {
						if (point2 >= 21) {
							break;
						}
					
						System.out.println("\n Hit? second hand card (iput N to stand and input anything else to Hit)");
						if (new Scanner(System.in).next().equalsIgnoreCase("N")) {
							break;
						}else {
							handcard2.add(card.get(0));
							card.remove(0);
							point += determineCardValue(handcard2.get(handcard2.size()-1));
							//cardNum++;
							System.out.print("\nPlayer  second hand card :");
							System.out.print(handcard2);
							System.out.println(" \nCurentPoint :" + point2);
						}
					
					}else {
						break;
					}
				}
				break;
			}else {
				handcard.add(card.get(0));
				card.remove(0);
				point += determineCardValue(handcard.get(handcard.size()-1));
				//cardNum++;
				System.out.print("\nPlayer hand card :");
				System.out.print(handcard);
				System.out.println(" \nCurentPoint :" + point);
			}
			
		}
		
	}
	
	private void hitcard(){
		
		if (counter +1 > commands.length) System.exit(0);
		
		while(commands[counter].indexOf("H") == 0 || commands[counter].indexOf("S") == 0) {
			
			if (Ace && point>21) {
				point = point - 10;
			}
        	if (point >= 21) {
        		break;
        	}
			
			if (commands[counter].indexOf("H") == 0 ) {
				counter++;
				handcard2.add(commands[counter]);
				point += determineCardValue2(commands[counter].substring(1));
				counter++;
			}else if (commands[counter].indexOf("S") == 0) {
				
				counter+=1;
				break;
			}
		}
		if (point2 >0) {
			while(commands[counter].indexOf("H") == 0 || commands[counter].indexOf("S") == 0) {
				
				if (Ace && point2>21) {
					point2 = point2 - 10;
				}
	        	if (point2 >= 21) {
	        		break;
	        	}
				
				if (commands[counter].indexOf("H") == 0 ) {
					counter++;
					handcard.add(commands[counter]);
					point2 += determineCardValue2(commands[counter].substring(1));
					counter++;
				}else if (commands[counter].indexOf("S") == 0) {
					
					counter+=1;
					break;
				}
			}
		}
		
		while(dealerpoint < 17 && counter < commands.length) {
			
			Dhandcard2.add(commands[counter]);
			dealerpoint += determineCardValue2(commands[counter].substring(1));
			counter+=1;
			
			if (Ace && dealerpoint>21) {
				dealerpoint = dealerpoint - 10;
				Ace = false;
			}
			if (dealerpoint >= 21) {
				break;
			}
			
		}
		if(dealerpoint >= 21 && dealerpoint2 >0) {
			while(dealerpoint2 < 17 && counter < commands.length) {
				
				Dhandcard.add(commands[counter]);
				dealerpoint2 += determineCardValue2(commands[counter].substring(1));
				counter++;
				
				if (Ace && dealerpoint2>21) {
					dealerpoint = dealerpoint - 10;
					Ace = false;
				}
				if (dealerpoint2 >= 21) {
					break;
				}
			}
			
		}
		
		outresult2();
		
	}
	
	private void showhandcards() {
		System.out.print("\nPlayer hand card :");
		System.out.print(handcard);
		System.out.println(" \nCurentPoint :" + point);
	}
	
	private void dealercard() {
		
		Dhandcard.add(card.get(0));
		dealerpoint += determineCardValue(card.get(0));
		//System.out.print(dealerpoint);
		card.remove(0);
		
		Dhandcard.add(card.get(0));
		dealerpoint += determineCardValue(card.get(0));
		//System.out.print(dealerpoint);
		card.remove(0);
		
		if(Dhandcard.get(0).charAt(1)==Dhandcard.get(1).charAt(1)) {
			System.out.print(" \nDealer  split hand card :");
			
			
			Dhandcard2.add(Dhandcard.get(0));
			Dhandcard.remove(0);
			
			dealerpoint -= determineCardValue(handcard2.get(0));
			dealerpoint2 += determineCardValue(handcard2.get(0));
			
			handcard.add(card.get(0));
			card.remove(0);
			
			handcard2.add(card.get(0));
			card.remove(0);
			
		}
		while(true) {
			if (dealerpoint < 17) {
			Dhandcard.add(card.get(0));
			dealerpoint += determineCardValue(card.get(0));
			card.remove(0);
			//dealerpoint += determineCardValue(Dhandcard.get(Dhandcard.size()-1));
			
				if (Ace && dealerpoint>21) {
					dealerpoint = dealerpoint - 10;
				}
			
			}else {
				break;
			}
		}
		
		System.out.print(" \nDealer First Card :");
		System.out.print(Dhandcard.get(0));
		
		
		while (true) {
					if (dealerpoint2 > 0) {
					
					if (dealerpoint2 < 17) {
						Dhandcard2.add(card.get(0));
						card.remove(0);
						dealerpoint2 += determineCardValue(Dhandcard2.get(Dhandcard2.size()-1));
						
						if (Ace && dealerpoint2>21) {
							dealerpoint2 = dealerpoint2 - 10;
							Ace=false;
						}
						
						}else {
							break;
						}
					
				}else {
					break;
				}
		}
		if (dealerpoint2 > 0) {
			System.out.print(" \nDealer second hand fist Card :");
			System.out.print(Dhandcard2.get(0));
		}
		
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
		if (point2 >0 ) {
			if(point2 > 21) {
				System.out.println("\nPlayer second hand lost");
			}else if(point2 == dealerpoint) {
				System.out.println("\nPlayer second hand lost");
			}else if(dealerpoint > 21) {
				System.out.println("\nPlayer second hand Win");
			}else if(point2 > dealerpoint) {
				System.out.println("\nPlayer second hand Win");
			}else {
				System.out.println("\nPlayer second hand lost");
			}
		}
		
		if (dealerpoint2 >0 ) {
			if (point > 21) {
				System.out.println("\nPlayer lost 2");
			}else if(point == dealerpoint2) {
				System.out.println("\nPlayer lost 2");
			}else if(dealerpoint2 > 21) {
				System.out.println("\nPlayer  Win 2");
			}else if(point > dealerpoint2) {
				System.out.println("\nPlayer  Win 2");
			}else {
				System.out.println("\nPlayer lost 2");
			}
		}
		
		
		
	}
	private void outresult() {
		System.out.print("\nDealer hand card :");
		System.out.print(Dhandcard);
		System.out.println("\nDealerpoint:"+dealerpoint);
	}
	private void outresult2() {
		System.out.print("\nPlayer hand card :");
		System.out.print(handcard2);
		System.out.println("\nPlayerpoint:"+point);
		if (point2>0) {
			System.out.print("\nPlayer second hand card :");
			System.out.print(handcard);
			System.out.println("\nPlayerpoint:"+point2);
		}
		
		System.out.print("\nDealer hand card :");
		System.out.print(Dhandcard2);
		System.out.println("\nDealerpoint:"+dealerpoint);
		if(dealerpoint2>0) {
			System.out.print("\nDealer second hand card :");
			System.out.print(Dhandcard);
			System.out.println("\nDealerpoint:"+dealerpoint2);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		boolean playagain = true;
		while (playagain == true) {
			Balckjack game = new Balckjack();
			game.play("file2.txt");
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
