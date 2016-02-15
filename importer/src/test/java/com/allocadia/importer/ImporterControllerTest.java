package com.allocadia.importer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.allocadia.importer.domain.Import;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Khaled Ayoubi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ImporterApplication.class)
@WebIntegrationTest(randomPort = true)
public class ImporterControllerTest {
    @Rule
    public WireMockRule wm = new WireMockRule(
        WireMockConfiguration.wireMockConfig().port(8181).usingFilesUnderClasspath("generated-snippets"));

//    @Mock
//    private ImportService importService;
//
//    @InjectMocks
//    private ImporterController importerController;

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNothing() throws Exception {
        mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.columns[0].name", is("jan")));

//        assertEquals(1, importerController.getImport().getColumns().get(0).getId());
    }

    @Test
    public void testNothing2() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Import i = restTemplate.getForObject("http://localhost:{port}/", Import.class, port);
        assertEquals(1, i.getId());
        assertEquals(2, i.getColumns().size());
        assertEquals("feb", i.getColumns().get(1).getName());


//        assertEquals(1, importerController.getImport().getColumns().get(0).getId());
    }

}
