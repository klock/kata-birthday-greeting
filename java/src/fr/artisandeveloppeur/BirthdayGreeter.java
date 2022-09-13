package fr.artisandeveloppeur;

import java.time.LocalDate;

public class BirthdayGreeter {

    void processLine(String line) throws Exception {
        Employee employee = Employee.fromLine(line);

        if (isBirthday(employee.birthday)) {
            EmailBroker.sendEmail(employee.email, "Joyeux Anniversaire !", "Bonjour " + employee.firstname + ",\nJoyeux Anniversaire !\nA bientôt,");
        }
    }

    private boolean isBirthday(LocalDate birthday) {
        LocalDate now = LocalDate.now();
        return birthday.getMonth().equals(now.getMonth())
                && birthday.getDayOfMonth() == now.getDayOfMonth();
    }
}
