package com.shrawin.todo.ToDoApp.ToDoWebServices;


import com.shrawin.todo.ToDoApp.Beans.TodoBean;
import com.shrawin.todo.ToDoApp.Services.ToDoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoController {

    @Autowired
    ToDoHardCodedService toDoHardCodedService;

    @GetMapping("/users/{userName}/todos")
    public List<TodoBean> geAllTodos (String userName){
        return toDoHardCodedService.findAll();
    }

    @GetMapping("/users/{userName}/todos/{id}")
    public TodoBean findToDo(@PathVariable String userName, @PathVariable long id){
        TodoBean todoBean = toDoHardCodedService.findById(id);

        if(todoBean != null){
            return todoBean;
        }
        return null;
    }

    @DeleteMapping("/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable String userName, @PathVariable long id){
        TodoBean todoBean = toDoHardCodedService.deleteById(id);

        if(todoBean != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{userName}/todos/{id}")
    public ResponseEntity<TodoBean> updateToDo(@PathVariable String userName, @PathVariable long id, @RequestBody TodoBean todoBean) {
        TodoBean todoUpdated = toDoHardCodedService.save(todoBean);

        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/users/{userName}/todos")
    public ResponseEntity<TodoBean> updateToDo(@PathVariable String userName, @RequestBody TodoBean todoBean) {
        TodoBean createdToDo = toDoHardCodedService.save(todoBean);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdToDo.getId()).toUri();


        return ResponseEntity.created(uri).build();
    }

}
