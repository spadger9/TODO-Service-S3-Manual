package com.shrawin.todo.ToDoApp.Services;

import com.shrawin.todo.ToDoApp.Beans.TodoBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoHardCodedService {

    private static List<TodoBean> todos = new ArrayList();
    private static int counter = 0;

    static {
        todos.add(new TodoBean(++counter, "shrawin", "Learn Drinking Alcohol", new Date(), false));
        todos.add(new TodoBean(++counter, "shrawin", "Learn to Sing Rhapsody", new Date(), false));
        todos.add(new TodoBean(++counter, "shrawin", "Be Awesome", new Date(), false));
        todos.add(new TodoBean(++counter, "shrawin", "Don't suck", new Date(), false));
        todos.add(new TodoBean(++counter, "shrawin", "Find who created virus", new Date(), false));
        todos.add(new TodoBean(++counter, "shrawin", "Running out of ideas", new Date(), false));
    }

    public List<TodoBean> findAll(){
        return todos;
    }

    public TodoBean deleteById(long id){
        TodoBean todoBean = findById(id);

        if (todoBean == null) return null;
        if(todos.remove(todoBean)) {
            return todoBean;
        }
        return null;
    }

    public TodoBean save(TodoBean todoBean){
        if (todoBean.getId() < 1){
            todoBean.setId(++counter);
            todos.add(todoBean);
        }
        else{
            deleteById(todoBean.getId());
            todos.add(todoBean);
        }
        return todoBean;
    }

    public TodoBean findById(long id) {
        for (TodoBean todoBean : todos) {
            if (todoBean.getId() == id) {
                return todoBean;
            }
        }
        return null;
    }
    }
