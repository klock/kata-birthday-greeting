package fr.artisandeveloppeur;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileName = "../employees.txt";
        processFile(fileName);
    }

    private static void processFile(String fileName) {
        try {
            System.out.println("Reading file...");
            List<String> allLines = Files.readAllLines(Paths.get(fileName));

            BirthdayGreeter birthdayGreeter = new BirthdayGreeter();

            for (int i = 1; i < allLines.size(); i++) {
                try {
                    birthdayGreeter.processLine(allLines.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Batch job done.");
        }
        catch(InvalidPathException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

}
