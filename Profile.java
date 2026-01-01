import java.util.ArrayList;

public class Profile {
    private Parents parent1;
    private Parents parent2;
    private ArrayList<Student> students;
    private School school;

    //Constructor
    public Profile(Parents parent1, Parents parent2, School school) {
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.school = school;
        this.students = new ArrayList<>();
    }

    //Mutators
    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    //Accessors
    public Parents getParent1() {
        return parent1;
    }

    public Parents getParent2() {
        return parent2;
    }

    public School getSchool() {
        return school;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    //Implementation - Additional Accessors
    public Student getStudentByName(String name, int pin) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name) && s.getPin() == pin) {
                return s;
            }
        }
        return null;
    }

    public Parents getParentByName(String name, String phoneNumber) {
        if (parent1.getName().equalsIgnoreCase(name) && parent1.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
            return parent1;
        } else if (parent2.getName().equalsIgnoreCase(name) && parent2.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
            return parent2;
        }
        return null;
    }

    public Student getStudentByPin(int pin) {
        for (Student s : students) {
            if (s.getPin() == pin) {
                return s;
            }
        }
        return null;
    }
}
