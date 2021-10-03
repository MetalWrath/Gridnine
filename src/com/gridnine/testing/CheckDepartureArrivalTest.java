package com.gridnine.testing;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheckDepartureArrivalTest {

    CheckDepartureArrival checkDepartureArrival;
    List<Flight> listOfFlights;


    @Before
    public void setUp() throws Exception {
        System.out.println("Init the test param...");
        checkDepartureArrival = new CheckDepartureArrival();
        listOfFlights = new ArrayList<>(FlightBuilder.createFlights());
        System.out.println("Init is finish...");
    }


    @Test
    public void checkListMethod() {
        assertEquals(listOfFlights.size(), FlightBuilder.createFlights().size());

    }


    @After
    public void tearDown() throws Exception {
        System.out.println("Test is finish");
    }



}