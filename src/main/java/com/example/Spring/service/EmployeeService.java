package com.example.Spring.service;


import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import com.example.Spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    } //Paso 1

    public Optional<Employee> getEmployeeId(int ID) {
        return employeeRepository.findByEmployeeId(ID);
    }//Paso 2

    public List<Employee> getEmployeesByStatus(Optional<EmployeeStatus> status) {
        return employeeRepository.findByStatus(status);
    } //Paso 3

    public List<Employee> getEmployeesByDepartment(Optional<String> department) {
        return employeeRepository.findAllByDepartment(department);
    } //Paso
}
