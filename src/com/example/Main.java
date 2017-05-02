package com.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Foo foo = new Foo() {
            @Override
            public boolean bar(String in) {
                if(in!=null && in.trim().isEmpty()){
                    return true;
                }
                return false;
            }
        };
        System.out.println(foo.bar("hi"));
        System.out.println(foo.bar(""));
        System.out.println(foo.bar("    "));
        System.out.println(foo.bar("  .   "));
        System.out.println(foo.bar("hello world!"));

        WidgetService widgetService = new WidgetImpl();
        System.out.println("widget number " + widgetService.createWidget("Clock","Daily") + " has been created.");
        System.out.println("widget number " + widgetService.createWidget("Calendar","Productivity") + " has been created.");
        System.out.println("widget number " + widgetService.createWidget("Weather","Daily") + " has been created.");
        System.out.println("widget number " + widgetService.createWidget("Email","Productivity") + " has been created.");
        System.out.println("widget number " + widgetService.createWidget("To Do List","Productivity") + " has been created.");
        System.out.println("widget number " + widgetService.createWidget("Quote Of The Day","Fun") + " has been created.");

        String json = widgetService.listWidgets();
        System.out.println(json);
        json = widgetService.getWidget(3);
        System.out.println(json);

        boolean attachment = widgetService.addAttachment(1,"Analog", "Skin");
        System.out.println("attachment added to Widget 1: " + attachment);
        widgetService.addAttachment(1,"Digital", "Skin");
        widgetService.addAttachment(3,"Austin", "Local Weather");
        attachment = widgetService.addAttachment(99,"Nothing", "Useless");
        System.out.println("attachment added to Widget 99: " + attachment);

        json = widgetService.listWidgets();
        System.out.println(json);

        json = widgetService.getWidget(1);
        System.out.println(json);
        json = widgetService.getWidget(3);
        System.out.println(json);

    }

    interface Foo {
        /** returns true if parameter is not null and is either empty or only has white spaces */
        boolean bar(String in);
    }
}
