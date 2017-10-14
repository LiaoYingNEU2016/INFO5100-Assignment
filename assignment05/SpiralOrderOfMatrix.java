import java.util.*;

public class SpiralOrderOfMatrix {
	List<Integer> spiral = new ArrayList<Integer>();
	
	public static void main(String[] args){
		int[][] a = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
		int[][] b = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] c = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int[][] d = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		SpiralOrderOfMatrix aa = new SpiralOrderOfMatrix();
		System.out.print(aa.spiralOrder(a));
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {

        int m=0 ;
        int n=0 ;    
        int a =matrix.length;
        int b =matrix[0].length;
        int c=0;
        int d=1;
        int turn = 1;
        
        while(a>=1 && b>=1){
        	if(a==1&&b==1){  
        		spiral.add(matrix[m][n]);
        		b=-1;
         	   a=-1;
         	   turn = 100;
        	}
        	else if(a==1&&b>1){
        		for(int i=n ; i<matrix[0].length-c; i++){
                	   spiral.add(matrix[m][i]);
                	   b=-1;
                	   a=-1;
                	   turn = 100;
          	    }
        	}
        	else if(a>1&&b==1){     		
        		for(int j=m; j<matrix.length-d+1; j++){
            		spiral.add(matrix[j][n]);
            		a=-1;
            		b=-1;
            		turn = 100;
            	}
        	}
        	else{
        		
            if(turn == 1){
        	  if(b==matrix[0].length){
        		for(int i=n ; i<b; i++){
             	   spiral.add(matrix[m][i]);
             	   n++;
                } 
                m++;
                a--;
         	    turn = 2;	
        	    }
        	  else{
                  for(int i=n ; i<matrix[0].length-c; i++){
        	          spiral.add(matrix[m][i]);
        	          n++;
                  } 
                  m++;
                  a--;
    	          turn = 2;
        	  }
           }
            
           if(turn ==2){
        	
        	for(int j=m; j<matrix.length-d+1; j++){
        		spiral.add(matrix[j][n-1]);
        		m++;
        	}
        	n--;
        	b--;
        	turn = 3;
            	
           }
           
           if(turn == 3){
        	
              for(int x=n-1; x>=c; x--){
        		spiral.add(matrix[m-1][x]);
        		n--;
        	}
        	m--;
        	a--;
        	c++;
        	turn =4;
        	
            }
           
            if(turn==4){
        	        	
        	for(int y=m-1; y>=d; y--){
        		spiral.add(matrix[y][n]);
        		m--;
        	}
        	n++;
        	b--;
        	d++;
        	turn = 1;
        	}
        
        }
        
      
	}
        return spiral;
}
}
