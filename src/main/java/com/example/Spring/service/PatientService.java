package com.example.Spring.service;

import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import com.example.Spring.model.Patient;
import com.example.Spring.repository.EmployeeRepository;
import com.example.Spring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    //paso 5

    public Optional<Patient> getPatientId(int ID) {
        return patientRepository.findByPatientId(ID);
    }
    // paso 6

    public List<Patient> getPatientRangeDate(Date initDate, Date endDate) {
        return patientRepository.findByDateOfBirthBetween(initDate,endDate);
    }//paso 7


    public List<Patient> getPatientByDoctorDepartment(Optional<String> department) {
        return patientRepository.findByDoctorDepartment(department);
    }
    //paso 8


    public List<Patient> getPatienByDoctorStatus(Optional<EmployeeStatus> status ) {
        return patientRepository.findByDoctorStatus(status);
    }
    //paso 9

}
