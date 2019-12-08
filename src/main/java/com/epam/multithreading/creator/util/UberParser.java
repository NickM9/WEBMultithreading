package com.epam.multithreading.creator.util;

import com.epam.multithreading.entity.Car;
import com.epam.multithreading.entity.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UberParser {

    private static final String carRegEx = "\\d+$";
    private static final String clientsRegEx = "\\d+\\s\\d+$";
    private static int carId = 0;
    private static int clientId = 0;

    private static final Logger logger = LogManager.getLogger();

    public Car parseCar(String str) {

        Pattern carPattern = Pattern.compile(carRegEx);
        Matcher carMatcher = carPattern.matcher(str);
        Car result = null;

        if (carMatcher.find()) {
            int location = Integer.parseInt(str);
            carId++;
            result = new Car(carId, location);
            logger.info("The Car created " + result.toString());
        } else {
            logger.warn("input incorrect line " + str);
        }

        return result;
    }

    public Client parseClint(String str){

        Pattern clientPattern = Pattern.compile(clientsRegEx);
        Matcher clientMatcher = clientPattern.matcher(str);
        Client result = null;

        if (clientMatcher.find()){
            String[] locations = str.split(" ");
            int localPosition = Integer.parseInt(locations[0]);
            int destinationPosition = Integer.parseInt(locations[1]);
            clientId++;
            result = new Client(clientId, localPosition, destinationPosition);
            logger.info("The Client created " + result.toString());
        } else {
            logger.warn("input incorrect line " + str);
        }

        return result;
    }

}
