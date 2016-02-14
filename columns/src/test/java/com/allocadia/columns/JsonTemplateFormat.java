package com.allocadia.columns;

import org.springframework.restdocs.templates.TemplateFormat;

/**
 * @author Khaled Ayoubi
 */
public class JsonTemplateFormat implements TemplateFormat {
    private static final TemplateFormat JSON_FORMAT = new JsonTemplateFormat();

    public static TemplateFormat format() {
        return JSON_FORMAT;
    }

    private JsonTemplateFormat() {
    }

    @Override
    public String getId() {
        return "json";
    }

    @Override
    public String getFileExtension() {
        return "json";
    }
}
