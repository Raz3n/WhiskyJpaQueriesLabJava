package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whisky/year/{year}")
    public List<Whisky> findWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.findWhiskyByYear(year);
    }

    @GetMapping(value = "/whisky/{age}/distillery/{name}")
    public List<Whisky> findWhiskyByAgeAndDistillery(@PathVariable int age, @PathVariable String name){
        return whiskyRepository.findWhiskyByAgeAndDistilleryName(age,name);
    }

    @GetMapping(value = "/whisky/distillery/{region}")
    public List<Whisky> findWhiskyByRegion(@PathVariable String region){
        return whiskyRepository.findWhiskyByDistilleryRegion(region);
    }
}
