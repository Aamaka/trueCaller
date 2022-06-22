package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.exceptions.NoContactException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private ContactRepository contactRepository;
    private  Contact contact;
    @BeforeEach
    public void startWith(){
        contactRepository = new ContactRepositoryImpl();
        contact = new Contact();
    }

    @Test
    public void saveContact_countIsOneTest(){
        contact.setFirstName("Sam");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        assertEquals(1,contactRepository.count());
    }

    @Test
    public void saveContact_countIsTwoTest(){
        contact.setFirstName("Sam");
        Contact contact2 = new Contact();
        contact2.setFirstName("Sams");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        Contact savedContact2 = contactRepository.save(contact2);
        assertEquals(2, savedContact2.getId());
        assertEquals(2,contactRepository.count());
    }
    @Test
    public void saveContact_getNameToTest(){
        contact.setFirstName("Sam");
        Contact contact2 = new Contact();
        contact2.setFirstName("Samson");

        Contact savedContact = contactRepository.save(contact);
        Contact savedContact2 = contactRepository.save(contact2);

        Contact foundContact = contactRepository.findById(1);
        Contact foundContact2 = contactRepository.findById(2);

        assertEquals(1, foundContact.getId());
        assertEquals("Sam", foundContact.getFirstName());
        assertEquals(2, foundContact2.getId());
        assertEquals("Samson", foundContact2.getFirstName());
    }

    @Test
    public void findByFirstNameTest(){
        contact.setFirstName("Sam");

        Contact savedContact = contactRepository.save(contact);
        Contact foundContact = contactRepository.findByFirstName("Sam");
        assertEquals(1, foundContact.getId());

    }

    @Test
    public void findByLastNameTest(){
        contact.setFirstName("Favour");
        contact.setLastName("bae");
        assertEquals(0, contactRepository.count());

        Contact save = contactRepository.save(contact);

        Contact findMyContact = contactRepository.findByLastName("bae");
        assertThrows(NoContactException.class,()->contactRepository.findByLastName("bay"));
        assertEquals(1,findMyContact.getId());

        Contact find = contactRepository.findByFirstName("Favour");
        assertEquals(1, find.getId());
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void deleteContactTest(){
        contact.setFirstName("Favour");
        contact.setLastName("bae");
        assertEquals(0, contactRepository.count());

        Contact save = contactRepository.save(contact);


        Contact findMyContact = contactRepository.findByLastName("bae");
        assertEquals(1,findMyContact.getId());
        contactRepository.delete(findMyContact);
        assertEquals(0, contactRepository.count());
    }

    @Test
    public void updateContactTest(){
        contact.setFirstName("Favour");
        contact.setLastName("bae");
        Contact saved = contactRepository.save(contact);

        Contact newContact = new Contact();
        newContact.setFirstName("Ademola");
        newContact.setLastName("Megbabi");
        Contact saved2 = contactRepository.save(newContact);
        assertEquals(2, contactRepository.count());


        Contact findMyContact = contactRepository.findById(1);
        assertEquals("bae", findMyContact.getLastName());


        findMyContact.setFirstName("Amaka");
        findMyContact.setLastName("babe");

        Contact updated = contactRepository.update(findMyContact);

        assertEquals(1,updated.getId());
        assertEquals("Amaka",updated.getFirstName());
        assertEquals(2, contactRepository.count());

        Contact find = contactRepository.findById(2);
        assertEquals("Ademola", find.getFirstName());
        assertEquals(2, contactRepository.count());

    }

    @Test
    public void testToFindContactByPhoneNumber(){
        Contact contact3 = new Contact();
        contact3.setPhoneNumber("7456");
        contact3.setFirstName("Ada");

        contact.setPhoneNumber("1234");
        contact.setFirstName("Favour");
        contact.setLastName("bae");

        Contact contact4 = contactRepository.save(contact3);
        Contact contact5 = contactRepository.findByPhoneNumber("7456");
        assertEquals(1, contact5.getId());
        assertEquals("Ada", contact5.getFirstName());



        Contact contact1 = contactRepository.save(contact);
        Contact contact2 = contactRepository.findByPhoneNumber("1234");
        assertThrows(NoContactException.class, ()-> contactRepository.findByPhoneNumber("7777"));
        assertEquals(2, contact2.getId());
        assertEquals("bae", contact2.getLastName());

        contact.setPhoneNumber("12345");
        Contact contact6 = contactRepository.update(contact);
        assertEquals("12345", contact6.getPhoneNumber());

        assertEquals("12345", contact.getPhoneNumber());
        assertEquals("bae", contact.getLastName());
        Contact contact7 = contactRepository.findByPhoneNumber("12345");
        assertEquals(2, contact7.getId());

    }

}

