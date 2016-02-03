package com.allocadia.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.allocadia.importer.domain.Import;
import com.allocadia.importer.external.ColumnsService;

/**
 * @author Khaled Ayoubi
 */
@Component
public class ImportService {
    @Autowired
    private ColumnsService columnsService;

    public Import getImport() {
        return new Import(1, "the import", columnsService.getColumns());
    }
}
