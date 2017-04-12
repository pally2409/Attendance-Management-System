package student;

import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student implements Attendance
{
	public String name;
	public int rollno;
	public String DateOfBirth;
	public int Semester;
	public String stream;
	public double []totalAttendance=new double[6];
	public int []WorkingDays=new int[6];
	int []AbsentDays=new int[6];
	int []LOAoff=new int[6];
	int []AttendedDays=new int[6];
	String []subjects=new String[6];
	Teacher[] t;
	Date dob=new Date();
	int numos;
	
	Scanner obj2=new Scanner(System.in);

	public void getInfo() throws Exception
	{
		System.out.println("Enter the name of the student:");
        name=obj2.nextLine();
        if(name.matches(".*\\d.*"))
        {
        	try
        	{
        		throw new DataException("Please enter a valid name");
        	}
        	catch(DataException e)
        	{
        		System.out.println(e);
        		throw e;
        	}
        }
        
		System.out.println("Enter the date of birth");
		try
		{
		dob.getDate();
		}
		catch(DataException e)
		{
			return;
		}
		System.out.println("Enter the RollNo:");
		try
		{
		rollno=obj2.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid rollno");
			throw e;
		}
		System.out.println("Enter the semester:");
	    Semester=obj2.nextInt();
	    if(Semester>8)
	    {
	    	try
	    	{
	    		throw new DataException("Please enter a valid semester");
	    	}
	    	catch(DataException e)
	    	{
	    		System.out.println(e);
                throw e;
	    	}
	    }
	    System.out.println("Enter the stream:");
	    
	    stream=obj2.next();
	    if(stream.matches(".*\\d.*"))
        {
        	try
        	{
        		throw new DataException("Please enter a valid name");
        	}
        	catch(DataException e)
        	{
        		System.out.println(e);
                throw e;
        	}
        }
	    
	    System.out.println("Enter number of subjects");
	    numos=obj2.nextInt();
	}
	
     public void displayprofile()
     {
    	 System.out.println("-------------------------------------------");
    	 System.out.println("Name:"+name); 
    	 System.out.println("Date Of Birth:"+dob.dd+"/"+dob.mm+"/"+dob.yyyy);
    	 System.out.println("RollNo:"+rollno);
    	 System.out.println("Semester:"+Semester);
    	 System.out.println("Stream:"+stream);
    	 System.out.println("-------------------------------------------");
    }
     
    public void enterSubjects()
    {
    	System.out.println("Enter the subjects");
    	for(int i=0;i<numos;i++)
    	{
    		System.out.println("Subject: ");
    		subjects[i]=obj2.next();
    		System.out.println("Enter the teacher for "+subjects[i]);
    		t[i]=new Teacher();
    		t[i].getInfo();
    	}
    	displaysubjects();
    	
    }
    
    public void displaysubjects()
    {
    	for(int i=0;i<numos;i++)
    	{
    		System.out.println(i+1+ ". Subject: "+subjects[i]);
    		t[i].display();
    	}
    }
    
    public void CalculateAttendance()
    {
    	for(int i=0;i<numos;i++)
    	{
    		System.out.println("Enter total classes held in "+subjects[i]);
    		WorkingDays[i]=obj2.nextInt();
    		System.out.println("Enter classes missed in "+subjects[i]);
    		AbsentDays[i]=obj2.nextInt();
    		AttendedDays[i]=WorkingDays[i]-AbsentDays[i];
    	    System.out.println("Enter any leave of absence "+subjects[i]);
    	    LOAoff[i]=obj2.nextInt();
    	    totalAttendance[i]=TotalAttendance(WorkingDays[i],AttendedDays[i],LOAoff[i]);
    	    
    	}
    }
    
    public double TotalAttendance(int WorkingDays, int AttendedDays, int LeaveOfAbsence)
    {
    	
    	double total=((double)AttendedDays/(WorkingDays-LeaveOfAbsence))*100;
    	
    	return total;
    }
	
    public void DisplayAttendance()
	{
		System.out.println("-------------------------------------------------------------------------------------------------------------------");

		System.out.printf("%10s %30s %20s %30s %15s", "SUBJECT", "WORKING DAYS", "DAYS MISSED", "LEAVE OF ABSENCE", "ATTENDANCE");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<numos;i++)
		{
		System.out.println();
		System.out.format("%10s %30d %20d %30d %15.2f", subjects[i], WorkingDays[i], AbsentDays[i], LOAoff[i], totalAttendance[i]);
		}
		System.out.println();
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
              

	}
    
    public void UpdateAttendance()
	{
    	for(int i=0;i<numos;i++)
    	{
    		System.out.println("Enter the number of classes to add in "+subjects[i]);
    		int a=obj2.nextInt();
    		WorkingDays[i]=WorkingDays[i]+a;
    		System.out.println("Enter the number of classes missed in"+subjects[i]);
    		int b=obj2.nextInt();
    		AbsentDays[i]=AbsentDays[i]+b;
    		System.out.println("Enter the absent days to be shifted to leave of absence");
    		int c=obj2.nextInt();
    		LOAoff[i]=LOAoff[i]+b;
    		AbsentDays[i]=AbsentDays[i]-a;
    		totalAttendance[i]=TotalAttendance(WorkingDays[i],AbsentDays[i],LOAoff[i]);
    		if(totalAttendance[i]>100)
    		{
    			try
    			{
    				throw new DataException("Attedance invalid. Please recheck your data");
    			}
    			catch(DataException e)
    			{
    				System.out.println(e);
    			}
    		}
    	}
    	
	}
	
	public void displayStatus()
	{
		
		for(int i=0;i<numos;i++)
		{
			int a=WorkingDays[i]+1;
			int b=AttendedDays[i]+1;
		if(totalAttendance[i]<70)
		{
			System.out.println("You have short attendance in "+subjects[i]);
			double check=totalAttendance[i];
			int count=0;
			while(check<70)
			{
				
				a++;
				b++;
				check=((double)b/(a-LOAoff[i]))*100;
				count++;
			}
			
			System.out.println("As of now you must hold "+count+" classes in "+subjects[i]+"to fulfill attendance criteria");
		}
		
		else
		{
			System.out.println("You fulfill attendance criteria in "+subjects[i]);
		}
	}
	}
}

class Date
{
	int dd;
	int mm;
	int yyyy;
	Scanner d=new Scanner(System.in);
	
	public void getDate() throws DataException
	{
		System.out.println("Day:");
		dd=d.nextInt();
		if(dd>31)
		{
			try
			{
				throw new DataException("Please enter a valid date");
			}
			catch(DataException e)
			{
				System.out.println(e);
				throw e;
			}
		}
		System.out.println("Month:");
		mm=d.nextInt();
		if(mm>12)
		{
			try
			{
				throw new DataException("Please enter a valid month");
			}
			catch(DataException e)
			{
				System.out.println(e);
				throw e;
			}
		}
		System.out.println("Year:");
		yyyy=d.nextInt();
		
	}
}

class DataException extends Exception
{
	String str1;
	DataException(String str2)
	{
		str1=str2;
	}
	
	public String toString()
	{
		return(str1); 
	}
}


