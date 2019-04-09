package organization;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String firstName;
    private String lastName;
    private String position;
    private List<Employee> subordinates;
    private List<Task> tasks;
    private List<Report> reports;
    private int managerID;

    public Employee(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        id = count.incrementAndGet();
        subordinates = new ArrayList<Employee>();
        tasks = new ArrayList<Task>();
        reports = new ArrayList<Report>();
        managerID = 0;
    }
    //add subordinate
    public void add(Employee e) {
        subordinates.add(e);
    }
    //remove subordinate
    public void remove(Employee e) {
        subordinates.remove(e);
    }


    public void report(Report report){
        reports.add(report);
    }

    public void task(Task task){

            tasks.add(task);

    }
    public List<Task> getTasks(){
        return tasks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public int getManager() {
        return managerID;
    }

    public void setManager(int managerID) {
        this.managerID = managerID;
    }

    public int getId() {
        return id;
    }

    public List<Report> getReports() {
        return reports;
    }

    public String toString(){
        return ("Employee :[ Name : " + firstName +" "+lastName+ " position :" + position+" ]");
    }
}

