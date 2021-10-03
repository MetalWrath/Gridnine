package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class CheckMomentTime implements CheckListOfFly {
    @Override
    public void checkListMethod(List<Flight> listOfFlights) {
        List<Flight> tempListOfFlights = new ArrayList<>();
        System.out.println("----------------------------------------");
        System.out.println("Проверка на вылет до текущей даты.");
        for (Flight flight : listOfFlights) {
            boolean toAdd = true;
            List<Segment> tempList = flight.getSegments();
            for (Segment segment : tempList) {
                if (segment.getDepartureDate().toEpochSecond(ZoneOffset.UTC) <
                        LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)) {
                    toAdd = false;
                    System.out.println("Вылет до текущего момента времени: " + segment);
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
