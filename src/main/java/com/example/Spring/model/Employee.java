package com.example.Spring.model;

import com.example.Spring.EmployeeStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    private String name;
    private EmployeeStatus status;

    public Employee(String department, String name, EmployeeStatus status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
