package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllWhiskyByYear(){
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetAllDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetWhiskyByAgeAndDistillery(){
		List<Whisky> found = whiskyRepository.findWhiskyByAgeAndDistilleryName(25, "Macallan");
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}

	@Test
	public void canGetWhiskyByRegion(){
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryRegion("Highland");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleryByWhiskyAge(){
		List<Distillery> found = distilleryRepository.findDistilleryByWhiskiesAge(12);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleryByWhiskyAge12(){
		List<Distillery> found = distilleryRepository.findDistilleryThatHaveWhiskiesAge12();
		assertEquals(2, found.size());
	}


}
