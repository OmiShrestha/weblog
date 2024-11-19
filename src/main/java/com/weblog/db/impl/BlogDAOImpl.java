/*
 * Author: Omi Shrestha
 * BlogDAOImpl.java: Implementation of BlogDAO for Database Operations
 * Description: This class provides methods to post a new blog and list all blogs from the database.
 */

package com.weblog.db.impl;

import com.weblog.config.DBConfig;
import com.weblog.entity.Blog;
import com.weblog.db.BlogDAO;

import java.sql.*;

/**
 * Implementation of the BlogDAO interface for blog database operations.
 */
public class BlogDAOImpl implements BlogDAO {
    @Override
    // Inserts a new blog post into the database (only if the blogger is previously registered)
    public void postBlog(Blog blog) throws SQLException {

        // Generates the current timestamp to record when the blog is posted
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String sql = "INSERT INTO blog (title, body, is_private, date_time, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getBody());
            ps.setBoolean(3, blog.isPrivate());
            ps.setTimestamp(4, timestamp);
            ps.setString(5, blog.getEmail());
            ps.executeUpdate();
        }
        System.out.println();
    }

    @Override
    // Lists all blogs in the database
    public void listBlogs() throws SQLException {
        System.out.println("-----------------------------");
        String sql = "SELECT blog.id, blog.title, blog.body, blog.is_private, blog.date_time, blogger.name " +
                "FROM blog INNER JOIN blogger ON blog.email = blogger.email";
        try (Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Blog ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Body: " + rs.getString("body"));
                System.out.println("Private: " + rs.getBoolean("is_private"));
                System.out.println("Date/Time: " + rs.getTimestamp("date_time"));
                System.out.println("Blogger: " + rs.getString("name"));
                System.out.println("-----------------------------");
            }
        }
    }
}
