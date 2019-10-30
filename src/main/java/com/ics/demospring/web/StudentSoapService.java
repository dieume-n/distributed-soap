package com.ics.demospring.web;

import com.ics.demospring.models.Student;
import com.ics.demospring.models.Training;
import com.ics.demospring.repositories.StudentRepository;
import com.ics.demospring.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@Component
@WebService
public class StudentSoapService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @WebMethod(operationName = "studentList")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @WebMethod
    public Optional<Student> getStudent(@WebParam(name="id") Long id){
        return studentRepository.findById(id);
    }

    @WebMethod
    public Training createTraining(@WebParam(name="training") Training training){
        return trainingRepository.save(training);
    }
}
