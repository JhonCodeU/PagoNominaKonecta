package org.example.service;

import org.example.util.FestivosLoader;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
public class NominaService {

    public String nextPayDate(String inputDate) {
        Set<String> festivosColombia = FestivosLoader.getFestivosColombia();

        LocalDate date = LocalDate.parse(inputDate);
        int dayOfMonth = date.getDayOfMonth();
        int nextPayDay = (dayOfMonth <= 15) ? 15 : 30;

        LocalDate nextPayDate = LocalDate.of(date.getYear(), date.getMonth(), nextPayDay);

        // Verificar si el próximo día de pago cae en festivo o fin de semana
        while (festivosColombia.contains(nextPayDate.format(DateTimeFormatter.ISO_DATE)) ||
                nextPayDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                nextPayDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            nextPayDate = nextPayDate.minusDays(1); // Retroceder un día
        }

        return nextPayDate.format(DateTimeFormatter.ISO_DATE);
    }
}

