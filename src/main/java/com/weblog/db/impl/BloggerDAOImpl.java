/*
 Author: Omi Shrestha
 BloggerDAO.java: Data Access Object for Blogger Operations
 Description: This class provides the data access layer for performing operations related to
 bloggers in the database. It includes methods for registering a new blogger and listing all
 bloggers. The password of the blogger is encrypted using BCrypt before being stored in the
 database. The class uses JDBC for database operations and Spring Security's BCryptPasswordEncoder
 for password encryption.

 Methods:
 - registerBlogger: Registers a new blogger by inserting their details into the 'blogger' and
   'blogger_interest' tables in the database.
 - listBloggers: Retrieves and displays all bloggers from the 'blogger' table.
 */

package com.weblog.db.impl;

import java.sql.*;

import com.weblog.config.DBConfig;
import com.weblog.entity.Blogger;
import com.weblog.db.BloggerDAO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Implementation of the BloggerDAO interface for blogger database operations.
 */
public class BloggerDAOImpl implements BloggerDAO {

    // BCrypt encoder with strength 14
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);

    @Override
    // Registers a new blogger
    public void registerBlogger(Blogger blogger) throws SQLException {
        String encodedPassword = encoder.encode(blogger.getPassword()); // Encrypts the blogger's password
        String sql1 = "INSERT INTO blogger (email, password, name, address) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO blogger_interest (email, interest) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
             PreparedStatement ps = conn.prepareStatement(sql1)) {
            ps.setString(1, blogger.getEmail());
            ps.setString(2, encodedPassword);
            ps.setString(3, blogger.getName());
            ps.setString(4, blogger.getAddress());
            ps.executeUpdate();
        }
        try (Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
             PreparedStatement ps = conn.prepareStatement(sql2)) {
            ps.setString(1, blogger.getEmail());
            ps.setString(2, blogger.getInterests());
            ps.executeUpdate();
        }
    }

    @Override
    // Lists all the bloggers
    public void listBloggers() throws SQLException {
        System.out.println("-----------------------------");
        String sql = "SELECT email, name, address FROM blogger";
        try (Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Email: " + rs.getString("email") +
                        ", Name: " + rs.getString("name") +
                        ", Address: " + rs.getString("address"));
            }
            System.out.println();
        }
    }
}
