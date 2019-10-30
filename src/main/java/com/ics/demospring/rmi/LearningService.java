package com.ics.demospring.rmi;

import com.ics.demospring.models.Student;
import com.ics.demospring.models.Training;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Optional;

public interface LearningService extends Remote {
    public List<Student> listOfStudents() throws RemoteException;
    public Optional<Student> getStudent(Long id) throws RemoteException;
    public Training createTraining(Training training) throws RemoteException;
}
