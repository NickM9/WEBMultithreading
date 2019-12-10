package com.epam.multithreading.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable{

    private int id;
    private AtomicInteger localPosition;
    private AtomicBoolean withPassenger;

    public Car(int id, int localPosition) {
        this.id = id;
        this.localPosition = new AtomicInteger(localPosition);
        this.withPassenger = new AtomicBoolean(false);
    }

    @Override
    public void run() {

        withPassenger.set(true);
        //System.out.println(this.toString() + " On the road");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.getMessage();
        }

        withPassenger.set(false);
        //System.out.println(this.toString() + " Arrived");
    }

    public int getId() {
        return id;
    }

    public AtomicInteger getLocalPosition() {
        return localPosition;
    }

    public AtomicBoolean getWithPassenger() {
        return withPassenger;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (localPosition != null ? !localPosition.equals(car.localPosition) : car.localPosition != null) return false;
        return withPassenger != null ? withPassenger.equals(car.withPassenger) : car.withPassenger == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (localPosition != null ? localPosition.hashCode() : 0);
        result = 31 * result + (withPassenger != null ? withPassenger.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", localPosition=" + localPosition +
                ", withPassenger=" + withPassenger +
                '}';
    }
}
