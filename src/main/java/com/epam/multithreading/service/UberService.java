package com.epam.multithreading.service;

import com.epam.multithreading.entity.Car;
import com.epam.multithreading.entity.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class UberService implements Runnable {

    private static UberService uberService;
    private static List<Car> carList = new ArrayList<>();
    private static List<Client> clientsList = new ArrayList<>();

    private static ReentrantLock lock = new ReentrantLock();
    private static Logger logger = LogManager.getLogger();

    private UberService(){}

    @Override
    public void run() {
        Car nearestCar = new Car(Integer.MIN_VALUE, Integer.MAX_VALUE);

        while (!clientsList.isEmpty()){
            int clientLocation = clientsList.get(0).getLocalPosition();

            for (Car car : carList){
                int carLocation = car.getLocalPosition().get();
                boolean nearestDifference = Math.abs(clientLocation - carLocation) <
                                            Math.abs(clientLocation - nearestCar.getLocalPosition().get());

                if (!car.getWithPassenger().get() && nearestDifference){
                    nearestCar = car;
                }

            }

            Thread thread = new Thread(nearestCar);
            thread.start();

            logger.info(nearestCar.toString() + " with " + clientsList.get(0).toString());

            nearestCar.getLocalPosition().set(clientsList.get(0).getDestinationPosition());
            clientsList.remove(0);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.getMessage();
            }

        }

    }

    public static UberService getInstance(){

        if (uberService == null){
            lock.lock();

            if (uberService == null){
                uberService = new UberService();
            }

            lock.unlock();
        }

        return uberService;
    }

    public static List<Car> getCarList() {
        return carList;
    }

    public static List<Client> getClientsList() {
        return clientsList;
    }

    public static void setCarList(List<Car> carList) {
        UberService.carList = carList;
        Collections.copy(UberService.carList, carList);
    }

    public static void setClientsList(List<Client> clientsList) {
        UberService.clientsList = clientsList;
        Collections.copy(UberService.clientsList, clientsList);
    }
}
