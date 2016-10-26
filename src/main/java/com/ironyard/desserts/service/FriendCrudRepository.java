package com.ironyard.desserts.service;

import com.ironyard.desserts.data.Friend;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sam on 10/24/16.
 */
public interface FriendCrudRepository extends CrudRepository<Friend, Long> {
}

