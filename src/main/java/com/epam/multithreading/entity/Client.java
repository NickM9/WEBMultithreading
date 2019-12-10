package com.epam.multithreading.entity;

public class Client {

    private int id;
    private int localPosition;
    private int destinationPosition;

    public Client(int id, int localPosition, int destinationPosition) {
        this.id = id;
        this.localPosition = localPosition;
        this.destinationPosition = destinationPosition;
    }

    public int getId() {
        return id;
    }

    public int getLocalPosition() {
        return localPosition;
    }

    public int getDestinationPosition() {
        return destinationPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (localPosition != client.localPosition) return false;
        return destinationPosition == client.destinationPosition;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + localPosition;
        result = 31 * result + destinationPosition;
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", localPosition=" + localPosition +
                ", destinationPosition=" + destinationPosition +
                '}';
    }
}
