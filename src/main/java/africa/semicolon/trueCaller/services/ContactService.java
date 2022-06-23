package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int i);

    void addContact(String firstName, String phoneNumber);


    Contact update (Contact contact);

    Contact findByPhoneNumber(String phoneNumber);


    void delete(Contact contact);

    int count();
}
