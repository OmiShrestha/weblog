/*
 * Author: Omi Shrestha
 * BloggerService.java: Service Interface for Blogger Operations
 * Description: Defines methods for registering and listing bloggers.
 */

package com.weblog.service;

import java.util.Scanner;

/**
 * Service Interface for Blogger Operations.
 */
public interface BloggerService {

    /**
     * Prompts for blogger details via Scanner and registers a new blogger.
     *
     * @param scanner the Scanner object used to read user input
     */
    void registerBlogger(Scanner scanner);

    /**
     * Lists all registered bloggers.
     */
    void listBloggers();
}
