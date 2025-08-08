package com.contactbook;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactDAO dao = new ContactDAO();

        while (true) {
            System.out.println("\n--- Contact Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    dao.addContact(new Contact(name, phone));
                    break;
                case 2:
                    List<Contact> contacts = dao.getAllContacts();
                    System.out.println("\nID | Name | Phone");
                    for (Contact c : contacts) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.print("Enter contact ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteContact(id);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
