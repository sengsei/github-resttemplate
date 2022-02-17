package de.neuefische.githubresttemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
    public Repo[] getRepos(String user){
        String url = "https://api.github.com/users/" + user + "/repos";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Repo[]> response = restTemplate.getForEntity(url, Repo[].class);
        return response.getBody();
    }
}
