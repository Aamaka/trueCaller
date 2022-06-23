package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.exceptions.NoContactException;

import java.util.ArrayList;

public class ContactRepositoryImpl implements ContactRepository{
    ArrayList<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        if(contact.getId() != 0){
            update(contact);
        }else {
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
            return contact;}
        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }


    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }


    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public ArrayList<Contact> findByName(String name) {
        ArrayList<Contact> me = new ArrayList<>();
        for (Contact contact: contacts){
            if(name.equalsIgnoreCase(contact.getFirstName()) || name.equalsIgnoreCase(contact.getLastName()) ) {
                me.add(contact);
            }
        }
        return me;
    }


     private Contact update(Contact contact) {
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
