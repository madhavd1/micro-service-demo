package com.madhavd1.uiservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * UIController
 */
@RestController
@RequestMapping("/")
public class UIController {
    
    @Value("${hello-world.url}")
    private String helloWorldURL;

    @Value("${date-time-service.url}")
    private String dateTimeURL;

    public String HomePage(Model model){
        return "Index";
    }

    @GetMapping("/HelloWorldDateTime")
    public String HelloWorldDateTime(@RequestParam(name="name") String name) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(helloWorldURL + "/HelloWorld/"+name, String.class);
        String resp1= response.getBody();

        response = restTemplate.getForEntity(dateTimeURL + "/DateTime/", String.class);
        String resp2= response.getBody();

        return resp1+"<br>"+resp2;
    }
    
}