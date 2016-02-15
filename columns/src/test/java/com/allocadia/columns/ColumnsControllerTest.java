package com.allocadia.columns;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.templates.TemplateFormats;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.allocadia.columns.WiremockDocument.wiremock;
import static org.springframework.restdocs.http.HttpDocumentation.httpResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Khaled Ayoubi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ColumnsApplication.class)
@WebAppConfiguration
//@WebIntegrationTest(randomPort = true)
public class ColumnsControllerTest {

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/test-classes/generated-snippets");

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
            .apply(documentationConfiguration(this.restDocumentation)
                .snippets()
                .withTemplateFormat(JsonTemplateFormat.format())
//                .withTemplateFormat(TemplateFormats.asciidoctor())
                .withDefaults(
                    wiremock(),
                    httpResponse()
                )
            )
            .build();
    }


    @Test
    public void testGetAll() throws Exception {
        this.mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("index",
                responseFields(
                    fieldWithPath("[]").description("array of columns"),
                    fieldWithPath("[].id").description("id of a column")
                )));
    }

    @Test
    public void testGetOne() throws Exception {
        this.mockMvc.perform(get("/1"))
            .andExpect(status().isOk())
            .andDo(print())
            .andDo(document("get"));
    }
}
