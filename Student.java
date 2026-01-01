public class Student {
    private String name;
    private School school;
    private int busNumber;
    private int pin;

    //Constructor
    public Student(String name, School school, int busNumber, int pin) {
        this.name = name;
        this.school = school;
        this.busNumber = busNumber;
        this.pin = pin;
    }

    //Accessors
    public String getName() {
        return name;
    }

    public School getSchool() {
        return school;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public int getPin() {
        return pin;
    }

    //Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}