package Main;
import java.util.InputMismatchException;
import java.util.Scanner;

import student.*;

public class Main {
	static int i;
	static int counter;
	Main()
	{
		i++;
		counter++;
	}
	static String password="teacherxyz";
	Scanner obj=new Scanner(System.in);
	public static boolean CheckPasssword(String pass)
	{
		boolean x=pass.equals(password);
		if(x==true)
		{
			System.out.println("Password Correct");
			System.out.println("You may now proceed");
		}
		
		else if (x==false)
		{
			System.out.println("Password Incorrect!");
		}
		
		return x;
		
	}
	
	public static void UpdatePassword()
	{
		Scanner obj3=new Scanner(System.in);
		System.out.println("Enter old password");
		String OldPass=obj3.nextLine();
		boolean x=OldPass.equals(password);
		if(x==true)
		{
			System.out.println("Enter new password:");
			String NewPass=obj3.nextLine();
			password=NewPass;
		}
		
		else
		{
			System.out.println("Old password incorrect. Please check.");
		}
	}


	public static void main(String[] args)
	{
		//int counter=0;
		Scanner obj2=new Scanner(System.in);
		Student[] s=new Student[100];
		
		

		while(true)
		{
		System.out.println("Enter the operation you'd like to proceed with:");
		System.out.println("1.Display student attendance");
		System.out.println("2.Add student record");
		System.out.println("3.Update attendance");
		System.out.println("4.Update password");
		
		int x=obj2.nextInt();
		int y;
		switch(x)
		{
		case 1: System.out.println("Enter the RollNo of the student");
		int srch=0;
		try
		{
	        srch=obj2.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid rollno");
		}
	           
	          try
	          {
	        	  int count=0;
	          
	    		for(int z=0;z<counter;z++)
	    		{
	    	
	    			if(s[z].rollno==srch)
	    			{
	    				s[z].displayprofile();
	    				s[z].DisplayAttendance();
	    				s[z].displayStatus();
	    				count=1;
	    			}
	    			
	    			else
	    			{
	    				count=0;
	    			}
	    		}
	    		
	    		if(count==0)
	    		{
	    			System.out.println("Record not found!");
	    		}
	          }catch(Exception e)
	          {
	        	  break;
	          }
	            
	            break;
		case 2: s[i]=new Student();
		counter++;
		try
		{
		s[i].getInfo();
		}
		catch(Exception e)
		{
			break;
		}
		s[i].enterSubjects();
		s[i].CalculateAttendance();
		break;
		case 3: System.out.println("Enter the password:");
		String pass=obj2.next();
	
		boolean chk=Main.CheckPasssword(pass);
			if(chk==true)
			{
				System.out.println("Enter the RollNo of the student to update password");
				int srch1=obj2.nextInt();
				int count1=0;
	    		for(int z=0;z<counter;z++)
	    		{
	    	
	    			if(s[z].rollno==srch1)
	    			{
	    				s[z].UpdateAttendance();
	    				count1=1;
	    			}
	    			
	    			else
	    			{
	    				count1=0;
	    			}
	    		}
	    		
	    		if(count1==0)
	    		{
	    			System.out.println("Record not found!");
	    		}
			}
			
			else
			{
				System.out.println("Sorry, you're not permitted to update attendance");
			}
		break;
		case 4: Main.UpdatePassword();
		break;
		}
		
		
		}
		
	    
	}
}
	
    	

