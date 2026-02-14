package phonebookApplication;

import java.util.Scanner;

import phonebook.Contact;
import phonebookService.PhonebookService;

public class PhonebookApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PhonebookService service = new PhonebookService();

		while (true) {
			System.out.println("\n--- Phonebook Menu ---");
			System.out.println("1. Add Contact");
			System.out.println("2. Update Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. View Contacts");
			System.out.println("5. Search Contact");
			System.out.println("6. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Name: ");
				String name = scanner.nextLine();
				System.out.print("Phone: ");
				String phone = scanner.nextLine();
				System.out.print("Email: ");
				String email = scanner.nextLine();
				service.addContact(new Contact(name, phone, email));
				System.out.println("Contact added successfully!!");
				break;

			case 2:
				System.out.print("Enter name to update: ");
				name = scanner.nextLine();
				System.out.print("New Phone: ");
				phone = scanner.nextLine();
				System.out.print("New Email: ");
				email = scanner.nextLine();
				service.updateContact(name, phone, email);
				break;

			case 3:
				System.out.print("Enter name to delete: ");
				name = scanner.nextLine();
				service.deleteContact(name);
				break;

			case 4:
				service.viewContacts();
				break;

			case 5:
				System.out.print("Enter search keyword: ");
				String keyword = scanner.nextLine();
				service.searchContact(keyword);
				break;

			case 6:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
