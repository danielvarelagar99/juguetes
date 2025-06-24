# Etapa 1: Compilación del proyecto
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el proyecto completo al contenedor
COPY . .

# Compilamos el proyecto sin ejecutar tests
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con JAR generado
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiamos el JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto 8080 (puerto por defecto de Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]