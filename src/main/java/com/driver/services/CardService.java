package com.driver.services;

import com.driver.models.Student;
import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository3;

    public Card createAndReturn(Student student){
//        Student stu = new Student();
//        stu.setAge(studentRequestDto.getAge());
//        stu.setCountry(studentRequestDto.getCountry());
//        stu.setName(studentRequestDto.getName());
//        stu.setEmail(studentRequestDto.getEmail());
//
//        Card newcard=new Card();
//        newcard.setCardStatus(CardStatus.ACTIVATED);
//        newcard.setStudent(stu);
//        stu.setCard(newcard);
//        studentRepository.save(stu);

        Card card = new Card();
        card.setStudent(student);
        card.setCardStatus(CardStatus.ACTIVATED);
        cardRepository3.save(card);
        //link student with a new card
        return card;
    }

    public void deactivateCard(int student_id){
        cardRepository3.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}
