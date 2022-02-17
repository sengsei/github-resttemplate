package de.neuefische.githubresttemplate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHubResttemplateIntegrationTestWithMock {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private GitHubService gitHubService;

    @Test
    void shouldRetrieveRepoNames() {
        Repo repo1 = new Repo();
        repo1.setName("Repo 1");
        Repo repo2 = new Repo();
        repo2.setName("Repo 2");
        Repo repo3 = new Repo();
        repo3.setName("Repo 3");

        Repo[] repos = new Repo[3];
        repos[0] = repo1;
        repos[1] = repo2;
        repos[2] = repo3;

        String[] expectedNames = new String[3];
        expectedNames[0] = "Repo 1";
        expectedNames[1] = "Repo 2";
        expectedNames[2] = "Repo 3";

        Mockito.when(gitHubService.getRepos("sengsei")).thenReturn(repos);

        ResponseEntity<String[]> response = testRestTemplate.getForEntity("/github/sengsei", String[].class);

        assertArrayEquals(expectedNames, response.getBody());

    }
}
