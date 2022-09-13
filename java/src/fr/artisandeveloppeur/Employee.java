package fr.artisandeveloppeur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    public final String firstname;
    public final String lastname;
    public final LocalDate birthday;
    public final String email;

    public Employee(String firstname, String lastname, LocalDate birthday, String email) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
    }

    public static Employee fromLine(String line) throws Exception {
        String[] tokens = parseLine(line);

        validateLineContent(tokens);
        String firstname = tokens[0];
        String lastname = tokens[1];

        validateBirthday(tokens[2], firstname, lastname);
        String birthdayStr = tokens[2];

        String email = tokens[3];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdayStr, formatter);

        return new Employee(firstname, lastname, birthday, email);
    }

    static boolean isDateValid(String dateStr) {
        String[] date = dateStr.split("/");
        return date.length == 3;
    }

    private static void validateLineContent(String[] tokens) throws Exception {
        if (tokens.length != 4) {
            throw new Exception("Invalid file format");
        }
    }

    private static String[] parseLine(String line) {
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }
        return tokens;
    }

    private static void validateBirthday(String birthday, String firstname, String lastname) throws Exception {
        if (!isDateValid(birthday)) {
            throw new Exception("Cannot read birthdate for " + firstname + " " + lastname);
        }
    }
}
