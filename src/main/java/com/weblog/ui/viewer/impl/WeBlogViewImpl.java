/*
 Author: Omi Shrestha
 WeBlogViewImpl.java: Implementation of WeBlog Application View
 Description: This class implements the WeBlogView interface, providing concrete methods
 for displaying menus, handling user input, and interacting with the blogger and blog services.
 It facilitates communication between the user and the underlying services in the application.
 */

package com.weblog.ui.viewer.impl;

import com.weblog.service.BlogService;
import com.weblog.service.BloggerService;
import com.weblog.ui.viewer.WeBlogView;
import java.util.Scanner;

public class WeBlogViewImpl implements WeBlogView {
    private final BloggerService bloggerService;
    private final BlogService blogService;
    public WeBlogViewImpl(BloggerService bloggerService, BlogService blogService) {
        this.bloggerService = bloggerService;
        this.blogService = blogService;
    }
    @Override
    public void showMenu() {
        System.out.println("1. Register as a blogger");
        System.out.println("2. List all registered bloggers");
        System.out.println("3. Post a blog");
        System.out.println("4. List all blogs");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    @Override
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
    @Override
    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    @Override
    public void getBloggerDetails(Scanner scanner) {
        bloggerService.registerBlogger(scanner);  // Passing `null` for now
    }
    @Override
    public void getBlogDetails(Scanner scanner) {
        blogService.postBlog(scanner);
    }
    @Override
    public void listBloggers() {
        bloggerService.listBloggers();
    }
    @Override
    public void listBlogs() {
        blogService.listBlogs();
    }
}
