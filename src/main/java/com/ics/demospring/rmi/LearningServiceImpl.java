package com.ics.demospring.rmi;

import com.ics.demospring.models.Student;
import com.ics.demospring.models.Training;
import com.ics.demospring.repositories.StudentRepository;
import com.ics.demospring.repositories.TrainingRepository;
import com.ics.demospring.rmi.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

@Component
public class LearningServiceImpl implements LearningService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TrainingRepository trainingRepository;

//    public LearningServiceImpl(StudentRepository studentRepository, TrainingRepository trainingRepository) {
//        this.studentRepository = studentRepository;
//        this.trainingRepository = trainingRepository;
//    }

    @Override
    public List<Student> listOfStudents() throws RemoteException {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long id) throws RemoteException {
        return studentRepository.findById(id);
    }

    @Override
    public Training createTraining(Training training) throws RemoteException {
        return trainingRepository.save(training);
    }
}
