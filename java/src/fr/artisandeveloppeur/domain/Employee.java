package fr.artisandeveloppeur.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    public final String firstname;
    public final String lastname;
    public final String mail;
    public final LocalDate birthday;

    private Employee(String firstname, String lastname, String mail, LocalDate birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.birthday = birthday;
    }

    public static Employee fromLine(String[] tokens) throws Exception {
        String firstname = tokens[0];
        String lastname = tokens[1];
        String mail = tokens[3];
        String readDate = tokens[2];

        validateBirthday(readDate, firstname, lastname);

        LocalDate birthday = parseBirthday(readDate);

        return new Employee(firstname, lastname, mail, birthday);
    }

    private static LocalDate parseBirthday(String readDate) {
        return LocalDate.parse(readDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static void validateBirthday(String readDate, String firstname, String lastname) throws Exception {
        String[] date = readDate.split("/");
        if (date.length < 3) throw new Exception("Cannot read birthdate for " + firstname + " " + lastname);
    }
}
