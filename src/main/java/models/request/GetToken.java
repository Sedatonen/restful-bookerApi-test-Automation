package models.request;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class GetToken {

    @Builder.Default
    private String password = "password123";

    @Builder.Default
    private String username = "admin";
}