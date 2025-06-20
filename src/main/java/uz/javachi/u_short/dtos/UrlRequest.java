package uz.javachi.u_short.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UrlRequest {
    @NotBlank(message = "URL is required")
    @Length(max = 400, message = "Maximum URL length is should be lower than 400")
    @Pattern(regexp = "^https?://.*", message = "URL must start with http:// or https://")
    private String originalUrl;
}
