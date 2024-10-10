package Api;

import Modelos.Conversion;
import Utilidades.JsonUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
  private final String url = "https://v6.exchangerate-api.com/v6/";
  private final String clave = "3de02cda6a1b79660e1276ad";

  public String generarUrlApi() {
    return url + clave;
  }

  public Conversion realizarConversion(String monedaBase, String monedaFinal, double monto) {
    String urlCompleta = generarUrlApi() + "/pair/" + monedaBase + "/" + monedaFinal + "/" + monto;
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(urlCompleta))
              .build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
      double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
      double conversionResult = jsonObject.get("conversion_result").getAsDouble();
      String hora = JsonUtil.obtenerHoraActual();

      return new Conversion(monedaBase, monto, monedaFinal, conversionRate, conversionResult, hora);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}

