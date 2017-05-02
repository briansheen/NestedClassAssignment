package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsheen on 5/1/17.
 */
public class Widget {

    private static int widgetCounter;
    private String name;
    private String type;
    private int id;
    private List<Attachment> attachments = new ArrayList<>();

    public Widget(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = ++widgetCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    static class Attachment{
        private String name;
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Attachment{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Widget{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", attachments=" + attachments +
                '}';
    }
}
