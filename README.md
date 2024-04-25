# Dhemax-backend
Para poder levantar este proyecto se necesita lo siguiente:

Java v17.0.10 Maven v3.9.6 (Para instalar correctamentamente lo anterior se puede seguir el siguiente tutorial https://dev.to/vanessa_corredor/instalar-manualmente-maven-en-windows-10-50pb)

Este proyecto se realizó con: Spring tool suite v4.22.0.RELEASE Spring boot v3.2.5 PostgreSql v16.2.1 PgAdmin 4 v8.2 Postman

Una vez instalado PostgreSql con PgAdmin4, crear una base de datos llamada "electromobility" y ejecutar el siguiente script:

CREATE SEQUENCE charge_points_seq;

CREATE TABLE charge_points ( id integer NOT NULL DEFAULT nextval('charge_points_seq'), status VARCHAR ( 255 ), operator VARCHAR ( 255 ), connections INT, latitude VARCHAR ( 255 ), longitude VARCHAR ( 255 ), country VARCHAR ( 255 ), power INT );

ALTER SEQUENCE charge_points_seq OWNED BY charge_points.id;

En el archivo ubicado en src/main/resources/application.properties se puede modificar la conexión a la base de datos como prefiera (por defecto contiene los datos utilizados para esta prueba).

Posteriormiente abrir Spring Tools Suite, abrir el proyecto recién descargado y ejecutar como "Spring boot app". Luego con Postman realizar las pruebas a los distintos endpoint. Se pueden importar los siguientes curl para facilitar las pruebas con postman si lo desea.

curl --location 'http://localhost:8080/chargePoints'
--header 'Content-Type: application/json'
--data '{ "status": "Operational", "operator": "Zunder", "connections": 3, "latitude": "40.37078785255551", "longitude": "-3.6417792639216486", "country": "Spain", "power": 10 }'

curl --location 'http://localhost:8080/chargePoints'

curl --location 'http://localhost:8080/bestChargingOption?latitude=30&longitude=40'

curl --location 'http://localhost:8080/chargePoints/1'
