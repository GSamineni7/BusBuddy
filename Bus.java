import java.util.ArrayList;

public class Bus {
    private int busNumber;
    private ArrayList<Integer> studentPins;
    private School schoolName;
    private Company companyName;

    //Constructor
    public Bus(int busNumber, School schoolName, Company companyName) {
        this.busNumber = busNumber;
        this.schoolName = schoolName;
        this.companyName = companyName;
        this.studentPins = new ArrayList<>();
    }

    //Accessors
    public int getBusNumber() {
        return busNumber;
    }

    public int getStudentCount() {
        return studentPins.size();
    }
    
    public ArrayList<Integer> getStudentPins() {
        return studentPins;
    }
    

    public School getSchoolName() {
        return schoolName;
    }

    public Company getCompanyName() {
        return companyName;
    }

    //Mutators
    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public void addStudentPin(int pin) {
        studentPins.add(pin);
    }

    public void removeStudentPin(int pin) {
        studentPins.remove(Integer.valueOf(pin));
    }

    public void setSchoolName(School schoolName) {
        this.schoolName = schoolName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }
}