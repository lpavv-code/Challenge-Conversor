package Modelos;

public record Conversion(String base_code,
                         double monto,
                         String target_code,
                         double conversion_rate,
                         double conversion_result,
                         String fechaHora) {

  public double resultado() {
    return conversion_result;
  }
}