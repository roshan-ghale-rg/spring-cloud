package com.ghale.business.reservation.reservationbusinessservices;

import com.ghale.business.reservation.reservationbusinessservices.domain.RoomReservation;
import com.ghale.business.reservation.reservationbusinessservices.feignClient.RoomService;
import com.ghale.business.reservation.reservationbusinessservices.domain.Room;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="RoomReservations", description = "Business process service operations on rooms and reservations", tags=("roomReservations"))
public class RoomReservationController {
    @Autowired
    private RoomService roomService; // To Enable the feign Clients.
    @Autowired
    private RoomReservationBusinessProcess businessProcess;

    /**
    @Autowired
     private RestTemplate restTemplate;

    @RequestMapping( value ="/rooms", method = RequestMethod.GET)
    public List<Room> getAllRooms(){
         ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange("http://ROOMSERVICES/rooms", HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
         });
         return  roomResponse.getBody();
    }
    **/

    /***
     * We are using the feign so as to simplify the service calls between the boundaries.
     * To integrate the Hystrix.
     * Its interface can be run as both the server and the feignClient.
     */
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ApiOperation(value="Get All Rooms", notes="Gets all rooms in the system", nickname="getRooms")
    public List<Room> getAllRooms(@RequestParam(name="roomNumber", required=false)String roomNumber){
        return this.roomService.findAll(roomNumber);
    }

    @RequestMapping(value="/roomReservations/{date}", method=RequestMethod.GET)
    @ApiOperation(value="Get Room Reservations", notes="Gets all reservations for a specific date", nickname="getReservationsForDate")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date){
        return this.businessProcess.getRoomReservationsForDate(date);
    }
    //Do for the Guest
}
