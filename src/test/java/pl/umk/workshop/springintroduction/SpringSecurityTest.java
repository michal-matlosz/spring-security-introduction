package pl.umk.workshop.springintroduction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    /*
     * TIP: sprawdź dostępne metody wywołane na anyRequest(), jedna z nich zezwala na dostęp do /deposit/ bez autoryzacji
     */
    @Test
    void shouldReturn200WhenValidAuthenticationProvided() throws Exception {
        mockMvc.perform(delete("/deposit/1"))
                .andExpect(status().isOk());
    }
}
