package fr.artisandeveloppeur.infra;

import fr.artisandeveloppeur.domain.ports.ClockProvider;

import java.time.LocalDate;

public class RealClockProvider implements ClockProvider {
    @Override
    public LocalDate now() {
        return LocalDate.now();
    }
}
