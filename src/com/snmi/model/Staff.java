package com.snmi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Staff object which role is to collect all employees
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Staff {

    /**
     * Variable list
     */
    private List<Employee> staffList = new ArrayList<>();

    /**
     * Get the list
     */
    public List<Employee> getStaffList() { return staffList; }

    /**
     * Add new employee to the staff
     * @param employee take the employee
     */
    public void addEmployee(Employee employee) {
        staffList.add(employee);
    }

}
