package br.com.fiap.abctechapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Negative;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLocationDto {
    private double latitude;
    private double longitude;
    @PastOrPresent
    private Date date;

}
