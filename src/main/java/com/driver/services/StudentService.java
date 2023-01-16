package com.driver.services;

import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.models.Student;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;

    public Student getDetailsByEmail(String email){
        Student student = studentRepository4.findByEmailId(email);

        return student;
    }

    public Student getDetailsById(int id){
        Student student = studentRepository4.findById(id).get();

        return student;
    }

    public void createStudent(Student student){

        Card newCard = cardService4.createAndReturn(student);
        //studentRepository4.save(student);
    }

    public void updateStudent(Student student){

//        Student student1 = studentRepository4.findById(student.getId()).get();
//        student1.setName(student.getName());
//        student1.setAge(student.getAge());
//        student1.setCountry(student.getCountry());
//        student1.setEmailId(student.getEmailId());
//        studentRepository4.save(student1);
        studentRepository4.updateStudentDetails(student);
    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
//        Student student = studentRepository4.findById(id).get();
//        student.getCard().setCardStatus(CardStatus.DEACTIVATED);
//        studentRepository4.deleteById(id);
        cardService4.deactivateCard(id);
        studentRepository4.deleteCustom(id);

    }
}
