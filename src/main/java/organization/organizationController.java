package organization;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class organizationController {

    private List<Employee> list = new ArrayList<>();

    private void getInitialListOfEmployee() {
        Employee employee1 = new Employee("BB", "Natanyahu", "Consolidation");
        Employee employee2 = new Employee("Ganz", "lapid", "blue-white");
        Employee employee3 = new Employee("Moshe", "feiglin", "Identity");
        Employee employee4 = new Employee("Ivet", "Liberman", "Israel-home");
        Employee employee5 = new Employee("Moshe", "Kachlon", "All-of-us");
        Employee employee6 = new Employee("Avi", "Gabay", "Labor");
        Employee employee7 = new Employee("Tamar", "Zandberg", "Vigour");
        Employee employee8 =  new Employee("Zibur", "Rahav", "Supreme");
        list.add(employee1);
        list.add(employee6);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee7);
        list.add(employee8);
        addSubordinate(employee8.getId(),employee1);
        addSubordinate(employee8.getId(),employee2);
        addSubordinate(employee1.getId(),employee4);
        addSubordinate(employee1.getId(),employee5);
        addSubordinate(employee1.getId(),employee3);
        addSubordinate(employee2.getId(),employee6);
        addSubordinate(employee2.getId(),employee7);

        Task taskBB = new Task();
        taskBB.setDate(Long.parseLong("1554831688351"));
        taskBB.setDueDate(Long.parseLong("1554831688351"));
        taskBB.setText("reduce cost of living");

        Task taskBB2 = new Task();
        taskBB2.setDate(Long.parseLong("1554831688351"));
        taskBB2.setDueDate(Long.parseLong("1554831688351"));
        taskBB2.setText("Iran Iran!!");

        Task taskGanz = new Task();
        taskGanz.setDate(Long.parseLong("1554831688351"));
        taskGanz.setDueDate(Long.parseLong("1554831688351"));
        taskGanz.setText("reduce cost of living");

        Task taskGanz2 = new Task();
        taskGanz2.setDate(Long.parseLong("1554831688351"));
        taskGanz2.setDueDate(Long.parseLong("1554831688351"));
        taskGanz2.setText("reduce rockets");

        Task taskfeig = new Task();
        taskfeig.setDate(Long.parseLong("1554831688351"));
        taskfeig.setDueDate(Long.parseLong("1554831688351"));
        taskfeig.setText("go green!");

        employee1.task(taskBB);
        employee1.task(taskBB2);
        employee2.task(taskGanz);
        employee2.task(taskGanz2);
        employee3.task(taskfeig);


    }

    public void addSubordinate(int managerID, Employee subordinate) {
        getEmployee(managerID)
                .add(subordinate);
        list.stream()
                .filter(e -> e.getId() == subordinate.getId())
                .findFirst()
                .get()
                .setManager(managerID);
    }

    private Employee getEmployee(int id) {
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    @RequestMapping("/getEmployees")
    public List<Employee> getEmployees() {
        if (list.isEmpty()) {
            getInitialListOfEmployee();
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/{managerId}/sendReport")
    public Report sendReport(@PathVariable int managerId, @RequestBody Report report) {
        Employee manager = getEmployee(managerId);
        report.setDate(new Date());
        manager.report(report);
        return report;
    }

    @ResponseBody
    @RequestMapping("/{employeeId}/assignTask")
    public Task assignTask(@PathVariable int employeeId, @RequestBody Task task) {
        Employee employee = getEmployee(employeeId);
        employee.task(task);
        return task;
    }

}


