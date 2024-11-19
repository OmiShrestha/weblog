/*
 Author: Omi Shrestha
 WeBlogView.java: Interface for WeBlog Application View
 Description: Defines methods for displaying menus, showing messages, and handling user input
 in the WeBlog application. It ensures consistency across different view implementations.
 */

package com.weblog.ui.viewer;

import java.util.Scanner;

public interface WeBlogView {
    void showMenu();
    void showError(String message);
    void showMessage(String message);
    int getUserChoice();
    void getBloggerDetails(Scanner scanner);
    void getBlogDetails(Scanner scanner);
    void listBloggers();
    void listBlogs();
}
