package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsheen on 5/1/17.
 */
public class WidgetImpl implements WidgetService {

    private List<Widget> widgets = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public int createWidget(String name, String type) {
        Widget widget = new Widget(name, type);
        widgets.add(widget);
        return widget.getId();
    }

    @Override
    public String listWidgets() throws IOException {
        return mapper.writeValueAsString(widgets);
    }

    @Override
    public String getWidget(int id) throws IOException {
        Widget widget = findWidgetById(id);
        if(widget != null){
            return mapper.writeValueAsString(widget);
        }
        return null;
    }

    @Override
    public boolean addAttachment(int id, String name, String type) {
        Widget widget = findWidgetById(id);
        if(widget != null){
          Widget.Attachment attachment = new Widget.Attachment();
          attachment.setName(name);
          attachment.setType(type);
          widget.getAttachments().add(attachment);
          return true;
        }
        return false;
    }

    private Widget findWidgetById (int id){
      for(Widget w : widgets){
          if(w.getId() == id){
              return w;
          }
      }
      return null;
    }
}
