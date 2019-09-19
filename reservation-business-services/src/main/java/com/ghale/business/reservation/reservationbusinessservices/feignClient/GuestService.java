package com.ghale.business.reservation.reservationbusinessservices.feignClient;


import com.ghale.business.reservation.reservationbusinessservices.domain.Guest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by frankmoley on 5/23/17.
 * //fallback = GuestServiceFallbackImpl.class
 */
@FeignClient(value = "GUESTSERVICES")
public interface GuestService {

    @RequestMapping(value="/guests", method= RequestMethod.GET)
    List<Guest> findAll(@RequestParam(name = "emailAddress", required = false) String emailAddress);

    @RequestMapping(value = "/guests/{id}", method = RequestMethod.GET)
    Guest findOne(@PathVariable(name = "id") long id);
}
