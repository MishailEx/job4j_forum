package ru.job4j.forum.control;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class IndexControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void login() throws Exception {
        this.mockMvc.perform(formLogin().user("aaa").password("aaa"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    @WithMockUser
    public void shouldReturnLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void postGetIdExists() throws Exception {
        this.mockMvc.perform(get("/post").param("id", "1"))
                .andDo(print())
                .andExpect (status (). isOk ())
                .andExpect (model (). attributeExists ("post"))
                .andExpect(view().name("post/post"));
    }

    @Test
    @WithMockUser
    public void postGetIdNotExists() throws Exception {
        this.mockMvc.perform(get("/post").param("id", "0"))
                .andDo(print())
                .andExpect (status (). isOk ())
                .andExpect (model ().attributeDoesNotExist("post"))
                .andExpect(view().name("post/edit"));
    }

    @Test
    @WithMockUser
    public void editGet() throws Exception {
        this.mockMvc.perform(get("/edit").param("id", "1"))
                .andDo(print())
                .andExpect (status (). isOk ())
                .andExpect (model (). attributeExists ("post"))
                .andExpect(view().name("post/edit"));
    }

    @Test
    @WithMockUser
    public void shouldReturnRegPage() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

}