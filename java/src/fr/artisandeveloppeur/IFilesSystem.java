package fr.artisandeveloppeur;

import java.util.List;

public interface IFilesSystem {
    List<String> readLines(String filename);
}
