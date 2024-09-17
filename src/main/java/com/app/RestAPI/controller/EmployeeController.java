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

    @PostMapping("/employee")
    Employee saveEmployee(@RequestBody EmployeeMapper employeeMapper) {
        Employee emp = employeeService.saveEmployee(employeeMapper);
        return emp;
    }


}
