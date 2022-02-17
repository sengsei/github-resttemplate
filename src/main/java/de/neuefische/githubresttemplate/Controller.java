package de.neuefische.githubresttemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/github")
public class Controller {

    private final GitHubService gitHubService;

    public Controller(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/{user}")
    public String[] getRepoNames(@PathVariable String user){

        Repo[] repos = gitHubService.getRepos(user);

        String[] repositoryNames = new String[repos.length];
        for (int i=0; i<repositoryNames.length; i++) {
            repositoryNames[i] = repos[i].getName();
        }
        return repositoryNames;

    }
}
