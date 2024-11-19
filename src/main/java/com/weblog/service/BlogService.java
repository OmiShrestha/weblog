/*
 * Author: Omi Shrestha
 * BlogService.java: Service Interface for Blog Operations
 * Description: Defines methods for posting and listing blogs.
 */

package com.weblog.service;

import java.util.Scanner;

/**
 * Interface for Blog service operations.
 */
public interface BlogService {

    /**
     * Posts a new blog based on user input.
     *
     * @param scanner for reading user input
     */
    void postBlog(Scanner scanner);

    /**
     * Lists all blog posts.
     */
    void listBlogs();
}
