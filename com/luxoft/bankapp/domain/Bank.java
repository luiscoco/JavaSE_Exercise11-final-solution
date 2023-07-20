package com.luxoft.bankapp.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients;
    private List<ClientRegistrationListener> listeners;
    private int printedClients;
    private int emailedClients;
    private int debuggedClients;

    public Bank() {
        clients = new ArrayList<>();
        listeners = new ArrayList<>();
        listeners.add(new PrintClientListener());
        listeners.add(new EmailNotificationListener());
        listeners.add(new DebugListener());
        printedClients = 0;
        emailedClients = 0;
        debuggedClients = 0;
    }

    public void addClient(Client client) {
        clients.add(client);

        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }

    public void addAccount(Account account) {
        Client client = new Client("New Client");
        clients.add(client);

        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public int getPrintedClients() {
        return printedClients;
    }

    public int getEmailedClients() {
        return emailedClients;
    }

    public int getDebuggedClients() {
        return debuggedClients;
    }

    private class PrintClientListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client client) {
            System.out.println("Printing added client: " + client.getName());
            printedClients++;
        }
    }

    private class EmailNotificationListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client client) {
            System.out.println("Sending email notification for client " + client.getName());
            emailedClients++;
        }
    }

    private class DebugListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client client) {
            System.out.println("Debugging client: " + client.getName() + " at " + LocalDateTime.now());
            debuggedClients++;
        }
    }
}
