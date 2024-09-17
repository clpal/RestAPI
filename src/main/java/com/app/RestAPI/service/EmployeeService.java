package com.app.RestAPI.service;

import com.app.RestAPI.mapper.EmployeeMapper;
import com.app.RestAPI.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee saveEmployee(EmployeeMapper employeeMapper);


}
