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
class TimeControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `time endpoint returns current time`() {
        val response = restTemplate.getForEntity("/time", TimeDTO::class.java)
        
        assertThat(response.statusCodeValue).isEqualTo(200)
        assertThat(response.body).isNotNull

        val now = response.body!!.time
        assertThat(now).isBeforeOrEqualTo(java.time.LocalDateTime.now())
    }
}
