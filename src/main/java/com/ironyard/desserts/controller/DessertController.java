package com.ironyard.desserts.controller;


import com.ironyard.desserts.data.Friend;
import com.ironyard.desserts.service.FriendCrudRepository;
import com.ironyard.desserts.service.FriendPagingSortingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sam on 10/24/16.
 */
@RestController
public class DessertController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private FriendCrudRepository dessertRepo;
    private FriendPagingSortingRepository frndPgStRepo;


    @Autowired
    public void setFrndPgStRepo(FriendPagingSortingRepository frndPgStRepo) { this.frndPgStRepo = frndPgStRepo; }

    @Autowired
    public void setDessertRepo(FriendCrudRepository dessertRepo) {
        this.dessertRepo = dessertRepo;
    }

    @RequestMapping(value = "/service/friend", method = RequestMethod.POST, produces = "application/json")
    public Friend save(@RequestBody Friend aFriend){
        dessertRepo.save(aFriend);
        return dessertRepo.findOne(aFriend.getId());
    }

    @RequestMapping(value = "/service/friendsdesserts", method = RequestMethod.GET)
    public Iterable<Friend> listAll(){
        Iterable<Friend> found = dessertRepo.findAll();
        return found;
    }

    @RequestMapping(value = "/service/friendsdesserts/delete/{id}", method = RequestMethod.DELETE)
    public Friend delete(@PathVariable long id){
        Friend deleted = dessertRepo.findOne(id);
        dessertRepo.delete(id);
        return deleted;
    }

    @RequestMapping(value = "/service/friendsdesserts/update", method = RequestMethod.PUT)
    public Friend update(@RequestBody Friend updatedFriend){
        dessertRepo.save(updatedFriend);
        return dessertRepo.findOne(updatedFriend.getId());
    }

    @RequestMapping(value = "/service/friendsdesserts/{id}", method = RequestMethod.GET)
    public Friend show(@PathVariable long id){
        Friend found = dessertRepo.findOne(id);
        return found;
    }


    @RequestMapping(value = "/service/friendsdesserts/list", method = RequestMethod.GET)
    public Iterable<Friend> listAll(@RequestParam(value = "page") Integer page,
                                    @RequestParam("size") Integer size,
                                    @RequestParam(value = "sortby", required = false) String sortby,
                                    @RequestParam(value = "dir", required = false) Sort.Direction direction) {

        Iterable<Friend> found = null;

        if (sortby == null) {
            sortby = "name";
        }

        if (direction == null) {
            direction = Sort.Direction.ASC;
        }

        //long way
        Sort s = new Sort(direction, sortby);
        PageRequest pr = new PageRequest(page, size, s);
        found = frndPgStRepo.findAll(pr);


        //short way
        //found = frndPgStRepo.findAll(new PageRequest(page, size, new Sort(direction, sortby)));

        return found;
    }
}
