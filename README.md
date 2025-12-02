🧿 README — Inventory API (Spring Boot + MongoDB + JWT)
📌 Descripción del proyecto

Inventory API es un backend desarrollado con Spring Boot 3.5, Java 21 y MongoDB, diseñado para gestionar productos y usuarios a través de una API RESTful moderna.
Implementa autenticación JWT, validación de usuarios y CRUD completo de productos.

Este proyecto sirve como base para aprender a construir APIs seguras, rápidas y escalables usando Spring Boot + MongoDB + JWT.

🛠️ Tecnologías utilizadas

Java 21

Spring Boot 3.5.8

spring-boot-starter-web

spring-boot-starter-data-mongodb

spring-boot-starter-security

spring-boot-starter-validation

JWT (JSON Web Token)

jjwt-api / jjwt-impl / jjwt-jackson (0.12.5)

MongoDB + MongoDB Compass

Lombok

Postman (para pruebas)

📁 Estructura del proyecto
src
 └── main
      └── java
          └── com.api.inventory.inventoryapi
              ├── auth
              │    ├── AuthController.java
              │    ├── AuthService.java
              │    ├── LoginRequest.java
              │    ├── RegisterRequest.java
              │    └── AuthResponse.java
              ├── config
              │    ├── SecurityConfig.java
              │    └── JwtAuthFilter.java
              ├── controller
              │    ├── HelloController.java
              │    └── ProductController.java
              ├── jwt
              │    └── JwtService.java
              ├── model
              │    └── Product.java
              ├── repository
              │    └── ProductRepository.java
              ├── service
              │    └── ProductService.java
              └── user
                   ├── User.java
                   └── UserRepository.java

⚙️ Instalación y configuración
1. Clonar repositorio
git clone https://github.com/tuusuario/inventoryapi.git
cd inventoryapi

2. Configurar MongoDB

Asegúrate de que MongoDB esté corriendo en:

mongodb://localhost:27017


La base de datos se creará automáticamente.

3. Configuración en application.properties
spring.application.name=inventoryapi

spring.data.mongodb.uri=mongodb://localhost:27017/inventoryapi

jwt.secret=TU_LLAVE_EN_BASE64_AQUI
jwt.expiration-ms=86400000


Puedes generar una clave Base64 así:

openssl rand -base64 32

4. Ejecutar el proyecto
mvn spring-boot:run

🔐 Autenticación JWT

Este proyecto usa JSON Web Tokens para proteger los endpoints.

➤ Flujo completo

Registrar usuario → recibe token

Login → recibe token

Usar token en:

Authorization: Bearer <token>


Acceder a endpoints protegidos (/api/products/**)

📡 Endpoints de autenticación
🔹 Registrar usuario
POST /api/auth/register

Body:
{
  "username": "kevin",
  "password": "123456"
}

Respuesta:
{
  "token": "eyJhb..."
}

🔹 Login de usuario
POST /api/auth/login

Body:
{
  "username": "kevin",
  "password": "123456"
}

Respuesta:
{
  "token": "eyJhb..."
}

📦 Endpoints de productos (PROTEGIDOS)

Requieren:

Authorization: Bearer <token>

📘 Obtener todos los productos
GET /api/products

📘 Obtener producto por ID
GET /api/products/{id}

📘 Crear producto
POST /api/products

Body:
{
  "name": "Laptop Lenovo",
  "description": "Línea profesional",
  "price": 950,
  "quantity": 5
}

📘 Actualizar producto
PUT /api/products/{id}

📘 Eliminar producto
DELETE /api/products/{id}

🚀 Probar en Postman
1. Registrar o hacer login

Obtener token.

2. En cualquier endpoint protegido, agregar:

Header:

Authorization: Bearer <token>
Content-Type: application/json

3. Enviar petición → Si el token es válido, funciona.

Si no, devuelve 401 Unauthorized.

👤 Roles

El modelo User incluye un campo:

role: "USER" o "ADMIN"


(El control de roles se puede extender fácilmente).

🧪 Tests

Incluye dependencias para:

spring-boot-starter-test

spring-security-test

Puede ampliarse según se agreguen más funciones.

📈 Mejoras futuras

Implementar DTOs para request/response

Documentación con Swagger/OpenAPI

Endpoint /profile para obtener datos del usuario autenticado

Manejo global de errores (@ControllerAdvice)

❤️ Autor

Proyecto desarrollado por Kevin Alvarado para practicar y dominar:

Spring Boot

MongoDB

Seguridad con JWT

Buenas prácticas de diseño REST
