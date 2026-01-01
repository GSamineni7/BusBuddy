import java.util.ArrayList;

public class School {
    private String name;
    private ArrayList<Profile> profiles;
    private Company company;
    private ArrayList<Bus> buses; 

    //Constructor
    public School(String name, Company company) {
        this.name = name;
        this.profiles = new ArrayList<>();
        //this.parents = new ArrayList<>();
        this.company = company;
        this.buses = new ArrayList<>();
    }

    //Accessors
    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public int getNumProfiles() {
        return profiles.size();
    }

    public ArrayList<Bus> getBusNumbers(){
        return buses;
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    //Mutators
    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public void removeProfile(Profile profile) {
        profiles.remove(profile);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void removeBus(Bus bus) {
        buses.remove(bus);
    }

    //Implementation - Additional Accessors
    public Profile findProfileByParentName(String parentName, String phoneNumber) {
        for (Profile p : profiles) {
            if ((p.getParent1().getName().equalsIgnoreCase(parentName) && p.getParent1().getPhoneNumber().equalsIgnoreCase(phoneNumber)) || (p.getParent2().getName().equalsIgnoreCase(parentName) && p.getParent2().getPhoneNumber().equalsIgnoreCase(phoneNumber))) {
                return p;
            }
        }
        return null;
    }

    public Profile findProfileByStudentName(String studentName, int pin) {
        for (Profile p : profiles) {
            for (Student s : p.getStudents()) {
                if (s.getName().equalsIgnoreCase(studentName) && s.getPin() == pin) {
                    return p;
                }
            }
        }
        return null;
    }

    public Profile findProfileByAdultName(String adultName, String phoneNumber) {
        for (Profile p : profiles) {
            if (p.getParent1().getName().equalsIgnoreCase(adultName) && p.getParent1().getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return p;
            } else if (p.getParent2().getName().equalsIgnoreCase(adultName) && p.getParent2().getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    public Profile findProfileByStudentPin(int pin) {
        for (Profile p : profiles) {
            for (Student s : p.getStudents()) {
                if (s.getPin() == pin) {
                    return p;
                }
            }
        }
        return null;
    }

    public Bus findBusByNumber(int busNumber) {
        for (Bus b : buses) {
            if (b.getBusNumber() == busNumber) {
                return b;
            }
        }
        return null;
    }
}