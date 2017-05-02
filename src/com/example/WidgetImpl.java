package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsheen on 5/1/17.
 */
public class WidgetImpl implements WidgetService {

    List<Widget> widgets = new ArrayList<>();

    @Override
    public int createWidget(String name, String type) {
        Widget widget = new Widget(name, type);
        widgets.add(widget);
        return widget.getId();
    }

    @Override
    public String listWidgets() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(widgets);
        return json;
    }

    @Override
    public String getWidget(int id) throws IOException {
        for(Widget w : widgets){
            if(w.getId() == id){
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(w);
                return json;
            }
        }
        return null;
    }

    @Override
    public boolean addAttachment(int id, String name, String type) {
        for (Widget w : widgets) {
            if (w.getId() == id) {
                Widget.Attachment attachment = new Widget.Attachment();
                attachment.setName(name);
                attachment.setType(type);
                w.getAttachments().add(attachment);
                return true;
            }
        }
        return false;
    }
}
