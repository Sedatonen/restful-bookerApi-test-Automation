package models.response;

import lombok.Data;

public @Data class Booking{
	private String firstname;
	private String additionalneeds;
	private Bookingdates bookingdates;
	private int totalprice;
	private boolean depositpaid;
	private String lastname;
}