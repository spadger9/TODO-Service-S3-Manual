package authentication;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {

    @GetMapping("/basicAuth")
    public BasicAuthenticationBean helloWorldBean(){
        //throw new RuntimeException("Error in the services. Please go drink margarita!");
        return new BasicAuthenticationBean("You are authenticated.");
    }

   /* @GetMapping("/hello-world-bean/{name}")
    public BasicAuthenticationBean helloWorldBean(@PathVariable String name){

        return new BasicAuthenticationBean(String.format("Hello Dumb World and %s", name));
    }*/
}

