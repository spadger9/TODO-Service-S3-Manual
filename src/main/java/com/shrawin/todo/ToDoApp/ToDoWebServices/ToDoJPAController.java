package com.shrawin.todo.ToDoApp.ToDoWebServices;


import com.shrawin.todo.ToDoApp.Beans.TodoBean;
import com.shrawin.todo.ToDoApp.Services.ToDoHardCodedService;
import com.shrawin.todo.ToDoApp.Services.ToDoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoJPAController {

    @Autowired
    ToDoHardCodedService toDoHardCodedService;

    @Autowired
    ToDoJpaRepository toDoJpaRepository;

   /* @GetMapping("/jpa/users/{userName}/todos")
    public List<TodoBean> geAllTodos (String userName){
        return toDoJpaRepository.findByUserName(userName);
    }*/

    @GetMapping("/jpa/users/{userName}/todos")
    public List<TodoBean> getAllTodos(@PathVariable String userName){
        System.out.println("User name: " + userName);
        return toDoJpaRepository.findByUserName(userName);
        //return todoService.findAll();
    }

    @GetMapping("/jpa/users/{userName}/todos/{id}")
    public TodoBean findToDo(@PathVariable String userName, @PathVariable long id){
        TodoBean todoBean = toDoJpaRepository.findById(id).get();

        if(todoBean != null){
            return todoBean;
        }
        return null;
    }

    @DeleteMapping("/jpa/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable String userName, @PathVariable long id){
        toDoJpaRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/jpa/users/{userName}/todos/{id}")
    public ResponseEntity<TodoBean> updateToDo(@PathVariable String userName, @PathVariable long id, @RequestBody TodoBean todoBean) {
        TodoBean todoUpdated = toDoJpaRepository.save(todoBean);

        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{userName}/todos")
    public ResponseEntity<TodoBean> createToDo(@PathVariable String userName, @RequestBody TodoBean todoBean) {
        todoBean.setUserName(userName);
        TodoBean createdToDo = toDoJpaRepository.save(todoBean);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdToDo.getId()).toUri();


        return ResponseEntity.created(uri).build();
    }

}
