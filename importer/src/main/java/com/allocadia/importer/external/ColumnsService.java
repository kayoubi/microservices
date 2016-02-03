package com.allocadia.importer.external;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allocadia.domain.Column;

import java.util.List;

/**
 * @author Khaled Ayoubi
 */
@FeignClient("columns")
public interface ColumnsService {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<Column> getColumns();
}
