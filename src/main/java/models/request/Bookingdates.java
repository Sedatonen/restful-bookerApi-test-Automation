package models.request;

import lombok.Builder;
import lombok.Data;

import static helper.HelperMetods.*;

@Builder
public @Data
class Bookingdates {

    @Builder.Default
    private String  checkin = getRandomCheckInDate();

    @Builder.Default
    private String checkout = getRandomCheckOutDate();
}