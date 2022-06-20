package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.exceptions.NoContactException;

public interface ContactRepository {
    Contact save(Contact contact);
    int count();
    Contact findByFirstName(String firstName);
    Contact findById(int id);

    Contact findByLastName(String lastName) throws NoContactException;

    void delete(Contact contact);


    Contact update(Contact contact);

    Contact findByPhoneNumber(String phoneNumber);
}
