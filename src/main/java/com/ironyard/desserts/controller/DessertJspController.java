package com.ironyard.desserts.controller;

import com.ironyard.desserts.data.Friend;
import com.ironyard.desserts.service.FriendCrudRepository;
import com.ironyard.desserts.service.FriendPagingSortingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by reevamerchant on 10/31/16.
 */
@Controller
public class DessertJspController {

    private FriendCrudRepository dessertRepo;
    private FriendPagingSortingRepository frndPgStRepo;

    @RequestMapping(value = "/sleepover/friends", method = RequestMethod.GET)
    public String listAll(@RequestParam Map<String, Object> model){
        Iterable<Friend> found = dessertRepo.findAll();
        model.put("friends", found);
        return "index";
    }

}
