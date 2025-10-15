# Lab 2 Web Server -- Project Report

## Description of Changes
- **Custom Error Page**: Implemented an `error.html` page in `src/main/resources/templates` to replace the Spring Boot Whitelabel page. It shows a custom message "Sorry! The page you are looking for does not exist or an unexpected error happened." and a dynamic status code.
- **New Endpoint `/time`**:  
  - Created `TimeDTO` to represent the current time.  
  - Defined the `TimeProvider` interface to decouple the logic of getting the time.  
  - Implemented `TimeService` as a time provider with `@Service`.  
  - Added a REST controller (`TimeController`) that exposes the `/time` endpoint and returns JSON with the current time.
- **Extension Function**: Added the extension function `LocalDateTime.toDTO()` to map easily to `TimeDTO`.
- **SSL + HTTP/2**:  
  - Generated a self-signed certificate with OpenSSL.  
  - Created the keystore `localhost.p12` and configured it in `application.yml`.  
  - Enabled HTTP/2 and SSL on port `8443`.  
  - Created an `application-test.yml` so tests run without SSL, and added `@ActiveProfiles("test")` in the tests.
- **Testing**:  
  - Integration test for a non-existing endpoint → checks that it returns `error.html`.  
  - Integration test for `/time` → checks that it returns `200 OK` and not the error page.  

## Technical Decisions
- **TestRestTemplate** was used for integration tests with the embedded server.  

## Learning Outcomes
- I learned how to customize error pages in Spring Boot using **Thymeleaf**.  
- I practiced creating **REST controllers** with Spring Boot and serializing Kotlin objects to JSON.  
- I learned how to generate and configure a **self-signed certificate** and enable **SSL/HTTP/2** in Spring Boot.  
- I understood the importance of **integration tests** that check both status codes and response content.  

## AI Disclosure
### AI Tools Used
- ChatGPT (OpenAI GPT-5)

### AI-Assisted Work
- Help with the first integration tests for `/time` and non-existing endpoints.  
- Support in creating the `error.html` page.  
- Approximate AI assistance: **25%**.  
- The generated parts were **manually adapted** to fit the project and fix problems.  

### Original Work
- Manual implementation of the `/time` endpoint, DTO, interface, and dependency injection.  
- Configuration of SSL and HTTP/2 in `application.yml` with a locally generated certificate.  
- Running, debugging, and fixing the tests until getting `BUILD SUCCESSFUL`.  
- Final writing of this report, combining what I learned and the technical decisions made.  
