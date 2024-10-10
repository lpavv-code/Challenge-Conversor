package Errores;

import java.util.Scanner;

public class ManejadorErrores {
  public int validarOpcion(Scanner scanner) {
    while (true) {
      try {
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion >= 1 && opcion <= 7) {
          return opcion;
        } else {
          System.out.print("Opción inválida. Escoja una opción válida: ");
        }
      } catch (NumberFormatException e) {
        System.out.print("Entrada inválida. Escoja una opción válida: ");
      }
    }
  }

  public double validarMonto(Scanner scanner) {
    while (true) {
      try {
        double monto = Double.parseDouble(scanner.nextLine());
        if (monto > 0) {
          return monto;
        } else {
          System.out.print("Monto inválido. Ingrese un monto positivo: ");
        }
      } catch (NumberFormatException e) {
        System.out.print("Entrada inválida. Ingrese un monto válido: ");
      }
    }
  }

  public boolean validarContinuar(Scanner scanner) {
    while (true) {
      String respuesta = scanner.nextLine().trim().toLowerCase();
      if (respuesta.equals("s")) {
        return true;
      } else if (respuesta.equals("n")) {
        return false;
      } else {
        System.out.print("Entrada inválida. ¿Desea continuar? (s/n): ");
      }
    }
  }
}


