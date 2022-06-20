package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.exceptions.NoContactException;

import java.util.ArrayList;

public class ContactRepositoryImpl implements ContactRepository{
    ArrayList<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        contact.setId(contacts.size() + 1);
        contacts.add(contact);
        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        throw new NoContactException("No contact found");
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }

    @Override
    public Contact findByLastName(String lastName){
        for (Contact contact : contacts){
            if(contact.getLastName().equals(lastName))return contact;
        }
        throw new NoContactException("No contact found");
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public Contact update(Contact contact) {
        contacts.set(contact.getId() - 1, contact);
        return contact;
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts){
            if(contact.getPhoneNumber().equals(phoneNumber))return contact;
        }
        throw new NoContactException("No contact found");
    }


}
