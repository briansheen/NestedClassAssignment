package com.example;

import java.io.IOException;

/**
 * Created by bsheen on 5/1/17.
 */

public interface WidgetService {
    /** Creates a widget and returns the unique widget id */
    int createWidget(String name, String type);

    /** Returns a json representation of the list */
    String listWidgets() throws IOException;

    /** Returns the widget for the id or null if not found */
    String getWidget(int id) throws IOException;

    /** Add the attachment for the widget with the the id. Returns true if the attachment was add or false otherwise */
    boolean addAttachment(int id, String name, String type);
}

