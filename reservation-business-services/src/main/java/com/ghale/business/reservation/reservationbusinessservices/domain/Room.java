package com.ghale.business.reservation.reservationbusinessservices.domain;

/**
 * Don't use the same Room of the Room service
 * because of the dependency that you dont need it like JPA.
 */
public class Room {
    private long roomId;
    private String name;
    private String roomNumber;
    private String bedInfo;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }
}
