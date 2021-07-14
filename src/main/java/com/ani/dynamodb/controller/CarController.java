package com.ani.dynamodb.controller;

import com.ani.dynamodb.CarRepository;
import com.ani.dynamodb.domain.Car;
import com.ani.dynamodb.dto.AppRes;
import com.ani.dynamodb.dto.CarDto;
import com.ani.dynamodb.util.AppResUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping(value = "/car")
@RestController
public class CarController {

    private final CarRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<AppRes<CarDto>> findCar(@PathVariable Integer id) {
        final var res = new AppRes<CarDto>();
        res.setDt(new CarDto(repository.findCar(id)));
        res.setMsg("car fetched");
        res.setSts("success");
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<AppRes<CarDto>> save(@RequestBody Car car) {
        final var res = AppRes.<CarDto>builder()
                .dt(new CarDto(repository.save(car)))
                .sts("success")
                .msg("saved car")
                .build();

        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity<AppRes<CarDto>> update(@RequestBody Car car) {
        return ResponseEntity.ok(
                AppResUtil.buildResponse(
                        new CarDto( repository.update(car)),
                        "car updated",
                        "success"
                )
        );
    }
}
