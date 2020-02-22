.PHONY: run integration-test

-include .env
export

run-localstack:
	docker-compose -f docker-compose.yml up

integration-test:
	./gradlew clean integrationTest