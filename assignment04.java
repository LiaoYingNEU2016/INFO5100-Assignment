import java.util.ArrayList;
import java.util.*;


public class assignment04 {
	
	public static void main(String args[]){
	
	//test Question 3
		 IpAddress ip = new IpAddress("216.27.6.136");
		 System.out.println(ip.getDottedDecimal());
		 System.out.println(ip.getOctet(4));
		 System.out.println(ip.getOctet(1));
		 System.out.println(ip.getOctet(3));
		 System.out.println(ip.getOctet(2));
		
		
    //test Question 1
	    Key aa = new Key();
		System.out.println(aa.licenceKey("2-4A0r7-4k", 4));
		
	//test Question 5	
		RomanNumeral bb = new RomanNumeral();
		System.out.println(bb.intToRoman(123));
	
	//test Extra Question 1
		FindMedian cc = new FindMedian();
		int[] a = {1,3,12,20,30};
		int[] b = {6,18,22};
		System.out.println(cc.findMedianSortedArrays(a,b));
		
   }

}

//Question 1 software license key

class Key{
	
	public String licenceKey(String oldString, int k){
		
		char[] old = oldString.toCharArray();
		ArrayList<Character> list = new ArrayList<Character>();
		
		for(int i=0; i<old.length; i++){
			if(old[i]!='-')
				list.add(old[i]);			  
		}
		
		int n = list.size()/k;
		int m = list.size()%k;
		
		if(m==0){
			for(int i=0; i<n-1; i++){
				list.add(k+i*(k+1), '-');
			}
		}
		else{
			for(int i=0; i<n; i++){
				list.add(m+i*(k+1), '-');
			}
		}
		
		char[] newChar =  new char[list.size()];
		for(int i=0; i<list.size(); i++){
			newChar[i] = list.get(i);			
		}
		
		String newKey = new String(newChar);
		return newKey;
		
	}	
}


//Question 2  RockPaperScissorsGame


abstract class Tool{
	
	protected int strength;
	protected char type;	
	
	Tool(int strength){
		setStrength(strength);
	}
	
	public void setStrength(int strength){
		this.strength = strength;		
	}
	
	public abstract boolean fight(Tool tool);
		
	
	
}

class Rock extends Tool{
	
	Rock(int strength){
		super(strength);
		type = 'r';
	}
	
	public boolean fight(Tool tool){

		if(tool.type=='s')
			strength = 2*strength;		
		else
			strength = strength/2;	 
		
		if(tool.strength>strength)
			return false;
		else
			return true;
					
	}
}
	

class Paper extends Tool{
	
	Paper(int strength){
		super(strength);
		type = 'p';
	}
	
	public boolean fight(Tool tool){

		if(tool.type=='r')
			strength = 2*strength;		
		else
			strength = strength/2;	 
		
		if(tool.strength>strength)
			return false;
		else
			return true;	    
	}
	
}

class Scissors extends Tool{
	
	Scissors(int strength){
		super(strength);
		type = 's';
	}
	
	public boolean fight(Tool tool){

		if(tool.type=='p')
			strength = 2*strength;		
		else
			strength = strength/2;	 
		
		if(tool.strength>strength)
			return false;
		else
			return true;	    
	}
	
}


class RockPaperScissorsGame{
	 public static void main(String args[]){
	 Scissors s = new Scissors(5);
	 Paper p = new Paper(7);
	 Rock r = new Rock(15);
	 System.out.println(s.fight(p) + " , "+ p.fight(s) );
	 System.out.println(p.fight(r) + " , "+ r.fight(p) );
	 System.out.println(r.fight(s) + " , "+ s.fight(r) );
	 }
	}



//Question 3  Internet protocol (IP) address

class IpAddress{
	
	private String dottedDecimal;
	private int firstOctet,  secondOctet,  thirdOctet,  forthOctet;
	
	IpAddress(String dottedDecimal){
		this.dottedDecimal = dottedDecimal;
		
		 String[] octet = dottedDecimal.split("\\.");
			
	     firstOctet = Integer.parseInt(octet[0]);
		 secondOctet = Integer.parseInt(octet[1]);
	     thirdOctet = Integer.parseInt(octet[2]);
	     forthOctet = Integer.parseInt(octet[3]);
		
	}
	
	public String getDottedDecimal(){
		return dottedDecimal;
	}
	
	public int getOctet(int i){
       		
		int[] number = new int[5];
		number[0] = 0;
		number[1] = firstOctet;
		number[2] = secondOctet;
		number[3] = thirdOctet;
		number[4] = forthOctet;
		return number[i];
	}
	
}
 

//Question 4  registration system of courses for students


class Student{
	private String name;
	private String id;
	
	Student(String name, String id){
		this.name = name;
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getId(){
		return id;
	}	
	
	public String toString(){
		return "Student Name : " + name + " "+ "Student ID : " + id;
	}
	
}


class Course{
	private String courseName;
	private int numberOfStudent;
	private Student[] students = new Student[10];
	
	Course(String courseName){
		this.courseName = courseName;
	}
	
	public Student[] getStudents(){
		return students;	
	}
	
	public void printStudents(Student[] students){
		for(int i=0; i<students.length; i++){
			System.out.println(students[i]+" ");
		}
	}
	
	public int getNumberOfStudent(){
		return numberOfStudent;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public boolean isFull(){
		if(numberOfStudent >= 10)
			return true;
		else
		    return false;
	}
	
	public void registerStudent(Student student){
		if(isFull()==false)
			students[numberOfStudent] = student;
		    numberOfStudent++;
	}
	
}


class Test{
	public static void main(String[] args){
		Student amy = new Student("Amy","001");
		Course java = new Course("Java");
		
		java.registerStudent(amy);
		java.printStudents(java.getStudents());
		


	}
}



//5. Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999. 

class RomanNumeral{
	
	public String intToRoman(int num) {
		
		String digit[] = {"", "I", "II", "III", "IV", "V", "VI", "VII",  
                "VIII", "IX"};  
        String ten[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX",  
                "XC"};  
        String hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC",  
                "DCCC", "CM"};  
        String thousand[] = {"", "M", "MM", "MMM"};
        
        int a = num%10;
        int b = num%100/10;
        int c = num%1000/100;
        int d = num%10000/1000;
        
        return thousand[d]+hundred[c]+ten[b]+digit[a];
				
	 }
}

//Extra Credit Question 1  Find the median of the two sorted arrays. 


class FindMedian{
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m = nums1.length;
		int n = nums2.length;
		double mid1,mid2;
		
		if(m==0 || n==0)
			return -1;
		if(m==1 && n==1)
			return (nums1[0] + nums2[0])/2;
		if(m==2 && n==1)
			if(nums2[0]<nums1[0] && nums2[0]<nums1[1])
				return nums1[0];
			else if(nums2[0]>nums1[0] && nums2[0]<nums1[1])
				return nums2[0];
			else
				return nums1[1];
		if(m==1 && n==2)
			if(nums1[0]<nums2[0] && nums1[0]<nums2[1])
				return nums2[0];
			else if(nums1[0]>nums2[0] && nums1[0]<nums2[1])
				return nums1[0];
			else
				return nums2[1];
		if(m==2 && n==2)
			return (Math.max(nums1[0], nums2[0]) + Math.min(nums1[1], nums2[1])) / 2;
		    
		
	    if(m%2==0)
	    	mid1 = (nums1[m/2]+nums1[(m/2)-1])/2;
	    else
	    	mid1 = nums1[(m-1)/2];
	    
	    if(n%2==0)
	    	mid2 = (nums2[n/2]+nums2[(n/2)-1])/2;
	    else
	    	mid2 = nums2[(n-1)/2];
	    
	    
	    if(mid1 == mid2)
	    	return mid1;
	    else if(mid1 > mid2)
	    	if (m%2==0 && n%2==0)
	    	    return findMedianSortedArrays(Arrays.copyOfRange(nums1, 0, m/2), Arrays.copyOfRange(nums2, (n/2)-1, n));
	    	else if (m%2!=0 && n%2==0)
	    		return findMedianSortedArrays(Arrays.copyOfRange(nums1, 0, (m-1)/2+1), Arrays.copyOfRange(nums2, (n/2)-1 , n));
	    	else if (m%2==0 && n%2!=0)
	    		return findMedianSortedArrays(Arrays.copyOfRange(nums1, 0, m/2), Arrays.copyOfRange(nums2, (n-1)/2, n));
	    	else 
	    		return findMedianSortedArrays(Arrays.copyOfRange(nums1, 0, (m-1)/2+1), Arrays.copyOfRange(nums2, (n-1)/2, n));
	     else
	    	 if (m%2==0 && n%2==0)
		    	    return findMedianSortedArrays(Arrays.copyOfRange(nums1, (m/2)-1, m), Arrays.copyOfRange(nums2, 0, n/2));
		     else if (m%2!=0 && n%2==0)
		    		return findMedianSortedArrays(Arrays.copyOfRange(nums1, (m-1)/2, m), Arrays.copyOfRange(nums2, 0, n/2));
		     else if (m%2==0 && n%2!=0)
		    		return findMedianSortedArrays(Arrays.copyOfRange(nums1,(m/2)-1, m), Arrays.copyOfRange(nums2, 0, (n-1)/2+1));
		     else 
		    		return findMedianSortedArrays(Arrays.copyOfRange(nums1, (m-1)/2, m), Arrays.copyOfRange(nums2, 0, (n-1)/2+1)); 
	   
	}
}


