# Conversor-De-Monedas

## Descripción
Este proyecto es un conversor de divisas desarrollado en Java que permite a los usuarios convertir cantidades de una moneda a otra utilizando tasas de cambio actualizadas. La aplicación se conecta a la API de ExchangeRate para obtener las tasas de conversión en tiempo real, lo que garantiza que los cálculos sean precisos y actualizados.

## Características
- **Conversión de Monedas**: Convierte entre varias divisas, incluyendo el Peso Mexicano (MXN), Dólar (USD), Euro (EUR), y más.
- **Historial de Conversiones**: Guarda un historial de conversiones realizadas, mostrando la fecha y las cantidades convertidas.
- **Interfaz de Menú**: Utiliza una interfaz de línea de comandos que guía al usuario a través del proceso de selección de monedas y entrada de datos.
- **Manejo de Errores**: Implementa manejo de excepciones para garantizar una experiencia de usuario fluida.

## Estructura del Proyecto
El proyecto está compuesto por las siguientes clases principales:

- **Principal**: Clase principal que ejecuta la aplicación y gestiona la interacción del usuario.
- **ConsultaDivisa**: Clase que realiza consultas a la API de ExchangeRate para obtener las tasas de cambio.
- **Divisas**: Clase que representa la información de una tasa de cambio de una moneda base.
- **Calculos**: Clase que contiene los métodos para realizar conversiones entre monedas.
- **Registro**: Clase que gestiona el historial de conversiones realizadas por el usuario.
- **Menu**: Clase que proporciona una interfaz de menú para seleccionar monedas.

## Requisitos
- Java 11 o superior
- Dependencia de Gson para el parseo de JSON.

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/EduardoCruzAlejandro/Conversor-De-Monedas.git


