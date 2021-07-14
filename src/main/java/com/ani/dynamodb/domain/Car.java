package com.ani.dynamodb.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Car")
public class Car {

    @DynamoDBHashKey
    private Integer id;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private Integer model;

    @DynamoDBAttribute
    private Double price;
}
