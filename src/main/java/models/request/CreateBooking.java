package models.request;

import lombok.Builder;
import lombok.Data;

import static helper.HelperMetods.*;

@Builder
public @Data class CreateBooking{

	@Builder.Default
	private String firstname=getRandomFirstname();

	@Builder.Default
	private String lastname=getRandomLastname();

	@Builder.Default
	private int totalprice=getRandomTotalPrice();

	@Builder.Default
	private boolean depositpaid=getRandomDepositPaid();

	@Builder.Default
	private Bookingdates bookingdates=Bookingdates.builder().build();

	@Builder.Default
	private String additionalneeds=getRandomAdditionalNeeds();
	}