
/**
 * This class will store the data of the student
 * 
 *
 * @author Gurleen kaur
 * @version (31 July 2024)
 */
public class Student
{
    // instance variables - Defining the fields for holding the information ofstudent
    private String firstName;
    private String lastName;
    private String stdID;
    private double marks1;
    private double marks2;
    private double marks3;
    double totalMarks;
    
    /**
     * Constructor for objects of class Student
     */
    public Student(String firstName,String lastName, String stdID, double marks1, double mark2, double mark3)
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName=lastName;
        this.stdID = stdID;
        this.marks1 = marks1;
        this.marks2 = mark2;
        this.marks3 = mark3;
        this.totalMarks = marks1 + mark2 + mark3;
    }
    /**
     * Override toString methods for displaying the information of the student in the console.
     */
    @Override
    public String toString()
    {
         return String.format("%-15s %-15s %-12s %-8.1f %-8.1f %-8.1f %-8.1f", firstName, lastName, stdID, marks1, marks2, marks3, totalMarks);
    }
    
}
