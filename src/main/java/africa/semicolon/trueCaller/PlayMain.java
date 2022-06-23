package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import africa.semicolon.trueCaller.services.ContactService;
import africa.semicolon.trueCaller.services.ContactServiceImpl;

import java.util.Scanner;

public class PlayMain {
    static ContactService service = new ContactServiceImpl();
    static ContactRepository contactRepository = new ContactRepositoryImpl();

    static Scanner input = new Scanner(System.in);
    static String userInput;
    public static void main(String[] args) {
        main();
    }
    private static void main(){
        System.out.println("""
                1. add contact
                2.find contact
                """);

        userInput = input.nextLine();
        switch (userInput){
            case "1" -> addContact();
            case "2" -> findContact();
            default -> main();
        }
    }

    private static void findContact() {
        System.out.println("Enter name: ");
        String name = input.nextLine();
        contactRepository.findByName(name);

    }

    private static void addContact() {
        System.out.println("Enter first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter last name: ");
        String lastName = input.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = input.nextLine();

        service.addContact(firstName, lastName, phoneNumber);
        main();
    }



}
