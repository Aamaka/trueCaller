//package africa.semicolon.trueCaller.data.repositories;
//
//import africa.semicolon.trueCaller.data.models.Contact;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ContactRepositoryImplTest {
//    private ContactRepository contactRepository;
//    private  Contact contact;
//    @BeforeEach
//    public void startWith(){
//        contactRepository = new ContactRepositoryImpl();
//        contact = new Contact();
//    }
//
//    @Test
//    public void saveContact_countIsOneTest(){
//        contact.setFirstName("Sam");
//
//        Contact savedContact = contactRepository.save(contact);
//        assertEquals(1, savedContact.getId());
//        assertEquals(1,contactRepository.count());
//    }
//
//    @Test
//    public void saveContact_countIsTwoTest(){
//        contact.setFirstName("Sam");
//        Contact contact2 = new Contact();
//        contact2.setFirstName("Sams");
//
//        Contact savedContact = contactRepository.save(contact);
//        assertEquals(1, savedContact.getId());
//        Contact savedContact2 = contactRepository.save(contact2);
//        assertEquals(2, savedContact2.getId());
//        assertEquals(2,contactRepository.count());
//    }
//    @Test
//    public void saveContact_getNameToTest(){
//        contact.setFirstName("Sam");
//        Contact contact2 = new Contact();
//        contact2.setFirstName("Samson");
//
//        Contact savedContact = contactRepository.save(contact);
//        Contact savedContact2 = contactRepository.save(contact2);
//
//        Contact foundContact = contactRepository.findById(1);
//        Contact foundContact2 = contactRepository.findById(2);
//
//        assertEquals(1, foundContact.getId());
//        assertEquals("Sam", foundContact.getFirstName());
//        assertEquals(2, foundContact2.getId());
//        assertEquals("Samson", foundContact2.getFirstName());
//    }
//
//
//
//    @Test
//    public void findByFirstNameTest(){
//        contact.setLastName("Simon");
//        contact.setFirstName("Sam");
//        Contact savedContact = contactRepository.save(contact);
//
//        Contact contact2 = new Contact();
//        contact2.setLastName("Sam");
//        contact2.setFirstName("simon");
//        Contact savedContact1 = contactRepository.save(contact2);
//        ArrayList<Contact> foundContact = contactRepository.findByName("Sam");
//
//
//        assertEquals("", foundContact.toString());
//
//
//    }
//
//    @Test
//    public void updateContactTest(){
//        contact.setFirstName("Favour");
//        contact.setLastName("bae");
//        Contact saved = contactRepository.save(contact);
//
//        Contact newContact = new Contact();
//        newContact.setFirstName("Ademola");
//        newContact.setLastName("Megbabi");
//        Contact saved2 = contactRepository.save(newContact);
//        assertEquals(2, contactRepository.count());
//
//
//        Contact findMyContact = contactRepository.findById(1);
//        assertEquals("bae", findMyContact.getLastName());
//
//
//        findMyContact.setFirstName("Amaka");
//        findMyContact.setLastName("babe");
//
//        Contact updated = contactRepository.save(findMyContact);
//
//        assertEquals(1,updated.getId());
//        assertEquals("Amaka",updated.getFirstName());
//        assertEquals(2, contactRepository.count());
//
//        Contact find = contactRepository.findById(2);
//        assertEquals("Ademola", find.getFirstName());
//        assertEquals(2, contactRepository.count());
//
//
//    }
//}
//
//
//
//
//
