package com.allocadia.columns;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allocadia.domain.Column;

import java.util.Arrays;
import java.util.List;

/**
 * @author Khaled Ayoubi
 */
@RestController
public class ColumnsController {
    private List<Column> columns = Arrays.asList(
        new Column(1, "jan", "txt"),
        new Column(2, "feb", "calc")
    );

    @RequestMapping("/")
    public List<Column> columns() {
        return columns;
    }

    @RequestMapping("/{id}")
    public Column column(@PathVariable String id) {
        if (id.equals("1")) {
            return columns.get(0);
        }
        return columns.get(1);
    }
}

