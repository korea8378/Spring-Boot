package ldj.spring.boot.test;

import ldj.spring.boot.test.controller.SampleController;
import ldj.spring.boot.test.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
//@JsonTest
public class ApplicationTests {

//    @Autowired
//    MockMvc mockMvc;

//    @Autowired
//    TestRestTemplate testRestTemplate;

    @Autowired
    WebTestClient webTestClient; //asynchronous(비동기화) 기본적인 사용하는 restController는 synchronous(동기화)

    @MockBean
    SampleService mockSampleService; //controller만 test하고싶을때 service를 MockBean을 만들어준다.

//    @Test
//    public void hello() throws Exception {
//        mockMvc.perform(get("/hello"))    //mockMVC에서 /hello를 요청 할 경우
//                .andExpect(status().isOk())   //http상태코드가 200이면
//                .andExpect(content().string("hellodongjun")) /반환되는 콘텐츠 내용이 hellodongjun인지
//                .andDo(print());   //요청이 왔다는 걸 출력한다.
//    }

//    @Autowired
//    JacksonTester<실험할 도메인>

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("dongjun");//MockService에 요청한 메소드의 반환값을 설정

//        String result = testRestTemplate.getForObject("/hello", String.class);
//                assertThat(result).isEqualTo("hellodongjun");
        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("hellodongjun");
    }

}
