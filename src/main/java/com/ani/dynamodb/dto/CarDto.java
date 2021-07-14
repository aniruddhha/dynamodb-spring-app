package com.ani.dynamodb.dto;

import com.ani.dynamodb.domain.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarDto {
    private String name;
    private Integer model;
    private Double price;

    public CarDto(Car car) {
        this.name = car.getName();
        this.model = car.getModel();
        this.price = car.getPrice();
    }
}
