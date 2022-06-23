package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

import java.util.ArrayList;

public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository = new ContactRepositoryImpl();

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName,lastName,phoneNumber);
        contactRepository.save(contact);
    }

    @Override
    public Contact findById(int i) {
        return contactRepository.findById(i);
    }

    @Override
    public void addContact(String firstName, String phoneNumber) {
        Contact contact = new Contact(firstName,phoneNumber);
        contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
       return contactRepository.save(contact);

    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        return contactRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public int count() {
        return contactRepository.count();
    }

    @Override
    public ArrayList<Contact> findName(String name) {
        return contactRepository.findByName(name);
    }


}

