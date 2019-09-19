package com.ghale.business.reservation.reservationbusinessservices.feignClient;

import com.ghale.business.reservation.reservationbusinessservices.domain.Guest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by ghale on 5/25/17.
 */
@Component
public class GuestServiceFallbackImpl{
    //@Override
    public List<Guest> findAll(String emailAddress) {
        return Collections.emptyList();
    }

   // @Override
    public Guest findOne(long id) {
        Guest guest = new Guest();
        guest.setFirstName("Guest");
        guest.setLastName("Occupied");
        return guest;
    }
}
