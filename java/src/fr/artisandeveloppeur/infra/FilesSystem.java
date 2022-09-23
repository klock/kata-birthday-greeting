package fr.artisandeveloppeur.infra;

import fr.artisandeveloppeur.IFilesSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FilesSystem implements IFilesSystem {
    @Override
    public List<String> readLines(String filename) {
        List<String> allLines = Collections.emptyList();
        try {
            allLines = Files.readAllLines(Paths.get(filename));

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filename + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + filename + "'");
        }
        return allLines;
    }
}
