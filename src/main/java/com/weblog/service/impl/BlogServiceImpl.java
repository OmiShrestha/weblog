/*
 Author: Omi Shrestha
 BlogServiceImpl.java: Service Layer for Blog Operations
 Description: This class serves as the service layer for handling blog-related operations.
 It interacts with the BlogDAO class to perform database operations. The BlogService class
 provides methods for posting a new blog and listing all blogs, with user input handled
 through a Scanner object.

 Methods:
 - postBlog: Prompts the user for blog details (email, title, body, privacy status) and uses
   the BlogDAO class to insert the new blog into the database.
 - listBlogs: Use of the BlogDAO class to retrieve and display all blogs from the database.
 */
package com.weblog.service.impl;

import com.weblog.db.BlogDAO;
import com.weblog.entity.Blog;
import com.weblog.db.impl.BlogDAOImpl;
import com.weblog.service.BlogService;

import java.sql.SQLException;
import java.util.Scanner;

public class BlogServiceImpl implements BlogService {
    private final BlogDAO blogDAO = new BlogDAOImpl(); // DAO for Blog Operations

    @Override
    // Posts blog
    public void postBlog(Scanner scanner) {
        // Creates a new blog object with input details
        Blog blog = new Blog();

        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Body: ");
        String body = scanner.nextLine();
        System.out.print("Private (Y/N): ");
        String privacyInput = scanner.nextLine();

        // Sets all the details of the new blog post
        blog.setEmail(email);
        blog.setTitle(title);
        blog.setBody(body);
        blog.setPrivate(privacyInput);

        try {
            blogDAO.postBlog(blog);
            System.out.println("Blog posted successfully.");
        } catch (SQLException e) {
            System.err.println("Error posting blog: " + e.getMessage());
        }
    }

    @Override
    // Lists all blogs
    public void listBlogs() {
        try {
            blogDAO.listBlogs();
        } catch (SQLException e) {
            System.err.println("Error listing blogs: " + e.getMessage());
        }
    }
}
