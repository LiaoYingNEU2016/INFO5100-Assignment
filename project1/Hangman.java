import java.util.*;

public class Hangman {
	String[] words = new String[4];
	ArrayList<Character> correctList = new ArrayList<Character>();
	ArrayList<Character> wrongList = new ArrayList<Character>();
	String[] display;
	char[] gameLetter;
	
	
	public Hangman(String[] words){  // Initialises the words list.
		this.words = words;
		
		chooseWord();
		
		gameLetter = chooseWord().toCharArray();
		
		display = new String[chooseWord().length()];		
		for(int i=0; i<chooseWord().length(); i++){
			display[i] = " _ ";
		}
		
		 StringBuffer sb = new StringBuffer();
		 for(int i = 0; i < display.length; i++)
		 { 
		    sb. append(display[i]);
		 }
		 String s = sb.toString();
		 System.out.println(s);
	}
	
	public String chooseWord(){   // Randomly chooses a word from the list.
		Random a = new Random();		
		
		int randomNumber = a.nextInt(words.length);
		
		String gameWord = words[randomNumber];
		
		return gameWord;
				
	}
	
	public boolean ifWrongListContain(char letter){
		if(wrongList.size()==0)
			return false;
		else
			for(int i=0; i<wrongList.size(); i++){
				if(wrongList.get(i)==letter)
					return true;
			}
		return false;
	}
	
	public char handleGuess(){   // handle the guess and add the letter to correctList or WrongList.
		
		System.out.print("Please enter a letter: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char letter = s.charAt(0);

		aa:for(int i=0; i<gameLetter.length; i++){
			if(letter == gameLetter[i]){
				correctList.add(letter);
				
				if(ifWrongListContain(letter)==true){
					for(int b=0, length=wrongList.size(); b<length; b++){
						if(wrongList.get(b)==letter)
				           wrongList.remove(b);
				           length--;
				           b--;
					}
				}
				break aa;
			}
			else{
				if(ifWrongListContain(letter)==true)
					continue aa;
				else
				    wrongList.add(letter);
			}
		}		
		return letter;		
				
	}
	
	public boolean gameWon(){  // return true if user wins the game.
	/*	if(correctList.size()==chooseWord().toCharArray().length){
			System.out.println("You win the Game!");
		    return true;
		}
		else
			return false;
    */
		ArrayList<Character> checkLetter = new ArrayList<Character>();
		
		for(int i=0; i<correctList.size(); i++){
			for(int j=0; j<gameLetter.length; j++){
				if(correctList.get(i)==gameLetter[j])
					checkLetter.add(gameLetter[j]);
			}
		}
		
		if(checkLetter.size()==gameLetter.length)
			return true;
		else return false;
	}
	
	public void gameOver(){  // exit the program after the game is over.
		if(wrongList.size()==8){
			System.out.println("The game is end");
			System.exit(0);}
		else if(gameWon()==true){
			System.out.println("You win the Game!");
			System.out.println("The game is end");
			System.exit(0);
		}
		else
			playGame();
		
	}
	public void printHangman(){  // print hangman after every guess.
		//System.out.println("0");
		
		if(wrongList.size()==0){
			System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_________________");
			System.out.println("");
		}
	    else if(wrongList.size()==1){
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_________________");
			System.out.println("");
	    }
	    else if(wrongList.size()==2){
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|          |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_________________");
			System.out.println("");
	    }
	    else if(wrongList.size()==3){
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|          |");
			System.out.println("|       ---");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_________________");
			System.out.println("");
	    }
	    else if(wrongList.size()==4){
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|          |");
			System.out.println("|       --- ---");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_________________");
			System.out.println("");
	    }
	    else if(wrongList.size()==5){
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|          |");
			System.out.println("|       --- ---");
			System.out.println("|         |");
			System.out.println("|         |");
			System.out.println("|");
			System.out.println("|_________________");
			System.out.println("");
	    }
	    else if(wrongList.size()==6){
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|          |");
			System.out.println("|       --- ---");
			System.out.println("|         | |");
			System.out.println("|         | | ");
			System.out.println("|");
			System.out.println("|_________________");
			System.out.println("");
	    }
	    else if(wrongList.size()==7){
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|          |");
			System.out.println("|       --- ---");
			System.out.println("|         | |");
			System.out.println("|         | | ");
			System.out.println("|        --");
			System.out.println("|_________________");
			System.out.println("");
	    }
	    else{
	    	System.out.println("___________");
			System.out.println("|          |");
			System.out.println("|          O");
			System.out.println("|          |");
			System.out.println("|       --- ---");
			System.out.println("|         | |");
			System.out.println("|         | | ");
			System.out.println("|        -- --");
			System.out.println("|_________________");
			System.out.println("");
	    }
	}
	
	public void playGame(){  // Starts the game.
		System.out.println(displayWord(handleGuess()));
		gameOver();
	}
	
	public String displayWord(char letter){  // display the correctly guessed letters and hide the remaining with dashes.
		String printWord;
		
		if(correctList.contains(letter)){
			for(int i=0; i<display.length; i++){
				if(gameLetter[i]==letter){
					display[i] = String.valueOf(gameLetter[i]);}
			}
		//    printWord = String.valueOf(display);
			 StringBuffer sb = new StringBuffer();
			 for(int i = 0; i < display.length; i++)
			 { 
			    sb. append(display[i]);
			 }
			 printWord = sb.toString();
		//	  printWord = Arrays.toString(display);
 		}
		else{
		//	printWord = String.valueOf(display);
		//	printWord = Arrays.toString(display);
			 StringBuffer sb = new StringBuffer();
			 for(int i = 0; i < display.length; i++)
			 { 
			    sb. append(display[i]);
			 }
			 printWord = sb.toString();
		}
		
		printHangman();
		
		return printWord;
	}
	
	public static void main(String[] args){
		String[] aa = {"haha","mama","baba","amy"};
		Hangman aaa = new Hangman(aa);
		aaa.playGame();
	}
}
