package com.epam.multithreading.creator.util;

import com.epam.multithreading.entity.Car;
import com.epam.multithreading.entity.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InfoReader {

    private static final Logger logger = LogManager.getLogger();

    public List<Car> getCars(File file) throws IOException {
        List<Car> cars = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while (reader.ready()){
                String str = reader.readLine();
                UberParser uberParser = new UberParser();
                cars.add(uberParser.parseCar(str));
            }

        }

        logger.info("Cars data uploaded");
        return cars;
    }

    public List<Client> getClients(File file) throws IOException{
        List<Client> clients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while (reader.ready()){
                String str = reader.readLine();
                UberParser uberParser = new UberParser();
                clients.add(uberParser.parseClint(str));
            }

        }

        logger.info("Clients data uploaded");
        return clients;
    }

}
