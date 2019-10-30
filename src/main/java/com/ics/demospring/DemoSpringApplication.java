package com.ics.demospring;

import com.ics.demospring.models.Student;
import com.ics.demospring.models.Training;
import com.ics.demospring.repositories.StudentRepository;
import com.ics.demospring.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoSpringApplication{

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);
    }

}
