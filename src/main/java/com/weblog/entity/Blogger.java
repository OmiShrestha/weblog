/*
 Author: Omi Shrestha
 Blogger.java: Class for representing a Blogger
 Description: This class defines a Blogger object that holds information about a blogger,
 including their email, password, name, address, and interests. It provides constructors
 for initializing a blogger and getter/setter methods to retrieve the values of its fields.
 */
package com.weblog.entity;
public class Blogger {
    private String email;
    private String password;
    private String name;
    private String address;
    private String interests;

    // Default constructor
    public Blogger() {
    }
    // Constructor to initialize a blogger with email, password, name, address and interests.
    public Blogger(String email, String password, String name, String address, String interests) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.interests = interests;
    }

    // Getters for email, password, name, address and interests.
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getInterests() { return interests; }

    // Setters for email, password, name, address, and interests.
    /**
     * Sets the email of the blogger.
     *
     * @param email The email to set (must be a valid email format).
     * @throws IllegalArgumentException if the email format is invalid.
     */
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    /**
     * Sets the password of the blogger.
     *
     * @param password The password to set (must be at least 6 characters long).
     * @throws IllegalArgumentException if the password is less than 6 characters long.
     */
    public void setPassword(String password) {
        if (password != null && password.length() >= 6) { // Simple password length check
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
    }

    /**
     * Sets the name of the blogger.
     *
     * @param name The name to set (cannot be null or empty).
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    /**
     * Sets the address of the blogger.
     *
     * @param address The address to set (cannot be null or empty).
     * @throws IllegalArgumentException if the address is null or empty.
     */
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        this.address = address;
    }

    /**
     * Sets the interests of the blogger.
     *
     * @param interests The interests to set (cannot be null or empty).
     * @throws IllegalArgumentException if the interests are null or empty.
     */
    public void setInterests(String interests) {
        if (interests == null || interests.trim().isEmpty()) {
            throw new IllegalArgumentException("Interests cannot be null or empty.");
        }
        this.interests = interests;
    }
}
