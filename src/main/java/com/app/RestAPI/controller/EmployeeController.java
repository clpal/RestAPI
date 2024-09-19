package com.app.RestAPI.controller;

import com.app.RestAPI.mapper.EmployeeMapper;
import com.app.RestAPI.model.Employee;
import com.app.RestAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    String hello() {
        return "Hello";
    }

    @PostMapping ("/employee")

    public Employee saveEmployee(@RequestBody EmployeeMapper employeeMapper) {

        Employee emp = 	employeeService.saveEmployee(employeeMapper);
        return emp;

    }

    @GetMapping("/fetch/{empId}")

    public EmployeeMapper fetchEmployeeById(@PathVariable("empId") String empId) {

        EmployeeMapper employeeMapper = employeeService.fetchEmployeeById(empId);
        return employeeMapper;


    }

    @DeleteMapping("/delete/{empId}")

    public String deleteEmployeeById(@PathVariable("empId") String empId) {

        String s = employeeService.deleteEmployeeById(empId);
        return s;


    }




    @GetMapping("/employees")

    public List<EmployeeMapper> fetchEmployeeList() {

        List<EmployeeMapper> empList = employeeService.getEmployeeList();
        return empList;


    }

    @PutMapping("/update")

    public EmployeeMapper updateEmployee(@RequestBody EmployeeMapper employeeMapper) {

        EmployeeMapper emp = employeeService.updateEmployee(employeeMapper);
        return emp;


    }


}
