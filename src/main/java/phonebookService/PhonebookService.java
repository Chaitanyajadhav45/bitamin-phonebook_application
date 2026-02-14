package phonebookService;

import java.io.*;
import java.util.*;
import phonebook.Contact;

public class PhonebookService {

    private List<Contact> contacts = new ArrayList<>();
    private final String FILE_NAME = "contacts.json";

    public PhonebookService() {
        loadFromFile();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveToFile();
    }

    public void updateContact(String name, String phone, String email) {
        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (c.getName().equalsIgnoreCase(name)) {
                c.setPhone(phone);
                c.setEmail(email);
                found = true;
                saveToFile();
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        boolean found = false;

        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
                System.out.println("Contact deleted successfully !!");
                break;
            }
        }

        if (found) {
            saveToFile();
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
    }

    public void searchContact(String keyword) {
        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);

            if (c.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                c.getPhone().contains(keyword)) {

                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching contacts found.");
        }
    }

    private void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));

            for (int i = 0; i < contacts.size(); i++) {
                writer.println(contacts.get(i).toString());
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = reader.readLine()) != null) {
                contacts.add(Contact.fromString(line));
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}
