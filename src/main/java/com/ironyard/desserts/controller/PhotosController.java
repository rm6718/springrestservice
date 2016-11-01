package com.ironyard.desserts.controller;

import com.ironyard.desserts.dto.Photos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
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
public class PhotosController {

    // attribute
     private final Logger log = LoggerFactory.getLogger(this.getClass());

        @RequestMapping(value = "/service/photos", method = RequestMethod.GET)
        public Iterable<Photos> list(@RequestParam(value = "filter", required = false)String filter){
            log.debug("Request to get albums started.");
            RestTemplate restTemplate = new RestTemplate();
            //Photos[] albums = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", Photos[].class);
            // to get around the API security
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<Photos[]> respEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/photos",
                    HttpMethod.GET, entity, Photos[].class);
            Photos[] albums = respEntity.getBody();


            log.info(albums.toString());
            log.debug("Fetch albums complete.");
            List<Photos> foundAllList = Arrays.asList(albums);
            List<Photos> filteredList = new ArrayList<>();

            // only return albums that start with parameter name

            if(filter != null){

                // filter the list

                for(Photos aAlbum: foundAllList){
                    if(aAlbum.getTitle() != null && aAlbum.getTitle().startsWith(filter)){
                        filteredList.add(aAlbum);
                    }
                }
            }else{
                // just return all
                filteredList = foundAllList;
            }
            return filteredList;
        }

    }


