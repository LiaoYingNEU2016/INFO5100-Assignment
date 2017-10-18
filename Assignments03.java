import java.lang.reflect.Array;
import java.util.Arrays;


/*Question 1
 * 
 * The main problem is that this class has two constructor with the same type 'int' of parameter. This is not allowed. System can not know which constructor is called. 
 *
 * 'super();' should be deleted from the second method 
 * Because 'super()' means to inherit from it's superclass, but this class does not have a superclass 
 * 
 * 
public class Book{
	 int size;
	 int price;
	 String name;
	 public Book(int size){
	 this.size = size;
	 }
	 public Book(int size, int price, String name){
	 super();
	 this.size = size;
	 this.price = price;
	 this.name = name;
	 }
	 public Book(int price){
	 this.price = price;
	 }
	 // Missing return type here
	 public setName(String name){
	 return name;
	 }
	}
	
*/


/*Question 2
 * 
 * 'void getTime()' should be changed to 'String getTime()'
 *  Because this method should return time. If it is 'void' it can not return anything.
 *  So void should be changed to the type String it returns.
 * 
class Clock{
 String time;
 void getTime(){
 return time;
 }
 void setTime(String t){
 time = t ;
 }
}
	
*/




/* Test Question 3 4 5
 * 
public class Assignments03 {
    public static void main(String[] args){
    	
    	NoVowels s = new NoVowels();
     	System.out.println(s.removeVowelsFromString("apple"));
     	
    	Anagrams a = new Anagrams();
    	System.out.println(a.checkIfTwoStringsAreAnagrams("elapp", "apple"));
    	
    	Calculator cal = new Calculator();
    	cal.printResult(cal.quadratic(1, 1, -6));
    	
    }
}
*/



//3.Write a Java function to remove vowels in a string.

class NoVowels{
	
	public String removeVowelsFromString(String input){
		
		char[] letter = input.toCharArray();
		char[] noVowels = new char[input.length()] ;
		int j=0;
		
		for (int i=0; i<letter.length; i++){
			// Consider the test case of UpperCase vowels
			if(letter[i]!='a'&&letter[i]!='e'&&letter[i]!='i'&&letter[i]!='o'&&letter[i]!='u'){		
				noVowels[j]=letter[i];
				j++;
			}
		}
		// Wrong result, result will have the same length with input
		String result = String.valueOf(noVowels) ;
		return result;
	}
}



//4.Write a java function to check if two strings are Anagrams or not.

class Anagrams{

	public boolean checkIfTwoStringsAreAnagrams(String s1, String s2){
		
		char[] first = s1.toCharArray();
		char[] second = s2.toCharArray();
		
		if(first.length!=second.length)
			return false;
		// Always using blocks{}, to prevent confusing and coding error
		else
		    Arrays.sort(first);
		    Arrays.sort(second);
		
		    for(int i=0; i<first.length; i++){
			    if(first[i]!=second[i])
				    return false;
		    }
		    return true;
		
	}
}



//5.Create a calculator that can perform the following features. 

class Calculator{
	
	public double addition(double a, double b){
		
		double add;
		
		add = a+b;
		return add;		
	}
	
	public double subtraction(double a, double b){
		
		double sub;
		
		sub = a-b;
		return sub;
	}
	
	public double multiplication(double a, double b){
		
		double mul;
		
		mul = a*b;
		return mul;
	}
	
	public double division(double a, double b){
		
		double di;
		
		di = a/b;
		return di;
	}
	
	public double squareRoot(double a){
		
		double sRoot;
		
		sRoot = Math.sqrt(a);
		return sRoot;
	}
	
	public double square(double a){
		
		double squ;
		
		squ = a*a;
		return squ;
	}
	
	public double cube(double a){
		
		double cube;
		
		cube = a*a*a;
		return cube;
	}
	
	public double FToC(double a){
		
		double ftoc;
		
		ftoc = (a-32)/1.8;
		return ftoc;
	}
	
	public double CToF(double a){
		
		double ctof;
		
		ctof = a*1.8 + 32;
		return ctof;
	}

	public double feetToInches(double a){
		
		double feetToInches;
		
		feetToInches = a*12;
		return feetToInches;
	}
	
	public double inchesToFeet(double a){
		
		double inchesToFeet;
		
		inchesToFeet = a/12;
		return inchesToFeet;
	}
	
	public double[] quadratic(double a, double b, double c){
		
		double[] x= new double[2];
		double n;
		
		if(a==0)
		   return null;
		
		else			
			n = b*b - 4*a*c;
		
		    if(n<0){
		    	System.out.println("There is no real root");
		        return null;
		    }
		    else if(n==0){
		    	x[0] = x[1] = (-b)/(2*a);
		    	return x;		    	
		    }	
		    else{
		    	x[0] = ((-b)+Math.sqrt(n))/(2*a);
		    	x[1] = ((-b)-Math.sqrt(n))/(2*a);
		    	return x;
		    }
	}
	
	public void printResult(double[] a){
		
		for(int i=0; i<a.length; i++){
			System.out.println("x="+a[i]+"");
		}
	}
}



