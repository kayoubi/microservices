package com.allocadia.importer.domain;

import com.allocadia.domain.Column;

import java.util.List;

/**
 * @author Khaled Ayoubi
 */
public class Import {
    private int id;
    private String name;
    private List<Column> columns;

    public Import() {
    }

    public Import(int id, String name, List<Column> columns) {
        this.id = id;
        this.name = name;
        this.columns = columns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
