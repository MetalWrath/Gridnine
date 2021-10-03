package com.gridnine.testing;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> listOfFlights = new ArrayList<>(FlightBuilder.createFlights());
        System.out.println("Входящий список: ");
        for (Flight flight : listOfFlights){
            System.out.println(flight);
        }

        List<CheckListOfFly> checkList = Arrays.asList(new CheckMomentTime(), new CheckDepartureArrival(),
                new CheckTimeOnGround());

        for (CheckListOfFly cl : checkList) {
            cl.checkListMethod(listOfFlights);
        }

    }

}
