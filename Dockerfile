# Temurin JDK 17을 포함하는 Alpine Linux 기반 이미지를 사용합니다.
FROM openjdk:17-jdk-slim-buster

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일을 /app.jar로 컨테이너 내부에 복사
COPY build/libs/backend-0.0.1-SNAPSHOT.jar build/libs/backend-0.0.1-SNAPSHOT.jar


# 컨테이너가 시작될 때 자바 애플리케이션을 실행합니다.
ENTRYPOINT ["java","-jar","build/libs/backend-0.0.1-SNAPSHOT.jar"]
