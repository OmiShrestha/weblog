/*
 Author: Omi Shrestha
 WeBlog.java: Main Application Class for WeBlog
 Description: This is the entry point of the WeBlog application. It initializes the necessary services,
 creates the viewer and presenter, and starts the application by passing user input via Scanner to the presenter.
 */

package com.weblog;

import com.weblog.service.BlogService;
import com.weblog.service.BloggerService;
import com.weblog.service.impl.BlogServiceImpl;
import com.weblog.service.impl.BloggerServiceImpl;
import com.weblog.ui.presenter.WeBlogPresenter;
import com.weblog.ui.viewer.impl.WeBlogViewImpl;

import java.util.Scanner;

public class WeBlog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BloggerService bloggerService = new BloggerServiceImpl();
        BlogService blogService = new BlogServiceImpl();

        // Creates the view
        WeBlogViewImpl view = new WeBlogViewImpl(bloggerService, blogService);

        // Creates the presenter
        WeBlogPresenter presenter = new WeBlogPresenter(view);

        // Starts the application, passing the scanner to the presenter
        presenter.start(scanner);

        // Closes scanner at the end of the program
        scanner.close();
    }
}
