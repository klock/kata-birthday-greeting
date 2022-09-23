package fr.artisandeveloppeur.domain.ports;

public interface MessageBroker {
    void sendMessage(String to, String title, String body);
}
