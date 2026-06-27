# ELK setup for the Spring Boot project

This project now has a ready-to-use ELK stack setup with:
- Elasticsearch for log storage
- Kibana for log visualization
- Filebeat for shipping logs from the Spring Boot app
- Your existing PostgreSQL instance for the Spring Boot app database

## 1. Prerequisites

Install Docker Desktop and make sure it is running.

## 2. Start the ELK stack

From the project root:

```bash
docker compose -f src/main/resources/docker-compose-efk.yml up -d
```

## 3. Start the Spring Boot application

In a second terminal:

```bash
./mvnw spring-boot:run
```

## 4. Generate logs

Trigger the application to produce logs by calling the endpoint:

```bash
curl -X POST "http://localhost:8082/orders?product=book&quantity=2"
```

You can also hit the app repeatedly to create more log entries.

## 5. Check the ELK services

- Elasticsearch: http://localhost:9200
- Kibana: http://localhost:5601

## 6. Open Kibana and create the index pattern

1. Open http://localhost:5601
2. Go to Stack Management -> Index Patterns
3. Create an index pattern:
   - Name: springboot-logs-*
4. Select a time field such as @timestamp
5. Save the pattern

## 7. View the logs

Open Discover in Kibana and select the index pattern to see your application logs.

## 8. Import a simple dashboard (optional)

1. In Kibana, go to Stack Management -> Saved Objects
2. Click Import
3. Select the file:
   - src/main/resources/kibana/springboot-logs-dashboard.ndjson
4. Import it and open the dashboard from the Dashboard page

## 9. Stop everything

```bash
docker compose -f src/main/resources/docker-compose-efk.yml down
```
