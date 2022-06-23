package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.exceptions.NoContactException;

import java.util.ArrayList;

public interface ContactRepository {
    Contact save(Contact contact);
    int count();

    Contact findById(int id);


    void delete(Contact contact);


    ArrayList<Contact> findByName(String name);
    Contact findByPhoneNumber(String phoneNumber);
}
