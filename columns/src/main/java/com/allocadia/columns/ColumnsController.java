package com.allocadia.columns;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Khaled Ayoubi
 */
@RestController
public class ColumnsController {
    @RequestMapping("/")
    public List<Column> columns() {
        return Arrays.asList(
            new Column(1, "jan", "txt"),
            new Column(2, "feb", "calc")
        );
    }
}

class Column {
    public Column(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    private int id;
    private String name;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
