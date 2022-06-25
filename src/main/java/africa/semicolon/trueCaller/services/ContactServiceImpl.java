package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;

import africa.semicolon.trueCaller.exceptions.NoContactException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private  ContactRepository contactRepository;
    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName,lastName,phoneNumber);
        contactRepository.save(contact);
    }

    @Override
    public Contact findById(String id) {
         Optional<Contact>  found = contactRepository.findById(id);
        if (found.isEmpty()) throw  new NoContactException("No contact found");
        return found.get();

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
    public List<Contact> findName(String name) {
        List<Contact> result = new ArrayList<>();
        result.addAll(contactRepository.findContactByFirstName(name));
        result.addAll(contactRepository.findContactByLastName(name));
        return result;
    }


}

