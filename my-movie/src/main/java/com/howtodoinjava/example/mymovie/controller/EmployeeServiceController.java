package com.howtodoinjava.example.mymovie.controller;

import com.howtodoinjava.example.mymovie.beans.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeServiceController {

    // TODO create some employee
    private static Map<Integer,Employee> employeeMap = new HashMap<Integer, Employee>();

    static {
        employeeMap = new HashMap<Integer, Employee>();

        Employee emp1 = new Employee("ayoub",1);
        Employee emp2 = new Employee("hasna la zboun",2);


        employeeMap.put(emp1.getId(), emp1);
        employeeMap.put(emp2.getId(), emp2);
    }
    @RequestMapping(value = "/findEmployeeDetails/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        System.out.println("Getting Employee details for " + employeeId);


        // TODO create get method to find employee by id
        Employee employee = employeeMap.get(employeeId);
        if (employee == null) {
            employee = new Employee("not found",0);
        }
        return employee;
    }

}
