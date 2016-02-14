package com.allocadia.importer.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.allocadia.domain.Column;

import java.util.List;

/**
 * @author Khaled Ayoubi
 */
@Component
public class ColumnServiceImpl {
//    @Autowired
//    private RestTemplate restTemplate;

    public List<Column> getColumns() {
        ParameterizedTypeReference<List<Column>> responseType = new ParameterizedTypeReference<List<Column>>() { };
        ResponseEntity<List<Column>> exchange = new RestTemplate().exchange(
            "http://127.0.0.1:8181/",
            HttpMethod.GET, null, responseType);

//        RestTemplate restTemplate1 = new RestTemplate();
//        restTemplate1.getForObject()
        return exchange.getBody();
    }
}
