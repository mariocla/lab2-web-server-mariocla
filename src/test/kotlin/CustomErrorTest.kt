package es.unizar.webeng.lab2

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.assertj.core.api.Assertions.assertThat
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CustomErrorTest(@Autowired val restTemplate: TestRestTemplate){

    @Test
    fun `nonexistent endpoint returns custom error page`() {
        val headers = org.springframework.http.HttpHeaders()
        headers.accept = listOf(org.springframework.http.MediaType.TEXT_HTML)

        val entity = org.springframework.http.HttpEntity<String>(headers)

        val response = restTemplate.exchange(
            "/endpoint-que-no-existe",
            org.springframework.http.HttpMethod.GET,
            entity,
            String::class.java
        )

        assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        assertThat(response.body).contains("Lo sentimos")
        assertThat(response.body).contains("404")
    }
}
