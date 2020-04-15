package com.shrawin.todo.ToDoApp.helloworld.helloController;


import com.shrawin.todo.ToDoApp.helloworld.helloBean.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeController {

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        //throw new RuntimeException("Error in the services. Please go drink margarita!");
        return new HelloWorldBean("Hello Dumb World");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){

        return new HelloWorldBean(String.format("Hello Dumb World and %s", name));
    }
}
