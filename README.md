# Mini Quiz API – Backend

Spring Boot REST-API für die Mini Quiz Anwendung.

## Voraussetzungen

- Java 21 oder höher
- MariaDB 10.x oder höher (oder Docker)

## Datenbank starten

### Option A: Mit Docker (empfohlen)

```bash
docker-compose up -d
```

Die Datenbank ist dann unter `localhost:3306` erreichbar.

### Option B: Manuell (HeidiSQL oder MySQL CLI)

```sql
CREATE DATABASE miniquiz CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
CREATE USER 'quizuser'@'localhost' IDENTIFIED BY 'quizPasswort123';
GRANT ALL PRIVILEGES ON miniquiz.* TO 'quizuser'@'localhost';
FLUSH PRIVILEGES;
```

## Konfiguration

Die Datenbankverbindung wird in `src/main/resources/application.properties` konfiguriert:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/miniquiz
spring.datasource.username=quizuser
spring.datasource.password=quizPasswort123
```

Passe Benutzername und Passwort bei Bedarf an.

## Backend starten

```bash
./gradlew bootRun
```

Die API ist dann unter `http://localhost:8080` erreichbar.

## Endpunkte

| Methode | Endpunkt | Beschreibung |
|---|---|---|
| GET | `/api/categories` | Alle Kategorien mit Fortschritt |
| GET | `/api/categories/{id}/next-question` | Nächste unbeantwortete Frage |
| POST | `/api/questions/{id}/answer` | Antwort einreichen |

### Beispiel: Antwort einreichen

```bash
curl -X POST http://localhost:8080/api/questions/1/answer \
  -H "Content-Type: application/json" \
  -d '{"answerIndex": 1}'
```

## Seed-Daten

Beim Start werden automatisch Beispielfragen in 3 Kategorien eingefügt:

- **Sport** (3 Fragen)
- **Java Grundlagen** (3 Fragen)
- **Geografie** (3 Fragen)

## Technologien

- Java 25
- Spring Boot 3.5
- Hibernate / Spring Data JPA
- MariaDB
- Lombok
- Gradle