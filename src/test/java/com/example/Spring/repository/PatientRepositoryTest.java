package com.example.Spring.repository;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import com.example.Spring.model.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    Patient patient1;

    @BeforeEach
    void setUp() {
        Date date = new Date();
        Employee employee1 = new Employee("cardiology","Xavi", EmployeeStatus.ON);
        employeeRepository.save(employee1);
        patient1 = new Patient("Thais",date ,employee1);
        patientRepository.save(patient1);
    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
    }

    @Test
    public void createPatient(){
        Optional<Patient> patientFound = patientRepository.findByPatientId(patient1.getPatientId());
        assertTrue(patientFound.isPresent());
        assertEquals(patient1.getPatientId(),patientFound.get().getPatientId());
    }
}