
import java.io.*;
import java.util.Scanner;
public class basic1 {
   	public static void main(String args[]){
   		Scanner scan = new Scanner(System.in) ;
   		System.out.println("Conversion of time:");
   		System.out.println("Enter the time in 12 hour format or  24 hour format (hh:mm:ss am or pm): ");
      String time = scan.next();
      String listTime[] = time.split(":");
      String hour = listTime[0];
      String min = listTime[1];
      String sec = listTime[2].substring(0,2);
      String amorpm = listTime[2].substring(2,4);
      
      if(amorpm.equals("AM")){          
      		if(hour.equals("12")){
      			hour = "00";
      	   
      		}
      	 
   	}
      else{
    	  int h =0;
		if(!hour.equals(12))
    		 h = Integer.parseInt(hour);
    	       h = h+12;
    	     hour =""+h;		   
            
      }
      
      System.out.print(hour+":"+min+":"+sec);
    	}
}
