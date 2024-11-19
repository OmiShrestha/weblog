/*
 * Author: Omi Shrestha
 * BlogDAO.java: Interface for Blog Database Operations
 * Description: Defines methods for posting and listing blogs.
 */

package com.weblog.db;

import com.weblog.entity.Blog;
import java.sql.SQLException;

/**
 * Interface for blog database operations.
 */
public interface BlogDAO {
    /**
     * Posts a new blog to the database.
     *
     * @param blog The blog to post.
     * @throws SQLException if a database error occurs.
     */
    void postBlog(Blog blog) throws SQLException;

    /**
     * Lists all blogs from the database.
     *
     * @throws SQLException if a database error occurs.
     */
    void listBlogs() throws SQLException;
}