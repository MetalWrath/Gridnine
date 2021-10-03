package com.gridnine.testing;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class CheckDepartureArrival implements CheckListOfFly {
    @Override
    public void checkListMethod(List<Flight> listOfFlights) {
        List<Flight> tempListOfFlights = new ArrayList<>();
        System.out.println("----------------------------------------");
        System.out.println("Проверка даты вылета/прилета.");
        for (Flight flight : listOfFlights) {
            boolean toAdd = true;
            List<Segment> tempList = flight.getSegments();
            for (Segment segment : tempList) {
                if (segment.getDepartureDate().toEpochSecond(ZoneOffset.UTC) >
                        segment.getArrivalDate().toEpochSecond(ZoneOffset.UTC)) {
                    toAdd = false;
                    System.out.println("Дата прилета раньше даты вылета: " + segment);
                }
            }
            if (toAdd){
                tempListOfFlights.add(flight);
            }
        }
        System.out.println("Исправленный список: ");
        for (Flight flight : tempListOfFlights){
            System.out.println(flight);
        }

    }

}
