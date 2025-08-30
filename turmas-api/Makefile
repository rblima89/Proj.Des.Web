.PHONY: run clean db-up db-down

run:
	mvn -U clean spring-boot:run

clean:
	mvn clean

db-up:
	docker compose up -d

db-down:
	docker compose down
