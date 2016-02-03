package com.allocadia.columns;

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
    @RequestMapping("/")
    public List<Column> columns() {
        return Arrays.asList(
            new Column(1, "jan", "txt"),
            new Column(2, "feb", "calc")
        );
    }
}

