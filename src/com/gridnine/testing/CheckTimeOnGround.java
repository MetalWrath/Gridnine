package com.gridnine.testing;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class CheckTimeOnGround implements CheckListOfFly {
    @Override
    public void checkListMethod(List<Flight> listOfFlights) {
        List<Flight> tempListOfFlights = new ArrayList<>();
        System.out.println("----------------------------------------");
        System.out.println("Проверка времени между посадкой и следующим вылетом.");
        for (Flight flight : listOfFlights) {
            boolean toAdd = true;
            List<Segment> tempList = flight.getSegments();
            if (tempList.size() > 1) {
                for (int i = 0; i < tempList.size() - 1; i++) {
                    if (tempList.get(i + 1).getDepartureDate().toEpochSecond(ZoneOffset.UTC) -
                            tempList.get(i).getArrivalDate().toEpochSecond(ZoneOffset.UTC) > 7200) {
                        toAdd = false;
                        System.out.println("Время на земле более двух часов между следующими рейсами(сегментами) " +
                                tempList.get(i) + " и " + tempList.get(i + 1));

                    }
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
