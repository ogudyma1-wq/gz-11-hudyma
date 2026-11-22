# Приклади запитів — Заняття 1.1 (MovieStore)

Бекенд має бути запущений: `mvn spring-boot:run` (порт 8080).

На цьому занятті лише **два GET-ендпоінти**.

## 1. Перелік фільмів (картки)

```bash
curl http://localhost:8080/api/movies
```

Очікувана відповідь (скорочено):
```json
[
  { "id": 1, "title": "Тіні забутих предків", "director": "Сергій Параджанов",
    "price": 180.00, "posterUrl": "/posters/shadows.jpg" },
  { "id": 2, "title": "Земля", "director": "Олександр Довженко",
    "price": 150.00, "posterUrl": "/posters/zemlia.jpg" }
]
```

З `jq` для зручного виводу:
```bash
curl -s http://localhost:8080/api/movies | jq
```

## 2. Один фільм з деталями

```bash
curl http://localhost:8080/api/movies/1
```

Очікувана відповідь:
```json
{
  "id": 1,
  "title": "Тіні забутих предків",
  "director": "Сергій Параджанов",
  "price": 180.00,
  "year": 1965,
  "durationMinutes": 97,
  "genre": "Драма",
  "posterUrl": "/posters/shadows.jpg",
  "description": "Поетична драма за повістю Михайла Коцюбинського про кохання гуцула Івана і Марічки в Карпатах."
}
```

## 3. Неіснуючий фільм → 404

```bash
curl -i http://localhost:8080/api/movies/999
```

Очікувано: перший рядок відповіді `HTTP/1.1 404`.
