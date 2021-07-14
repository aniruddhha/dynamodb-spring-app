package com.ani.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.ani.dynamodb.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@AllArgsConstructor
@Repository
public class CarRepository {

    private final DynamoDBMapper mapper;

    public Car findCar(Integer id) {
        return mapper.load(Car.class, id);
    }

    public Car save(Car car) {
        mapper.save(car);
        return car;
    }

    public Car update(Car car) {
        mapper.save(car, buildExpression(car));
        return car;
    }

    private DynamoDBSaveExpression buildExpression(Car car) {
        final var exp = new DynamoDBSaveExpression();
        final var map = new HashMap<String, ExpectedAttributeValue>();
        map.put("id",
                new ExpectedAttributeValue(
                        new AttributeValue()
                                .withN(
                                        String.valueOf(car.getId())
                                )
                )
        );
        exp.setExpected(map);
        return exp;
    }
}
