package services;


import org.springframework.web.bind.annotation.*;


@RestController
public interface icarService {



    @RequestMapping(method = RequestMethod.POST,value = "/post/UserID")
    public String testPost(@RequestParam int userid);

    @RequestMapping(method = RequestMethod.POST, value ="/login")
    String getInfos(@RequestParam String UserLogin, @RequestParam String UserPassword);

}
