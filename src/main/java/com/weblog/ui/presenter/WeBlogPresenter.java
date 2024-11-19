/*
 Author: Omi Shrestha
 WeBlogPresenter.java: Presenter for the WeBlog Application
 Description: This class serves as the presenter for the WeBlog application. It coordinates
 the interaction between the user and the view. It displays the menu, handles user input,
 and triggers the appropriate actions (such as getting blogger details, listing bloggers,
 getting blog details, listing blogs, and exiting). The presenter maintains a continuous loop
 until the user chooses to exit.
 */

package com.weblog.ui.presenter;

import com.weblog.ui.viewer.WeBlogView;
import java.util.Scanner;
public class WeBlogPresenter {
    private final WeBlogView view;
    public WeBlogPresenter(WeBlogView view) {
        this.view = view;
    }
    public void start(Scanner scanner) {
        while (true) {
            view.showMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    view.getBloggerDetails(scanner);
                    break;
                case 2:
                    view.listBloggers();
                    break;
                case 3:
                    view.getBlogDetails(scanner);
                    break;
                case 4:
                    view.listBlogs();
                    break;
                case 5:
                    view.showMessage("Exiting...");
                    return;
                default:
                    view.showError("Invalid choice. Try again.");
            }
        }
    }
}
