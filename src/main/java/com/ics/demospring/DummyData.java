package com.ics.demospring;

import com.ics.demospring.models.Student;
import com.ics.demospring.models.Training;
import com.ics.demospring.repositories.StudentRepository;
import com.ics.demospring.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DummyData implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Leadership", "Entrepreneurship", "Investment")
                .forEach( t-> trainingRepository.save(new Training(null,t, 30, null)));

        studentRepository.save(new Student(null,"Luteranya", "Nyange", new Training(1L,null, 30, null)));
        studentRepository.save(new Student(null,"Laurent", "Nyange", new Training(2L,null, 30, null)));
        studentRepository.save(new Student(null,"David", "Nyange", new Training(3L, null, 30, null)));
//        studentRepository.save(new Student("Stephany", "Nyange", new Training(null, 0, null)));


//        trainingRepository.findAll().forEach(t-> System.out.println(t.getName()));

        studentRepository.findAll().forEach(s-> System.out.printf("First Name: %s, Training: %s\n",
                s.getFirstName(),s.getTraining().getName()));
    }
}
