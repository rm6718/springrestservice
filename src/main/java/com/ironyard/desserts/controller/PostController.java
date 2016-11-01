package com.ironyard.desserts.controller;

import com.ironyard.desserts.dto.Posts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by reevamerchant on 10/27/16.
 */
@RestController
public class PostController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/service/posts", method = RequestMethod.GET)
    public Iterable<Posts> list(@RequestParam(value = "filter", required = false)String filter){
        log.debug("Request to list posts started.");
        RestTemplate restTemplate = new RestTemplate();
        Posts[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Posts[].class);
        log.info(posts.toString());
        log.debug("Fetched post.");
        List<Posts> foundAllList = Arrays.asList(posts);
        List<Posts> filteredList = new ArrayList<>();

        // only return posts that start with parameter name
        if(filter != null){
            // filter the list
            for(Posts aPost: foundAllList){
                if(aPost.getTitle().startsWith(filter)){
                    filteredList.add(aPost);
                }
            }
        }else{
            // just return all
            filteredList = foundAllList;
        }
        return filteredList;
    }

}


