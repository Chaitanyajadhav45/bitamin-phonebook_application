# bitamin-phonebook_application
Designed and implemented a Phonebook application that supports the following operations: ● Add contacts ● Update contact details ● Delete contacts ● View and search saved contacts

# Phonebook Application

## Overview
This is a CLI-based Phonebook application developed as part of a Backend Engineering Test.

The application allows users to:
- Add contacts
- Update contact details
- Delete contacts
- View saved contacts
- Search contacts

The application does not use any backend frameworks or REST APIs.

---

## How to Run the Program

1. Compile the program:
   javac phonebook/*.java phonebookService/*.java Main.java

2. Run the program:
   java Main

---

## Design Decisions

- Used layered structure:
  - Contact (Model class)
  - PhonebookService (Business logic)
  - Main (User interaction)
- Data stored in a local file (contacts.json)
- Used ArrayList for in-memory storage
- Case-insensitive search for better usability
- Used Iterator instead of lambda for deletion

---

## Data Storage

Contacts are stored in a local file named:
contacts.json

Data persists between program runs.

---

## Assumptions

- Contact name is treated as unique identifier
- Data is stored in comma-separated format
- Program runs in console (CLI mode)

