import java.util.*;

public class DessertShoppeCheckOutSystem {
	
	public static void main(String[] args) {
		 
        checkout checkout = new checkout();

        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
        
        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
        System.out.println(checkout);
        
        checkout.clear();
        
        checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel", 50));
        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
        checkout.enterItem(new Candy("Candy Corn", 3.0, 109));

        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
        System.out.println(checkout);
        
}
}

abstract class DessertItem{
	String name;
	
	public DessertItem(){		
	}
	
	public DessertItem(String name){
		this.name = name;
	}
	public final String getName(){
		return name;
	}
	public abstract int getCost();
}


class Candy extends DessertItem{
	double weight;
	int pricePerPound;
	
	public Candy(String name, double weight, int pricePerPound){
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;	
	}
	
	public int getCost(){
		int cost = (int) (weight * pricePerPound);
		return cost;
	}
	
	public String toString(){
		String printName = String.format("%-30s", name);
		
		return weight + " @ " + pricePerPound + "\n" + printName + DessertShoppe.cents2dollarsAndCents(getCost()) + "\n";
	}
	
}

class Cookie extends DessertItem{
	int number;
	int pricePerDozen;
	
	public Cookie(String name, int number, int pricePerDozen){
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;	
	}
	
	public int getCost(){
		double numberOfDozen = (double)number/(double)12;
		int cost = (int) (numberOfDozen * pricePerDozen);
		return cost;
	}
	
	public String toString(){
		String printName = String.format("%-30s", name);
		
		return number + " @ " + pricePerDozen + "\n" + printName + DessertShoppe.cents2dollarsAndCents(getCost())+ "\n";
	}
}


class IceCream extends DessertItem{
	int iceCreamCost;
	
	public IceCream(String name, int iceCreamCost){
		super(name);
		this.iceCreamCost = iceCreamCost;		
	}
	
	public int getCost(){
		return iceCreamCost;
	}
	
	public String toString(){
		String printName = String.format("%-30s", name);
		
		return  printName + DessertShoppe.cents2dollarsAndCents(getCost())+ "\n";
	}
}

class Sundae extends IceCream{
	String topping;
	int toppingCost;
	
	public Sundae(String name, int iceCreamCost, String topping, int toppingCost){
		super(name, iceCreamCost);
		this.topping = topping;		
		this.toppingCost = toppingCost;
	}
	
	public int getCost(){
	    int cost = iceCreamCost + toppingCost;
	    return cost;
	}
	
	public String toString(){
		String printName = String.format("%-30s", name+" with");
		String printTopping = String.format("%-30s", topping);
		return printName + "\n" + printTopping + DessertShoppe.cents2dollarsAndCents(getCost())+ "\n";
	}
	
}




class DessertShoppe{
	public static String name = "M & M Dessert Shoppe";
	public static double taxRate = 0.02;
	public static int maxSizeOfItemName = 20;
	public static int widthDisplayCost = 15;

	//set sizes for receipt
	
	public static String cents2dollarsAndCents(int cent){
		double dollarAndCents = (double)cent/(double)100;
		String printdollarAndCents = String.format("% 6.2f", dollarAndCents);
        if(dollarAndCents<1){
        	printdollarAndCents = printdollarAndCents.replace('0', ' ');
        }
		return printdollarAndCents;
	}
}




class checkout{
	ArrayList<DessertItem> dessert = new ArrayList<DessertItem>();
	
	public checkout(){
		
	}
	
	public int numberOfItems(){ 
		int itemsNumber = dessert.size();
		return itemsNumber;
	}
	
	public void enterItem(DessertItem item){
		dessert.add(item);
	}
	
	public void clear(){
		dessert.clear();
	}
	
	public int totalCost(){
		int totalCostCents = 0;
		
		for(int i=0; i<numberOfItems(); i++){
			totalCostCents = totalCostCents + dessert.get(i).getCost();
		}
		
		
		return totalCostCents;
	}
	
	public int totalTax(){
		int totalTaxCents = (int) (totalCost() * DessertShoppe.taxRate) ;
		
		return totalTaxCents;
	}
	
	
	
	public String toString(){
		DessertItem[] stringItems = new DessertItem[numberOfItems()];
		for(int j = 0; j < stringItems.length; j++){
			stringItems[j] = dessert.get(j);
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < stringItems.length; i++)
		{ 
		    sb. append(stringItems[i]);
		}
		String s = sb.toString();
		
	
		
		return "       "+ DessertShoppe.name + "\n" + "       " +"--------------------" + "\n" + "\n"
	           + s + "\n" + "\n"
		       + String.format("%-30s", "Tax") + DessertShoppe.cents2dollarsAndCents(totalTax()) + "\n" 
	           + String.format("%-30s", "Total Cost") + DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax());
	}
		
	
}