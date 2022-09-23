package fr.artisandeveloppeur.infra;

import fr.artisandeveloppeur.domain.ports.MessageBroker;

public class MailBroker implements MessageBroker {
    @Override
    public void sendMessage(String to, String title, String body) {
        System.out.println("Sending email to : " + to);
        System.out.println("Title: " + title);
        System.out.println("Body: Body\n" + body);
        System.out.println("-------------------------");
    }
}
