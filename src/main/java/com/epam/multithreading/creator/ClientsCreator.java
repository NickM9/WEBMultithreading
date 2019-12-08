package com.epam.multithreading.creator;

import com.epam.multithreading.creator.util.InfoReader;
import com.epam.multithreading.entity.Car;
import com.epam.multithreading.entity.Client;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClientsCreator {

    public List<Client> createClients(File file) throws IOException {
        InfoReader infoReader = new InfoReader();
        List<Client> clients = infoReader.getClients(file);
        return clients;
    }

}
