```markdown
# Proyecto de cálculo de fecha de pago de nómina

Este proyecto de Spring Boot está diseñado para calcular la próxima fecha de pago de nómina basándose en las reglas especificadas para Colombia, considerando días hábiles y festivos.

## Descripción

El proyecto utiliza Spring Boot para crear un servicio web RESTful que permite calcular la próxima fecha de pago de nómina basándose en una fecha de entrada dada por el usuario. Se asegura de que la fecha de pago calculada no caiga en días festivos colombianos, sábados ni domingos, ajustándola al día hábil más cercano anterior si es necesario.

## Tecnologías utilizadas

- Java
- Spring Boot
- JSON-Simple (para cargar festivos desde un archivo JSON)

## Configuración

Para ejecutar el proyecto localmente, asegúrate de tener instalado:

- Java JDK
- IDE como IntelliJ IDEA o Eclipse (opcional)
- Maven (opcional si usas IntelliJ IDEA o Eclipse)

### Pasos para ejecutar

1. Clona este repositorio o descarga el código fuente.
2. Importa el proyecto en tu IDE.
3. Configura las dependencias si es necesario.
4. Ejecuta la clase principal `Application.java` para iniciar la aplicación Spring Boot.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes hacer solicitudes HTTP GET al siguiente endpoint para obtener la próxima fecha de pago de nómina:

```
GET http://localhost:8080/nextPayDate/{fecha}

Ejemplo de solicitud:
GET http://localhost:8080/nextPayDate/2024-03-30

Respuesta esperada:
200 OK
2024-03-27
```

Reemplaza `{fecha}` con la fecha en formato `yyyy-mm-dd` para la cual deseas calcular la próxima fecha de pago.

## Ejemplos de uso

```bash
# Calcular la próxima fecha de pago para el 30 de marzo de 2024
curl -X GET http://localhost:8080/nextPayDate/2024-03-30
```

## Contribuciones

Las contribuciones son bienvenidas. Si encuentras algún problema o tienes sugerencias de mejora, no dudes en crear un issue o enviar un pull request.

## Autor

- Jhon Arcila Castano
- Enlace a tu perfil en GitHub https://github.com/JhonCodeU