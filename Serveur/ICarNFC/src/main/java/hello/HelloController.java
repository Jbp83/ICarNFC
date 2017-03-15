package hello;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/toto")
    public String index2() {
        return "tg toto";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/post/UserID")
    public String testPost(@RequestParam int userid){

        return "youpi : " + userid;
    }
    
}
