package ru.maxima.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class PersonDTO {


    @NotEmpty(message = "Name should not to be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 30 characters")
    private String name;

    @Min(value = 2 , message = "Lenght of password should be min 2 symbols")
    private String password;

    @NotEmpty(message = "Email should")
    @Email(message = "Email is not valid")
    private String email;

    @Min(value = 0 , message = "Age should be more than 0")
    private Integer age;
}
