# Conversor de Monedas
![Static Badge](https://img.shields.io/badge/Java-22-green?style=flat) ![Static Badge](https://img.shields.io/badge/Version-1.0.0-red?style=flat) ![Static Badge](https://img.shields.io/badge/Estado-En_Desarrollo-gold?style=flat)

## Descripción

Este es un programa de consola para la conversión de monedas utilizando una API externa. El programa está desarrollado en **Java** y sigue los principios de la **Programación Orientada a Objetos (POO)**. Utiliza varias bibliotecas y técnicas avanzadas como manejo de errores, listas enlazadas, y generación de archivos JSON.

## Características

- Conversión de monedas entre varias divisas (USD, PEN, UYU, BRL).
- Conexión a una API externa para obtener las tasas de cambio.
- Guardado de cada conversión en un archivo JSON.
- Validación de entradas del usuario para asegurar datos correctos.
- Menú interactivo para seleccionar las opciones de conversión.

> [!NOTE]
>
> - Se toma como referencia la divisa principal del (USD), por ser una de las monedas mas importantes a nivel mundial.
>
> - Se toma también como referencialas divisas (PEN, UYU, BRL), por ser las monedas mas estables a nivel de latinoamerica del 2024.

## Requisitos

- **Java 22** o superior.
- **IntelliJ IDEA** como IDE de desarrollo.
- Biblioteca **Gson** para manejo de JSON.

## Instalación

1. Clona este repositorio en tu máquina local:

   ```sh
   git clone https://github.com/tu-usuario/conversor-monedas.git
   ```

2. Abre el proyecto en IntelliJ IDEA.

3. Asegúrate de tener la biblioteca Gson en tu proyecto. Puedes agregarla a través de Maven o descargando el JAR manualmente.

## Uso

1. Ejecuta la clase principal `ConversorMonedas` desde IntelliJ IDEA.

2. Al iniciar el programa, verás un menú con las opciones de conversión disponibles:

   ```plaintext
   ******************************
   Menú de Conversión de moneda
   1) Dólar (USD) >> Sol Peruano (PEN)
   2) Sol Peruano (PEN) >> Dólar (USD)
   3) Dólar (USD) >> Peso Uruguayo (UYU)
   4) Peso Uruguayo (UYU) >> Dólar (USD)
   5) Dólar (USD) >> Real Brasileño (BRL)
   6) Real Brasileño (BRL) >> Dólar (USD)
   7) Salir
   ******************************
   Escoja una opción:
   ```

3. Selecciona la opción deseada e ingresa el monto a convertir.

4. El programa mostrará el resultado de la conversión y te preguntará si deseas realizar otra conversión.

5. Cada conversión se guardará en un archivo `conversiones.json` con el siguiente formato:
   ```json
   {
     "Moneda_Inicial": "USD",
     "Monto": 50.0,
     "Moneda_Destino": "PEN",
     "Tipo_Cambio": 3.7248,
     "Cambio_Total": 186.24,
     "Fecha_Hora": "2024-10-10 02:15:51"
   }
   ```

## Ejemplo de Uso

```plaintext
Bienvenido al Conversor de Monedas
******************************
Menú de Conversión de moneda
1) Dólar (USD) >> Sol Peruano (PEN)
2) Sol Peruano (PEN) >> Dólar (USD)
3) Dólar (USD) >> Peso Uruguayo (UYU)
4) Peso Uruguayo (UYU) >> Dólar (USD)
5) Dólar (USD) >> Real Brasileño (BRL)
6) Real Brasileño (BRL) >> Dólar (USD)
7) Salir
******************************
Escoja una opción: 1
Ingrese el monto a convertir: 50
El cambio de 50.0 [USD] >> Tiene un valor de 186.24 [PEN]
¿Desea realizar otra conversión? (s/n): n
El sistema finalizará....!
```
