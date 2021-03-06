import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SCRAMEApp
{
	public static void main(String args[]) throws IOException
	{

		String filename = "Students.txt";
		String filename2 = "Courses.txt";
		StudentDB students = new StudentDB();
		students.readStudents(filename);
		CourseDB courses = new CourseDB();
		courses.readCourses(filename2);

		System.out.println("Welcome to SCRAME");
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		do
		{
			printMenu();
			
			// TO-DO: place this do-while loop in a method
			do
			{
				System.out.println("Select an option:");
				
				if(sc.hasNextInt())
					choice = sc.nextInt();
			} while(choice < 1 || choice > 11);
			
			switch (choice)
			{
				case 1:
					// Error check
					System.out.println("Enter the name of the student: ");
					String name = sc.next();
					Pattern p = Pattern.compile("^[ A-Za-z]+$");
					Matcher m = p.matcher(name);
					boolean b = m.matches();
					if (!b)
					{
						System.out.println("Error! Please enter only letters and spaces.");
						break;
					}
					// Error check
					System.out.println("Enter the student's ID: ");
					String matriculationNumber = sc.next();
					Student student = new Student(name, matriculationNumber);
					students.addStudent(student);
					//students.saveStudents("Students.txt");

					System.out.println("List of all students:");
					students.printStudentList();
					break;
				case 2:
					break;
				case 3:

				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				default:
					break;
			}
			

		} while (choice != 11);
		
		sc.close();
	}
	
	public static void printMenu()
	{
		System.out.println(	"Select an option:\n" +
							"1.  Add a student\n" +
							"2.  Add a course\n" + 
							"3.  Register student for a course (this include registering for Tutorial/Lab classes)\n" + 
							"4.  Check available slot in a class (vacancy in a class)\n" + 
							"5.  Print student list by lecture, tutorial or laboratory session for a course.\n" + 
							"6.  Enter course assessment components weightage\n" + 
							"7.  Enter coursework mark � inclusive of its components.\n" + 
							"8.  Enter exam mark\n" + 
							"9.  Print course statistics\n" + 
							"10. Print student transcript.\n" +
							"11. Quit");
	}
}
