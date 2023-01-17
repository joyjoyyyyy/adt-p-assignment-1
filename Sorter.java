import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sorter {
    public static void main(String[] args) {
        String usage = """
            usage: java Sorter <-f|-n|-l> <file_path>
            Sort the student by student number -n
            Sort the student by first name -f
            Sort the student by last name -l
            """;

        if (args.length != 2) {
            System.out.println(usage);
            return;
        }

        String sortType = args[0];
        File file = new File(args[1]);

        ArrayList<Student> students = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(text, ",");
                String studentId = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
                String firstName = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
                String lastName = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";

                Student student = new Student(studentId, firstName, lastName);
                students.add(student);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
            return;
        }  
        
        switch (sortType) {
            case "-n": {
                sortByStudentId(students);
                break;
            }
            case "-f": {
                sortByFirstName(students);
                break;
            }
            case "-l": {
                sortByLastName(students);
                break;
            }
            default: {
                System.out.println(usage);
                return;
            }
        }
        for (Student student : students) {
            System.out.println(student.getStudentId() + " " + student.getFirstName() + " " + student.getLastName());
        }  
    }

    public static void sortByStudentId(ArrayList<Student> students) {
        Comparator<Student> compareBySID = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getStudentId().compareTo(s2.getStudentId());
            }
        };

        students.sort(compareBySID);
    }

    public static void sortByFirstName(ArrayList<Student> students) {
        Comparator<Student> compareByFirstName = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getFirstName().compareTo(s2.getFirstName());
            }
        };

        students.sort(compareByFirstName);
    }

    public static void sortByLastName(ArrayList<Student> students) {
        Comparator<Student> compareByLastName = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getLastName().compareTo(s2.getLastName());
            }
        };

        students.sort(compareByLastName);
    }
}
