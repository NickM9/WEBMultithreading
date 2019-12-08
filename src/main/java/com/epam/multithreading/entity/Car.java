package com.epam.multithreading.entity;

import java.util.concurrent.TimeUnit;

public class Car implements Runnable{

    private int id;
    private int localPosition;
    private boolean withPassenger;

    public Car(int id, int localPosition) {
        this.id = id;
        this.localPosition = localPosition;
    }

    @Override
    public void run() {

        withPassenger = true;
        //System.out.println(this.toString() + " On the road");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.getMessage();
        }

        withPassenger = false;
        //System.out.println(this.toString() + " Arrived");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocalPosition() {
        return localPosition;
    }

    public void setLocalPosition(int localPosition) {
        this.localPosition = localPosition;
    }

    public boolean isWithPassenger() {
        return withPassenger;
    }

    public void setWithPassenger(boolean withPassenger) {
        this.withPassenger = withPassenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (localPosition != car.localPosition) return false;
        return withPassenger == car.withPassenger;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + localPosition;
        result = 31 * result + (withPassenger ? 1 : 0);
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
