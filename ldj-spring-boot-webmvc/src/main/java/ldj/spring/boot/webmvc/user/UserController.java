package ldj.spring.boot.webmvc.user;


import org.springframework.web.bind.annotation.*;

@RestController //@ResponseBody를 생략 가능 @Controller는 @ResponseBody는 사용해야한다. 안쓰면 뷰리졸브로 타게 된다.
public class UserController {

    @GetMapping("/hello")
    public  String hello(){
        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return user;
    }
}
