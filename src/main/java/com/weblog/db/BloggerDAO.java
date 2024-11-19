/*
 * Author: Omi Shrestha
 * BloggerDAO.java: Interface for Blogger Database Operations
 * Description: Defines methods for registering and listing bloggers.
 */

package com.weblog.db;

import com.weblog.entity.Blogger;
import java.sql.SQLException;

/**
 * Interface for blogger database operations.
 */
public interface BloggerDAO {
    /**
     * Registers a new blogger in the database.
     *
     * @param blogger The blogger to register.
     * @throws SQLException if a database error occurs.
     */
    void registerBlogger(Blogger blogger) throws SQLException;

    /**
     * Lists all bloggers from the database.
     *
     * @throws SQLException if a database error occurs.
     */
    void listBloggers() throws SQLException;
}