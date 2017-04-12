package student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


	public class Teacher 
	{
		String name;
		String facultyID;
		String Department;
		
		static String SessionStartDate;
		int totalAttendance;
		int WorkingDays;
		int AbsentDays;
		int LOAoff;
		int AttendedDays;
		String[] offDays=new String[AbsentDays];
		String[] LOAoffdays= new String[LOAoff];
		
		
		Scanner obj1=new Scanner(System.in);
		
		Teacher(String name, String facultyID, String Department)
		{
			this.name=name;
			this.facultyID=facultyID;
			this.Department=Department;
		}
		
		Teacher()
		{
			
		}
		
		public void getInfo()
		{
			name=obj1.nextLine();

		}
		
		
		public void display()
		{
			System.out.println("Faculty Name:"+name);
			System.out.println("-------------------------------------------");
		}
	}
		
		
		
