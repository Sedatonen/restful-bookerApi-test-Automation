package models.response;

import lombok.Data;

public @Data class CreateResponse{
	private Booking booking;
	private int bookingid;
}