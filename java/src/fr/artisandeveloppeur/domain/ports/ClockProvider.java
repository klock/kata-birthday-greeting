package fr.artisandeveloppeur.domain.ports;

import java.time.LocalDate;

public interface ClockProvider {
    LocalDate now();
}
