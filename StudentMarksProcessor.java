import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads student marks information from a file, calculates the total marks of the students,
 * filters out students below a threshold, and sorts the students by their marks.
 *
 * Author: Gurleen Kaur
 * Version: 31 July 2024
 */
public class StudentMarksProcessor {
    List<Student> studentsList = new ArrayList<>();
    String unitName;

    /**
     * Reads student data from a CSV file.
     *
     * @param fileName the name of the file to read from
     * @throws IOException if an I/O error occurs
     */
    public void readInputFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        // Read the unit name
        if ((line = br.readLine()) != null && line.startsWith("Unit:")) {
            unitName = line.split(",")[0].trim();
        }

        // Skip the header
        if ((line = br.readLine()) != null && line.startsWith("Last Name,")) {
            // Skip header
        }

        // Read student data
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty() || line.startsWith("#")) {
                // Skip empty lines and comments
                continue;
            } else {
                String[] parts = line.split(",");
                if (parts.length < 6) continue; // Skip invalid lines

                String lastName = parts[0].trim();
                String firstName = parts[1].trim();
                String studentId = parts[2].trim();
                double mark1 = parts[3].trim().isEmpty() ? 0 : Double.parseDouble(parts[3].trim());
                double mark2 = parts[4].trim().isEmpty() ? 0 : Double.parseDouble(parts[4].trim());
                double mark3 = parts[5].trim().isEmpty() ? 0 : Double.parseDouble(parts[5].trim());

                studentsList.add(new Student(lastName, firstName, studentId, mark1, mark2, mark3));
            }
        }
        br.close();
    }

    /**
     * Prints the marks of all students.
     */
    public void computeAndPrintStudentMarks() {
        System.out.println("************* Printing the Details of all the students ****************************************");
        for (Student student : studentsList) {

            System.out.println(student);
        }
        System.out.println("************************************************************************************************");
    }

    /**
     * Filters students whose total marks are below the given threshold.
     *
     * @param threshold the threshold to filter students
     * @return a list of filtered students
     */
    public List<Student> filterStudentsBelowThreshold(int threshold) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : studentsList) {
            if (student.totalMarks < threshold) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    /**
     * Prints the students whose total marks are below the given threshold.
     *
     * @param threshold the threshold to filter students
     */
    public void printFilteredStudentsBelowThreshold(int threshold) {
        List<Student> filteredStudents = filterStudentsBelowThreshold(threshold);
        System.out.println("______________________ Displaying the details below Threshold _____________________________");
        for (Student student : filteredStudents) {
            System.out.println(student);
        }
        System.out.println("********************************************************************************************");
    }

    /**
     * Sorts students by their marks and prints the top 5 highest and lowest marks.
     */
    public void sortAndPrintTopStudents() {
        List<Student> topHighest = new ArrayList<>();
        List<Student> topLowest = new ArrayList<>();

        List<Student> tempList = new ArrayList<>(studentsList);

        // Find top 5 highest marks
        for (int i = 0; i < 5 && !tempList.isEmpty(); i++) {
            int maxIndex = 0;
            for (int j = 1; j < tempList.size(); j++) {
                if (tempList.get(j).totalMarks > tempList.get(maxIndex).totalMarks) {
                    maxIndex = j;
                }
            }
            topHighest.add(tempList.get(maxIndex));
            tempList.remove(maxIndex);
        }

        tempList = new ArrayList<>(studentsList);

        // Find top 5 lowest marks
        for (int i = 0; i < 5 && !tempList.isEmpty(); i++) {
            int minIndex = 0;
            for (int j = 1; j < tempList.size(); j++) {
                if (tempList.get(j).totalMarks < tempList.get(minIndex).totalMarks) {
                    minIndex = j;
                }
            }
            topLowest.add(tempList.get(minIndex));
            tempList.remove(minIndex);
        }

        System.out.println("********************** Top 5 Highest Marks *************************************************");
        for (Student student : topHighest) {
            System.out.println(student);
        }

        System.out.println("\n*******************************************Top 5 Lowest Marks **********************************");
        for (Student student : topLowest) {
            System.out.println(student);
        }
    }

}
