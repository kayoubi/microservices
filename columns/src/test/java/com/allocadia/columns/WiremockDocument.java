package com.allocadia.columns;

import org.springframework.restdocs.operation.Operation;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.restdocs.snippet.TemplatedSnippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * @author Khaled Ayoubi
 */
public abstract class  WiremockDocument {
    private WiremockDocument() {
    }

    public static Snippet wiremock() {
        return new WiremockSnippet(null);
    }
}

class WiremockSnippet extends TemplatedSnippet {
    public WiremockSnippet(Map<String, Object> attributes) {
        super("wiremock", attributes);
    }

    @Override
    protected Map<String, Object> createModel(Operation operation) {
        Map<String, Object> request = new HashMap<>();
        request.put("method", operation.getRequest().getMethod().toString());
        request.put("url", operation.getRequest().getUri().getPath());

        Map<String, Object> response = new HashMap<>();
        response.put("status", operation.getResponse().getStatus().value());
        response.put("body", new String(operation.getResponse().getContent()).replaceAll("\"", Matcher.quoteReplacement("\\\"")));
        response.put("headers", headers(operation));

        Map<String, Object> result = new HashMap<>();
        result.put("request", request);
        result.put("response", response);

        return result;
    }

    private List<Map<String, String>> headers(Operation operation) {
        List<Map<String, String>> headers = new ArrayList<>();
        for (Map.Entry<String, List<String>> header : operation.getResponse().getHeaders().entrySet()) {
            List<String> values = header.getValue();
            for (String value : values) {
                headers.add(header(header.getKey(), value));
            }
        }
        headers.get(headers.size()-1).put("last", "true");
        return headers;
    }

    private Map<String, String> header(String name, String value) {
        Map<String, String> header = new HashMap<>();
        header.put("name", name);
        header.put("value", value);
        return header;
    }
}
