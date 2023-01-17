public class Student {
    private String studentId, firstName, lastName;

    Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
 
    }

    public String getStudentId() {
        return studentId;
    }
}