package com.epam.multithreading.creator;

import com.epam.multithreading.creator.util.InfoReader;
import com.epam.multithreading.entity.Car;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarsCreator {

    public List<Car> createCars(File file) throws IOException {
        InfoReader infoReader = new InfoReader();
        List<Car> cars = infoReader.getCars(file);
        return cars;
    }

}
