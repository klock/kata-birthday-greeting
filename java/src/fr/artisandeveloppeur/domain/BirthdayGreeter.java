package fr.artisandeveloppeur.domain;

import fr.artisandeveloppeur.domain.ports.ClockProvider;
import fr.artisandeveloppeur.domain.ports.MessageBroker;

import java.time.LocalDate;
import java.util.List;

public class BirthdayGreeter {
    private final MessageBroker messageBroker;
    private final ClockProvider clockProvider;

    public BirthdayGreeter(MessageBroker messageBroker, ClockProvider clockProvider) {
        this.messageBroker = messageBroker;
        this.clockProvider = clockProvider;
    }

    public void greetBirthday(List<String> employeeLines) {
        employeeLines.forEach(this::processLine);
    }

    private void processLine(String employeeLine) {
        try {
            String[] tokens = parseLine(employeeLine);

            Employee employee = Employee.fromLine(tokens);

            if (isBirthDay(employee.birthday)) {
                messageBroker.sendMessage(employee.mail, "Joyeux Anniversaire !", "Bonjour " + employee.firstname + ",\nJoyeux Anniversaire !\nA bientôt,");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] parseLine(String line) throws Exception {
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++)
            tokens[i] = tokens[i].trim();

        if (tokens.length != 4) {
            throw new Exception("Invalid file format");
        }
        return tokens;
    }

    private boolean isBirthDay(LocalDate birthday) {
        LocalDate now = clockProvider.now();
        return now.getMonth().equals(birthday.getMonth())
                && now.getDayOfMonth() == birthday.getDayOfMonth();
    }
}
