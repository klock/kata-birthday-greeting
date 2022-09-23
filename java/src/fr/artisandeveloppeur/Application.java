package fr.artisandeveloppeur;

import fr.artisandeveloppeur.domain.BirthdayGreeter;
import fr.artisandeveloppeur.domain.ports.ClockProvider;
import fr.artisandeveloppeur.domain.ports.MessageBroker;
import fr.artisandeveloppeur.infra.FilesSystem;
import fr.artisandeveloppeur.infra.MailBroker;
import fr.artisandeveloppeur.infra.RealClockProvider;

import java.util.List;

public class Application {
    public void handle() {
       MessageBroker messageBroker = new MailBroker();
       ClockProvider clockProvider = new RealClockProvider();
       IFilesSystem filesSystem = new FilesSystem();

       String filename = "../employees.txt";
       List<String> allLines = filesSystem.readLines(filename);

       System.out.println("Reading file...");
       BirthdayGreeter birthdayGreeter = new BirthdayGreeter(messageBroker, clockProvider);
       birthdayGreeter.greetBirthday(allLines.subList(1, allLines.size()));
       System.out.println("Batch job done.");
   }
}
