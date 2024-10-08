package com.app.RestAPI.service;

import com.app.RestAPI.mapper.EmployeeMapper;
import com.app.RestAPI.model.Employee;
import com.app.RestAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public EmployeeMapper fetchEmployeeById(String empId) {
        Employee employee = employeeRepository.findById(empId).orElse(null);
        EmployeeMapper emp = new EmployeeMapper();

        if(null!=employee) {
            emp.setEmployeeId(employee.getEmp_id());
            emp.setEmployeeName(employee.getEmp_name());
            emp.setEmail(employee.getEmail());
            emp.setAddress(emp.getAddress());
            emp.setAge(emp.getAge());

        }

        return emp;
    }

    @Override
    public String deleteEmployeeById(String empId) {

        Employee employee = employeeRepository.findById(empId).orElse(null);

        employeeRepository.delete(employee);
        return "employee deleted successfully";



    }

    @Override
    public EmployeeMapper updateEmployee(EmployeeMapper employeeMapper) {

        Employee employee = employeeRepository.findById(employeeMapper.getEmployeeId()).orElse(null);

        if(null!=employee) {

            employee.setEmp_name(employeeMapper.getEmployeeName());
            employee.setEmail(employeeMapper.getEmail());

            employeeRepository.save(employee);

        }

        return employeeMapper;
    }

    @Override
    public List<EmployeeMapper> getEmployeeList() {

        List<Employee> empList = employeeRepository.findAll();
        List<EmployeeMapper> resultList = new ArrayList<EmployeeMapper>();
        if(empList.size()>0) {

            for (Employee employee : empList) {

                EmployeeMapper employeeMapper = new EmployeeMapper();
                employeeMapper.setEmployeeId(employee.getEmp_id());
                employeeMapper.setEmployeeName(employee.getEmp_name());
                employeeMapper.setEmail(employee.getEmail());
                employeeMapper.setAddress(employee.getAddress());
                employeeMapper.setAge(employee.getAge());
                resultList.add(employeeMapper);
            }

        }

        return resultList;
    }

}
