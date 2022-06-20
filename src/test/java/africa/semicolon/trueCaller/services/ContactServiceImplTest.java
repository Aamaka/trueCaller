package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    private ContactService contactService;
    private ContactRepository contactRepository;
    @BeforeEach
    public void startWith(){
        contactRepository = new ContactRepositoryImpl();
        contactService = new ContactServiceImpl(contactRepository);
    }

    @Test
    public void saveContact_findContactReturnsContact(){
        contactService.addContact("asa", "bool", "1234");
        Contact contact = contactService.findById(1);
        assertEquals("asa",contact.getFirstName());
        assertEquals("bool",contact.getLastName());
        assertEquals("1234", contact.getPhoneNumber());
        assertEquals(1,contactRepository.count());
    }

    @Test
    public void testToFindByDifferentId(){
        contactService.addContact("asa", "1234");
        contactService.addContact("bae", "bola","4567");
        contactService.addContact("kemi", "1235");
        Contact contact = contactService.findById(2);
        assertEquals("bae",contact.getFirstName());

    }

    @Test
    public void testForFindBtFirstName(){
        contactService.addContact("asa", "1234");
        contactService.addContact("bae", "bola","4567");
        contactService.addContact("kemi", "1235");
        Contact contact1 = contactService.findByFirstName("kemi");
        assertEquals(3, contact1.getId());
    }

   

}