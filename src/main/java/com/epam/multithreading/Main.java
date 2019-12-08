package com.epam.multithreading;

import com.epam.multithreading.creator.CarsCreator;
import com.epam.multithreading.creator.ClientsCreator;
import com.epam.multithreading.entity.Car;
import com.epam.multithreading.entity.Client;
import com.epam.multithreading.service.UberService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File carsFile = new File("data/cars.txt");
        CarsCreator carsCreator = new CarsCreator();
        List<Car> cars = carsCreator.createCars(carsFile);
        // Clients
        File clientsFile = new File("data/passengers.txt");
        ClientsCreator clientsCreator = new ClientsCreator();
        List<Client> clients = clientsCreator.createClients(clientsFile);


        // service
        UberService.setCarList(cars);
        UberService.setClientsList(clients);
        UberService.getInstance().run();

    }
}
