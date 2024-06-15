package org.example.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class FestivosLoader {

    private static final String FESTIVOS_FILE = "src/main/resources/festivos_colombia_2024.json";
    private static Set<String> festivosColombia = new HashSet<>();

    @PostConstruct
    public void loadFestivosFromJSON() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(FESTIVOS_FILE)) {
            // Parse JSON file
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray festivosArray = (JSONArray) jsonObject.get("festivos");

            // Convert JSON array to Set of Strings
            festivosColombia = new HashSet<>(festivosArray);
        } catch (IOException | ParseException e) {
            System.err.println("Error al cargar los festivos desde el archivo JSON: " + e.getMessage());
        }
    }

    public static Set<String> getFestivosColombia() {
        return festivosColombia;
    }
}