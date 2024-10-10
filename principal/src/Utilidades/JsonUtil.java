package Utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Modelos.Conversion;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class JsonUtil {
  private final List<Conversion> conversiones = new LinkedList<>();

  public void guardarConversion(Conversion conversion) {
    conversiones.add(conversion);
    try (FileWriter writer = new FileWriter("conversiones.json")) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(conversiones, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String obtenerHoraActual() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return LocalDateTime.now().format(formatter);
  }
}


