//1. Write a java function to calculate the salary of an employee based on the following rules.

class Salary {
      
	 static double hours;
	 static double salary;
	 static double rate=15;
	 
/*	public static void main(String[] args){
		System.out.print(Salary.employeeSalary(42));				
	}	 
*/
	 
	 public static double employeeSalary(double hours){
		 if(hours<=36){
			 salary=hours*rate;
			 return salary;
		 }
		 else if(hours<=41){
			 salary=36*rate+(hours-36)*rate*1.5;
			 return salary;
		 }
		 else if(hours<=48){
			 salary=36*rate+5*rate*1.5+(hours-41)*rate*2;
			 return salary;
		 }
		 else{
			 System.out.println("illegal work time!");
			 return 0;
		 }
	 }
}




//2. Write a java function that adds all the digits of an integer until it is single digit.

class Number{
	
	 static int input;
	 static int digit;
	 static int sum;
	  
/*	public static void main(String[] args){
		System.out.print(Number.addDigits(23));				
	}	 
*/
	 
	 public static int addDigits(int input){
		 while(input>0){
			  digit = input%10;
			  input = input/10;
			  sum = sum+digit;		
	  }
	     return sum;

	 }
}
	



//3. Write a java function to print all perfect number between 1 and n.
	 
class PerfectNumber{
	   
	 int n;
	 static int sum;
	 
/*	public static void main(String[] args){
		PerfectNumber.printPerfectNumber(7);				
	}
*/
	  
	 public static void printPerfectNumber(int n){
		  for(int i=2; i<n; i++){
			  for(int j=1; j<i; j++){	
			  if(i%j==0){
				  sum=sum+j;
			  }
			  }
			  
			  if(sum==i){
				 System.out.println("Perfect Number:"+i); 
			  }
		  }
		  
	 }
}



//4.Write a java class called pizza

class Pizza{
	
	String pizzaType;
    double unitPrice;
	double loyaltyPoints;
	
	
	public Pizza(String pizzaType, double unitPrice, double loyaltyPoints){
		this.pizzaType = pizzaType;
		this.unitPrice = unitPrice;
		this.loyaltyPoints = loyaltyPoints;
	}
	
	public Pizza(){
		pizzaType = "normal";
		unitPrice = 10.5;
		loyaltyPoints = 0;
	}
}



//5. Write a java class called customer 

class Customer{
	
	String customerName;
	double pizzaNumber;
	static double sum;
	
	public Customer(String customerName, double pizzaNumber){
		this.customerName = customerName;
		this.pizzaNumber = pizzaNumber;
	}
	
	
	public static void main(String[] args){
		Pizza orderedPizza = new Pizza("original cheese", 10.5, 10.5);
		Customer amy = new Customer("Amy", 2);
		
		sum = orderedPizza.unitPrice * amy.pizzaNumber;
		System.out.println(amy.customerName+" you need to pay "+ sum);
		
	}
		
}
	


//6. Write a Java program that generates an isosceles right angled triangle made of asterisks. 

class Triangle{

	int n;
	
/*	public static void main(String[] args){
		Triangle.printIsoscelesTriangle(6);
				
	}
*/
	
	public static void printIsoscelesTriangle(int n){
		for(int i=1; i<n; i++){
			for(int j=1; j<i+1; j++){
				if(j==1 || j==i){
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}	
			}
			System.out.println(" ");
		}
		for(int i=1; i<n+1; i++){
			System.out.print("*");
		}
	}
}
	
	
	





