package com.is.findyourplace.Unit;
import org.junit.jupiter.api.Test;
import com.is.findyourplace.FindYourPlaceApplication;
import com.is.findyourplace.persistence.dto.UtenteDto;
import com.is.findyourplace.service.gestioneUtenza.AccountService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FindYourPlaceApplication.class )
@AutoConfigureMockMvc()
public class TF1Test {
    @MockBean
    private AccountService accountService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegistration() throws Exception {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNome("testnome");
        utenteDto.setCognome("testcognome");
        utenteDto.setDataNascita(LocalDate.of(1998, 3,2));
        utenteDto.setUsername("testuser");
        utenteDto.setEmail("test@example.com");
        utenteDto.setPassword("Testpassword1!");

        Mockito.when(accountService.existsByUsername("testuser")).thenReturn(false);
        Mockito.when(accountService.existsByEmail("test@example.com")).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .flashAttr("utenteR", utenteDto))
                .andExpect(MockMvcResultMatchers.status().is(201));
    }
    @Test
    public void testRegistrationNullName() throws Exception {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setCognome("testcognome");
        utenteDto.setDataNascita(LocalDate.of(1998, 3,2));
        utenteDto.setUsername("testuser");
        utenteDto.setEmail("test@example.com");
        utenteDto.setPassword("Testpassword1!");

        Mockito.when(accountService.existsByUsername("testuser")).thenReturn(false);
        Mockito.when(accountService.existsByEmail("test@example.com")).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .flashAttr("utenteR", utenteDto))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
    @Test
    public void testRegistrationNullSurname() throws Exception {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNome("testnome");
        utenteDto.setDataNascita(LocalDate.of(1998, 3,2));
        utenteDto.setUsername("testuser");
        utenteDto.setEmail("test@example.com");
        utenteDto.setPassword("Testpassword1!");

        Mockito.when(accountService.existsByUsername("testuser")).thenReturn(false);
        Mockito.when(accountService.existsByEmail("test@example.com")).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .flashAttr("utenteR", utenteDto))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
    @Test
    public void testRegistrationNullDate() throws Exception {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNome("testnome");
        utenteDto.setCognome("testcognome");
        utenteDto.setUsername("testuser");
        utenteDto.setEmail("test@example.com");
        utenteDto.setPassword("Testpassword1!");

        Mockito.when(accountService.existsByUsername("testuser")).thenReturn(false);
        Mockito.when(accountService.existsByEmail("test@example.com")).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .flashAttr("utenteR", utenteDto))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
    @Test
    public void testRegistrationNullUsername() throws Exception {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNome("testnome");
        utenteDto.setCognome("testcognome");
        utenteDto.setDataNascita(LocalDate.of(1998, 3,2));
        utenteDto.setEmail("test@example.com");
        utenteDto.setPassword("Testpassword1!");

        Mockito.when(accountService.existsByUsername("testuser")).thenReturn(false);
        Mockito.when(accountService.existsByEmail("test@example.com")).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .flashAttr("utenteR", utenteDto))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
    @Test
    public void testRegistrationNullEmail() throws Exception {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNome("testnome");
        utenteDto.setCognome("testcognome");
        utenteDto.setDataNascita(LocalDate.of(1998, 3,2));
        utenteDto.setUsername("testuser");
        utenteDto.setPassword("Testpassword1!");

        Mockito.when(accountService.existsByUsername("testuser")).thenReturn(false);
        Mockito.when(accountService.existsByEmail("test@example.com")).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .flashAttr("utenteR", utenteDto))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
    @Test
    public void testRegistrationNullPassword() throws Exception {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNome("testnome");
        utenteDto.setCognome("testcognome");
        utenteDto.setDataNascita(LocalDate.of(1998, 3,2));
        utenteDto.setUsername("testuser");
        utenteDto.setEmail("test@example.com");

        Mockito.when(accountService.existsByUsername("testuser")).thenReturn(false);
        Mockito.when(accountService.existsByEmail("test@example.com")).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .flashAttr("utenteR", utenteDto))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
    

}