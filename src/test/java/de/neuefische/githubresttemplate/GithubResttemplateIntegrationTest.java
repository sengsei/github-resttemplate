package de.neuefische.githubresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GithubResttemplateIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldRetrieveRepoNames() {
        ResponseEntity<String[]> response = testRestTemplate.getForEntity("/github/sengsei", String[].class);
        assertTrue(response.getBody().length > 0);
    }

}
