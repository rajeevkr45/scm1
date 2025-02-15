package com.scm.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.scm.entities.Contact;
import com.scm.entities.User;

public interface ContactService {

    //save contacts
    Contact save(Contact contact);

    //update contacts
    Contact update(Contact contact);

    // get contacts
    List<Contact>getAll();

    //get contact by id

    Contact getById(String id);

    //delete contact
    void delete(String id);

    //search contact
    Page<Contact> searchByName(String nameKeyword, int size,int page,String sortBy, String order, User user);

    Page<Contact> searchByEmail(String emailKeyword, int size,int page,String sortBy, String order, User user);

    Page<Contact> searchByPhoneNumber(String phoneKeyword, int size,int page,String sortBy, String order, User user);


    //get contacts by userId
    List<Contact> getByuserId(String userId);

    //get contacts by username
    Page<Contact> getByUser(User user,int page, int size,String sortField, String direction);

}
