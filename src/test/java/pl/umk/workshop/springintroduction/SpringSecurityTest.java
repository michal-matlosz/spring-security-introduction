package pl.umk.workshop.springintroduction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    // Zadanie 1
    @Test
    void shouldReturn200WhenPostRequestSent() throws Exception {
        mockMvc.perform(post("/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"student": {"name:":"Jack", "surname": "Kowalsky"},"items": ["JACKET"]}
                                """))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn403() throws Exception {
        mockMvc.perform(delete("/deposit/1"))
                .andExpect(status().isForbidden());
    }

    // Zadanie 2
    @Test
    void shouldReturn200WhenValidAuthenticationProvided() throws Exception {
        mockMvc.perform(delete("/deposit/1"))
                .andExpect(status().isOk());
    }

    // Zadanie 3 - napisz test sprawdzający status 401 dla DELETE /deposit. Dokonaj odpowiedniej zmiany w konfiguracji

}
