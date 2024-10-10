package Servicios;

import Api.Api;
import Errores.ManejadorErrores;
import Modelos.Conversion;
import Utilidades.JsonUtil;

import java.util.Scanner;

public class ConversorServicio {
  private final Scanner scanner = new Scanner(System.in);
  private final Api api = new Api();
  private final ManejadorErrores manejadorErrores = new ManejadorErrores();
  private final JsonUtil jsonUtil = new JsonUtil();

  public void iniciar() {
    System.out.println("Bienvenido al Conversor de Monedas");
    while (true) {
      mostrarMenu();
      int opcion = manejadorErrores.validarOpcion(scanner);

      if (opcion == 7) {
        System.out.println("El sistema finalizará....!");
        break;
      }

      System.out.print("Ingrese el monto a convertir: ");
      double monto = manejadorErrores.validarMonto(scanner);

      String monedaBase = obtenerMonedaBase(opcion);
      String monedaFinal = obtenerMonedaFinal(opcion);

      Conversion conversion = api.realizarConversion(monedaBase, monedaFinal, monto);
      System.out.println("El cambio de " + monto + " [" + monedaBase + "] >> Tiene un valor de " + conversion.resultado() + " [" + monedaFinal + "]");

      jsonUtil.guardarConversion(conversion);

      System.out.print("¿Desea realizar otra conversión? (s/n): ");
      if (!manejadorErrores.validarContinuar(scanner)) {
        System.out.println("El sistema finalizará....!");
        break;
      }
    }
  }

  private void mostrarMenu() {
    System.out.println("*".repeat(30));
    System.out.println("Menú de Conversión de moneda");
    System.out.println("""
                1) Dólar (USD) >> Sol Peruano (PEN)
                2) Sol Peruano (PEN) >> Dólar (USD)
                3) Dólar (USD) >> Peso Uruguayo (UYU)
                4) Peso Uruguayo (UYU) >> Dólar (USD)
                5) Dólar (USD) >> Real Brasileño (BRL)
                6) Real Brasileño (BRL) >> Dólar (USD)
                7) Salir
                """);
    System.out.println("*".repeat(30));
    System.out.print("Escoja una opción: ");
  }

  private String obtenerMonedaBase(int opcion) {
    return switch (opcion) {
      case 1, 3, 5 -> "USD";
      case 2 -> "PEN";
      case 4 -> "UYU";
      case 6 -> "BRL";
      default -> "";
    };
  }

  private String obtenerMonedaFinal(int opcion) {
    return switch (opcion) {
      case 1 -> "PEN";
      case 2 -> "USD";
      case 3 -> "UYU";
      case 4 -> "USD";
      case 5 -> "BRL";
      case 6 -> "USD";
      default -> "";
    };
  }
}
