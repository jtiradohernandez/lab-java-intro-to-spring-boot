package com.example.Spring.repository;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    Employee employee1;

    @BeforeEach
    void setUp() {
        employee1 = new Employee("cardiology","Xavi", EmployeeStatus.ON);
        employeeRepository.save(employee1);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    public void createEmployee(){
        Optional<Employee> employeeFound = employeeRepository.findByEmployeeId(employee1.getEmployeeId());
        assertTrue(employeeFound.isPresent());
        assertEquals(employee1.getEmployeeId(),employeeFound.get().getEmployeeId());
    }
}