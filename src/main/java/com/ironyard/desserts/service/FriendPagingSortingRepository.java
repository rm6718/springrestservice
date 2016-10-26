package com.ironyard.desserts.service;

import com.ironyard.desserts.data.Friend;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by reevamerchant on 10/26/16.
 */
public interface FriendPagingSortingRepository extends PagingAndSortingRepository<Friend, Long> {
}
