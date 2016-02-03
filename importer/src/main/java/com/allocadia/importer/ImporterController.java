package com.allocadia.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allocadia.importer.domain.Import;

/**
 * @author Khaled Ayoubi
 */
@RestController
public class ImporterController {
    @Autowired
    private ImportService importService;

    @RequestMapping("/")
    public Import getImport() {
        return importService.getImport();
    }


}

