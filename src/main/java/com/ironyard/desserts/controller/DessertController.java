package com.ironyard.desserts.controller;


import com.ironyard.desserts.data.Friend;
import com.ironyard.desserts.service.FavoriteDessertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sam on 10/24/16.
 */
@RestController
public class DessertController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private FavoriteDessertService dessertRepo;

    @Autowired
    public void setDessertRepo(FavoriteDessertService dessertRepo) {
        this.dessertRepo = dessertRepo;
    }

    @RequestMapping(value = "/friend", method = RequestMethod.POST, produces = "application/json")
    public Friend save(@RequestBody Friend aFriend){
        dessertRepo.save(aFriend);
        return dessertRepo.findOne(aFriend.getId());
    }

    @RequestMapping(value = "/friendsdesserts", method = RequestMethod.GET)
    public Iterable<Friend> listAll(){
        Iterable<Friend> found = dessertRepo.findAll();
        return found;
    }

    @RequestMapping(value = "/friendsdesserts/delete/{id}", method = RequestMethod.DELETE)
    public Friend delete(@PathVariable long id){
        Friend deleted = dessertRepo.findOne(id);
        dessertRepo.delete(id);
        return deleted;
    }

    @RequestMapping(value = "/friendsdesserts/update", method = RequestMethod.PUT)
    public Friend update(@RequestBody Friend updatedFriend){
        dessertRepo.save(updatedFriend);
        return dessertRepo.findOne(updatedFriend.getId());
    }

    @RequestMapping(value = "/friendsdesserts/{id}", method = RequestMethod.GET)
    public Friend show(@PathVariable long id){
        Friend found = dessertRepo.findOne(id);
        return found;
    }

}
