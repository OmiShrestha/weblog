/*
 Author: Omi Shrestha
 BloggerServiceImpl.java: Service Layer for Blogger Operations
 Description: This class provides the service layer for handling blogger-related operations such
 as registering a new blogger and listing all bloggers. It interacts with the BloggerDAO class
 to perform database operations. The class uses a Scanner object to read user input for registering
 a new blogger.

 Methods:
 - registerBlogger: Reads blogger details from the console, creates a Blogger object, and registers
   the blogger using BloggerDAO.
 - listBloggers: Lists all registered bloggers by invoking the corresponding method in BloggerDAO.
 */

package com.weblog.service.impl;

import com.weblog.db.BloggerDAO;
import com.weblog.entity.Blogger;
import com.weblog.db.impl.BloggerDAOImpl;
import com.weblog.service.BloggerService;

import java.sql.SQLException;
import java.util.Scanner;
public class BloggerServiceImpl implements BloggerService {
    private final BloggerDAO bloggerDAO = new BloggerDAOImpl(); // DAO for blogger operations
    @Override
    // Method to register a new blogger
    public void registerBlogger(Scanner scanner) {
        // Creates a new blogger object with input details
        Blogger blogger = new Blogger();

        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Interests (comma-separated): ");
        String interests = scanner.nextLine();

        // Sets all the details of the new blogger
        blogger.setEmail(email);
        blogger.setPassword(password);
        blogger.setName(name);
        blogger.setAddress(address);
        blogger.setInterests(interests);

        try {
            bloggerDAO.registerBlogger(blogger);
            System.out.println("Blogger registered successfully.");
        } catch (SQLException e) {
            System.err.println("Error registering blogger: " + e.getMessage());
        }
    }

    @Override
    // Method to list all registered bloggers
    public void listBloggers() {
        try {
            bloggerDAO.listBloggers();
        } catch (SQLException e) {
            System.err.println("Error listing bloggers: " + e.getMessage());
        }
    }
}
