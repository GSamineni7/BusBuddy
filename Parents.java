import java.util.ArrayList;

public class Parents {
    private String name;
    private String phoneNumber;
    private ArrayList<String> notifications;

    //Constructor
    public Parents(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notifications = new ArrayList<>();
    }

    //Accessors
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void printNotifications() {
        if (notifications.isEmpty()) {
            System.out.println("No notifications.");
        } else {
            System.out.println("Notifications for " + name + ":");
            for (String notification : notifications) {
                System.out.println("- " + notification);
            }
            notifications.clear(); // Clear notifications after printing
        }
    }


    /*
    public String getStudents() {
        for(int i = 0; i<students.size(); i++){
            return students.get(i).getName();
        }
        return "No Students";
    }
    */

    //Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addNotification(String notification) {
        this.notifications.add(notification);
    }
}