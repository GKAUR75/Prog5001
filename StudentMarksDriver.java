import java.io.IOException;
import java.util.Scanner;
/**
 * This class is created for the menu 
 * it will display as menu as per requirments
 * 
 *
 * @author Gurleen kaur
 * @version (2 August 2024)
 */
public class StudentMarksDriver
{
    public static void main(String[] args) {
        StudentMarksProcessor processor = new StudentMarksProcessor();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            processor.readInputFromFile(fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("\n----------- Welcome Menu -----------------------------------------");
            System.out.println("1. Compute and print student-wise marks");
            System.out.println("2. Filter and print students below a threshold");
            System.out.println("3. Sort and print top 5 highest and lowest marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    processor.computeAndPrintStudentMarks();
                    break;
                case 2:
                    System.out.print("Enter the threshold: ");
                    int threshold = scanner.nextInt();
                    processor.printFilteredStudentsBelowThreshold(threshold);
                    break;
                case 3:
                    processor.sortAndPrintTopStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
