package pl.umk.workshop.springintroduction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    /*
     * TIP: zmodyfikuj UserDetailsService
     */
    void shouldReturn200WhenValidAuthenticationProvided() throws Exception {
        mockMvc.perform(delete("/deposit/1")
                        .header("Authorization", "Basic dXNlcjpwYXNzd29yZA==")
                )
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn200WhenValidCredentialsProvidedToLogin() throws Exception {
        mockMvc.perform(post("/login")
                        .param("username", "user")
                        .param("password", "password")
                )
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void shouldReturn401WhenInvalidCredentialsProvidedToLogin() throws Exception {
        mockMvc.perform(post("/login")
                        .param("username", "user")
                        .param("password", "wrongpassword")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error"));
    }
}
