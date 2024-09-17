package com.app.RestAPI.service;

import com.app.RestAPI.mapper.EmployeeMapper;
import com.app.RestAPI.model.Employee;
import com.app.RestAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(EmployeeMapper employeeMapper) {
        Employee employee = new Employee();

        employee.setEmp_id(employeeMapper.getEmployeeId());
        employee.setEmp_name(employeeMapper.getEmployeeName());
        employee.setEmail(employeeMapper.getEmail());
        employee.setAge(employeeMapper.getAge());
        employee.setAddress(employeeMapper.getAddress());
        Employee resultEmployee = employeeRepository.save(employee);
        return resultEmployee;
    }


}
