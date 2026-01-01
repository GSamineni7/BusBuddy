import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<School> schools;

    //Constructor
    public Company(String name) {
        this.name = name;
        this.schools = new ArrayList<>();
    }

    //Accessors
    public String getName() {
        return name;
    }

    public int getSchoolCount() {
        return schools.size();
    }

    //Mutators
    public void changeName(String name) {
        this.name = name;
    }

    public void addSchool(School school) {
        schools.add(school);
    }

    public void removeSchool(School school) {
        schools.remove(school);
    }
}
