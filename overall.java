import java.util.Scanner;
import java.util.ArrayList;

public class overall {

    //Menus
    public static void printSchoolMenu(){
        System.out.println("--------------------------");
        System.out.println("1. Add New Family (Student + Adults)");
        System.out.println("2. Add a Student (Adults already exist)");
        System.out.println("3. Change Adult Info");
        System.out.println("4. Change Student Info");
        System.out.println("5. Remove Student (from exsiting Family)");
        System.out.println("6. Add Bus");
        System.out.println("7. Remove Bus");
        System.out.println("8. View Student & Adult Info");
        System.out.println("9. Send Notification to Adults");
        System.out.println("-1. Exit School Menu");
        System.out.println("--------------------------");
        System.out.print("Please enter your choice: ");
    }

    public static void printAdminMenu(){
        System.out.println("--------------------------");
        System.out.println("1. Add Company");
        System.out.println("2. Add School");
        System.out.println("3. Remove Company");
        System.out.println("4. Remove School");
        System.out.println("5. View Schools by Company");
        System.out.println("-1. Exit Admin Menu");
        System.out.println("--------------------------");
        System.out.print("Please enter your choice: ");
    }
    //Backend Logic
    private static ArrayList<School> schools = new ArrayList<>();
    private static ArrayList<Company> companies = new ArrayList<>();

    public static void addSchool(School school, Company company) {
        schools.add(school);
        company.addSchool(school);
    }

    public static School findSchoolByName(String name) {
        for (School s : schools) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public static Company findCompanyByName(String name) {
        for (Company c : companies) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //Frontend Logic
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the School Bus Management System!");
        while (true) {
            System.out.print("\n-------------------------- \nEnter 1 for school menu \nEnter 2 for adult notifications \nEnter 3 for bus driver \nEnter 4 for Administrator\n--------------------------\nPlease enter your choice: ");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter school name: ");
                input.nextLine();  // Consume newline
                String schoolName = input.nextLine();
                School s = findSchoolByName(schoolName);
                if (s == null) {
                    System.out.print("School not found. Please try again.");
                    continue;
                }else{
                    while (true) {
                        printSchoolMenu();
                        int schoolChoice = input.nextInt();
                        if (schoolChoice == -1) {
                            break;
                        }else if (schoolChoice==1){
                            System.out.print("Enter Student Name: ");
                            input.nextLine();  // Consume newline
                            String studentName = input.nextLine();
                            System.out.print("Enter Bus Number: ");
                            int busNumber = input.nextInt();
                            System.out.print("Enter Pin: ");
                            int pin = input.nextInt();
                            System.out.print("Enter Adult 1 Name: ");
                            input.nextLine();  // Consume newline
                            String parent1Name = input.nextLine();
                            System.out.print("Enter Adult 1 Phone Number: ");
                            String parent1Phone = input.nextLine();
                            System.out.print("Enter Adult 2 Name: ");
                            String parent2Name = input.nextLine();
                            System.out.print("Enter Adult 2 Phone Number: ");
                            String parent2Phone = input.nextLine();
                            if (s.getBusNumbers().contains(s.findBusByNumber(busNumber))){
                                Parents parent1 = new Parents(parent1Name, parent1Phone);
                                Parents parent2 = new Parents(parent2Name, parent2Phone);
                                Student newStudent = new Student(studentName, s, busNumber, pin);
                                Profile profile = new Profile(parent1, parent2, s);
                                profile.addStudent(newStudent);
                                s.addProfile(profile);
                                s.findBusByNumber(busNumber).addStudentPin(pin);
                                System.out.println("Student and Adults added successfully!");
                            }else{
                                System.out.println("Bus number not found. Please try again.");
                            }
                        }else if(schoolChoice==2){
                            System.out.print("Enter Adult Name: ");
                            input.nextLine();  // Consume newline
                            String parent1Name = input.nextLine();
                            System.out.print("Enter Adult Phone Number: ");
                            String parent1Phone = input.nextLine();
                            Profile p = s.findProfileByParentName(parent1Name, parent1Phone);
                            if (p == null) {
                                System.out.println("Adult not found. Please try again.");
                            }else{
                                System.out.print("Enter Student Name: ");
                                //input.nextLine();  // Consume newline
                                String studentName = input.nextLine();
                                System.out.print("Enter Bus Number: ");
                                int busNumber = input.nextInt();
                                System.out.print("Enter Pin: ");
                                int pin = input.nextInt();
                                if (s.getBusNumbers().contains(s.findBusByNumber(busNumber))){
                                    Student newStudent = new Student(studentName, s, busNumber, pin);
                                    p.addStudent(newStudent);
                                    s.findBusByNumber(busNumber).addStudentPin(pin);
                                    System.out.println("Student added successfully!");
                                }else{
                                    System.out.println("Bus Number not found. Please try again.");
                                }
                            }
                        }else if(schoolChoice==3){
                            System.out.print("Enter Adult Name to change: ");
                            input.nextLine();  // Consume newline
                            String adultName = input.nextLine();
                            System.out.print("Enter Adult Phone Number to change: ");
                            String adultPhone = input.nextLine();
                            Profile p = s.findProfileByParentName(adultName, adultPhone);
                            if (p == null) {
                                System.out.println("Adult not found. Please try again.");
                            }else{
                                if(p.getParent1().getName().equalsIgnoreCase(adultName) && p.getParent1().getPhoneNumber().equalsIgnoreCase(adultPhone)){
                                    System.out.print("Enter new name for Adult 1: ");
                                    String newName = input.nextLine();
                                    System.out.print("Enter new phone number for Adult 1: ");
                                    String newPhone = input.nextLine();
                                    p.getParent1().setName(newName);
                                    p.getParent1().setPhoneNumber(newPhone);
                                    System.out.println("Adult 1 info updated successfully!");
                                }else if(p.getParent2().getName().equalsIgnoreCase(adultName) && p.getParent2().getPhoneNumber().equalsIgnoreCase(adultPhone)){
                                    System.out.print("Enter new name for Adult 2: ");
                                    String newName = input.nextLine();
                                    System.out.print("Enter new phone number for Adult 2: ");
                                    String newPhone = input.nextLine();
                                    p.getParent2().setName(newName);
                                    p.getParent2().setPhoneNumber(newPhone);
                                    System.out.println("Adult 2 info updated successfully!");
                                }
                            }
                        }else if(schoolChoice==4){
                            System.out.print("Enter Student Name to change: ");
                            input.nextLine();  // Consume newline
                            String studentName = input.nextLine();
                            System.out.print("Enter Student pin to change: ");
                            int pin = input.nextInt();
                            Profile p = s.findProfileByStudentName(studentName, pin);
                            if (p == null) {
                                System.out.println("Student not found. Please try again.");
                            }else{
                                Student toChange = p.getStudentByName(studentName, pin);
                                System.out.print("Enter new Student Name (enter old name if unchanged): ");
                                input.nextLine();  // Consume newline
                                String newStudentName = input.nextLine();
                                System.out.print("Enter new Bus Number (enter old bus number if unchanged): ");
                                int newBusNumber = input.nextInt();
                                System.out.print("Enter new Pin (enter old pin if unchanged): ");
                                int newPin = input.nextInt();
                                int oldBusNumber = toChange.getBusNumber();
                                int oldPin = toChange.getPin();
                                if (s.findBusByNumber(newBusNumber)==null){
                                    System.out.println("New Bus Number not found. Please try again.");
                                }else{
                                    if (newBusNumber != oldBusNumber) {
                                        toChange.setName(newStudentName);
                                        toChange.setBusNumber(newBusNumber);
                                        toChange.setPin(newPin);
                                        s.findBusByNumber(oldBusNumber).removeStudentPin(oldPin);
                                        s.findBusByNumber(newBusNumber).addStudentPin(newPin);
                                        System.out.println("Student info updated successfully!");
                                    }else{
                                        toChange.setName(newStudentName);
                                        toChange.setBusNumber(newBusNumber);
                                        toChange.setPin(newPin);
                                        System.out.println("Student info updated successfully!");
                                    }
                                }
                            }
                        }else if(schoolChoice==5){
                            System.out.print("Enter Student Name to remove: ");
                            input.nextLine();  // Consume newline
                            String studentName = input.nextLine();
                            System.out.print("Enter Student pin to remove: ");
                            int pin = input.nextInt();
                            Profile p = s.findProfileByStudentName(studentName, pin);
                            if (p == null) {
                                System.out.println("Student not found. Please try again.");
                            }else{
                                Student toRemove = p.getStudentByName(studentName, pin);
                                p.removeStudent(toRemove);
                                s.findBusByNumber(toRemove.getBusNumber()).removeStudentPin(toRemove.getPin());
                                System.out.println("Student removed successfully!");   
                            } 
                        }else if(schoolChoice==6){
                            System.out.print("Enter Bus Number: ");
                            int busNumber = input.nextInt();
                            Bus newBus = new Bus(busNumber, s, s.getCompany());
                            s.addBus(newBus);
                            System.out.println("Bus added successfully!");
                        }else if(schoolChoice==7){
                            System.out.print("Enter Bus Number to remove: ");
                            int busNumber = input.nextInt();
                            Bus b = s.findBusByNumber(busNumber);
                            if(b==null){
                                System.out.println("Bus not found. Please try again.");
                            }else if (s.findBusByNumber(busNumber).getStudentCount()>0){
                                System.out.println("Bus has students assigned. Cannot remove bus.");
                            }else{
                                s.removeBus(b);
                                System.out.println("Bus removed successfully!");
                            }
                        }else if (schoolChoice == 8){
                            System.out.println("View Student & Adult Info");
                            System.out.println("Student Name | Adult 1 Name | Adult 1 Phone | Adult 2 Name | Adult 2 Phone | Student Bus Number | Student Pin");
                            for (Profile p : s.getProfiles()){
                                for (Student st : p.getStudents()){
                                    System.out.println(st.getName() + " | " + p.getParent1().getName() + " | " + p.getParent1().getPhoneNumber() + " | " + p.getParent2().getName() + " | " + p.getParent2().getPhoneNumber() + " | " + st.getBusNumber() + " | " + st.getPin()); 
                                }
                            }
                        }else if (schoolChoice == 9){
                            System.out.print("Enter message to send to all adults: ");
                            input.nextLine();  // Consume newline
                            String message = input.nextLine();
                            for (Profile p : s.getProfiles()){
                                p.getParent1().addNotification(message);
                                p.getParent2().addNotification(message);
                            }
                            System.out.println("Notifications sent to all adults in the school.");
                        }else{
                            System.out.println("Invalid choice. Please try again.");
                        }
                    }
                }
            }else if (choice == 2) {
                System.out.print("Enter School Name: ");
                input.nextLine();  // Consume newline
                String schoolName = input.nextLine();
                School s = findSchoolByName(schoolName);
                if (s == null) {
                    System.out.println("School not found. Please try again.");
                }else{
                    System.out.print("Enter Adult Name: ");
                    String parentName = input.nextLine();
                    System.out.print("Enter Adult Phone Number: ");
                    String parentPhone = input.nextLine();
                    Profile profile = s.findProfileByAdultName(parentName, parentPhone);
                    if (profile == null) {
                        System.out.println("Adult not found. Please try again.");
                    }else{
                        Parents p = profile.getParentByName(parentName, parentPhone);
                        if (p == null) {
                            System.out.println("Adult not found. Please try again.");
                        }else{
                            System.out.println("Notifications for " + p.getName() + ":");
                            p.printNotifications();
                        }
                    }
                }
            }else if (choice == 3) {
                System.out.print("Enter School Name: ");
                input.nextLine();  // Consume newline
                String schoolName = input.nextLine();
                School s = findSchoolByName(schoolName);
                if (s == null) {
                    System.out.println("School not found. Please try again.");
                }else{
                    System.out.print("Enter Bus Number: ");
                    int busNumber = input.nextInt();
                    Bus b = s.findBusByNumber(busNumber);
                    if (b == null) {
                        System.out.println("Bus not found. Please try again.");
                    }else{
                        System.out.println("Bus found. Please enter student details for verification. Type 0 to exit.");
                        while (true){
                            System.out.print("Enter Student Pin: ");
                            int pin = input.nextInt();
                            if (pin == 0) {
                                break;
                            }else if (!b.getStudentPins().contains(pin)){
                                System.out.println("Wrong bus for this student! Access denied.");
                            }else{
                                System.out.println("Correct bus for this student! Access granted.");
                                if(s.findProfileByStudentPin(pin)==null){
                                    System.out.println("Profile not found for this student.");
                                }else{
                                s.findProfileByStudentPin(pin).getParent1().addNotification("Your student " + s.findProfileByStudentPin(pin).getStudentByPin(pin).getName() + " has boarded the correct bus.");
                                s.findProfileByStudentPin(pin).getParent2().addNotification("Your student " + s.findProfileByStudentPin(pin).getStudentByPin(pin).getName() + " has boarded the correct bus.");
                                }
                            }
                        }
                        
                    }
                }
            }else if (choice == 4){
                while (true){
                    printAdminMenu();
                    int adminChoice = input.nextInt();
                    if (adminChoice == -1){
                        break;
                    }else if (adminChoice==1){
                        System.out.print("Enter Company Name: ");
                        input.nextLine();  // Consume newline
                        String companyName = input.nextLine();
                        Company newCompany = new Company(companyName);
                        companies.add(newCompany);
                        System.out.println("Company added successfully!");
                    }else if (adminChoice==2){
                        System.out.print("Enter School Name: ");
                        input.nextLine();  // Consume newline
                        String schoolName = input.nextLine();
                        System.out.print("Enter Company Name for the School: ");
                        String companyName = input.nextLine();
                        Company company = findCompanyByName(companyName);
                        if (company == null) {
                            System.out.print("Company not found. Please try again.");
                            continue;
                        }else{
                            School newSchool = new School(schoolName, company);
                            addSchool(newSchool, company);
                            System.out.println("School added successfully!");
                        }
                    }else if (adminChoice==3){
                        System.out.print("Enter Company Name to remove: ");
                        input.nextLine();  // Consume newline
                        String companyName = input.nextLine();
                        Company company = findCompanyByName(companyName);
                        if (company == null) {
                            System.out.println("Company not found. Please try again.");
                        }else if (company.getSchoolCount() > 0){
                            System.out.println("Company has schools. Please remove all schools first.");
                        }else{
                            companies.remove(company);
                            System.out.println("Company removed successfully!");
                        }
                    }else if (adminChoice==4){
                        System.out.print("Enter School Name to remove: ");
                        input.nextLine();  // Consume newline
                        String schoolName = input.nextLine();
                        School school = findSchoolByName(schoolName);
                        if (school == null) {
                            System.out.println("School not found. Please try again.");
                            continue;
                        }else if (school.getNumProfiles() > 0){
                            System.out.println("School has profiles. Please remove all profiles first.");
                        }else{
                            school.getCompany().removeSchool(school);
                            schools.remove(school);
                            System.out.println("School removed successfully!");
                        }
                    }else if (adminChoice==5){
                        System.out.print("Enter Company Name to view its schools: ");
                        input.nextLine();  // Consume newline
                        String companyName = input.nextLine();
                        Company company = findCompanyByName(companyName);
                        if (company == null) {
                            System.out.println("Company not found. Please try again.");
                            continue;
                        }else{
                            System.out.println("Schools under company " + company.getName() + ":");
                            for (School sch : schools){
                                if (sch.getCompany().getName().equalsIgnoreCase(company.getName())){
                                    System.out.println("School Name: " + sch.getName());
                                }
                            }
                        }
                    }else{
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}