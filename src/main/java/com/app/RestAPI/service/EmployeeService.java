package com.app.RestAPI.service;

import com.app.RestAPI.mapper.EmployeeMapper;
import com.app.RestAPI.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    public Employee saveEmployee(EmployeeMapper employeeMapper);

    public EmployeeMapper fetchEmployeeById(String empId);

    public String deleteEmployeeById(String empId);

    public EmployeeMapper updateEmployee(EmployeeMapper employeeMapper);

    public List<EmployeeMapper> getEmployeeList();
}
