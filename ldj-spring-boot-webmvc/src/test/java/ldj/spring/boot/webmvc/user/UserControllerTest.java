package ldj.spring.boot.webmvc.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"dongjun\", \"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)//어떠한 데이터형식으로 보낼지
                .accept(MediaType.APPLICATION_JSON_UTF8)//어떠한 응답으로 받을지
                .content(userJson))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.username",
                            is(equalTo("dongjun"))))
                    .andExpect(jsonPath("$.password",
                            is(equalTo("123"))));
    }

    @Test
    public void createUser_JSON2() throws Exception {
        String userJson = "{\"username\":\"dongjun\", \"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)//어떠한 데이터형식으로 보낼지
                .accept(MediaType.APPLICATION_XML)//어떠한 응답으로 받을지
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/name").string("dongjun"))
                .andExpect(xpath("/User/password").string("123"));
    }
}
