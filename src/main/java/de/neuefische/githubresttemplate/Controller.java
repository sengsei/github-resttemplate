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

    @GetMapping("/{user}")
    public List<String> getRepoNames(@PathVariable String user){


        String url = "https://api.github.com/users/" + user + "/repos";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Repo[]> result = restTemplate.getForEntity(url, Repo[].class);

        Repo[] repos = result.getBody();

        List<String> repoNames = new ArrayList<>();

        for (Repo repo : repos){
            repoNames.add(repo.getName());
        }
        return repoNames;

    }
}
