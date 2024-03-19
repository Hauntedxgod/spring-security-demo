package ru.maxima.dto;

import jakarta.validation.constraints.Min;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class AuthenticationDTO {

    @Min(value = 2 , message = "Lenght of username should be min 2 symbols")
    private String username;

    @Min(value = 2 , message = "Lenght of password should be min 2 symbols")
    private String password;
}
