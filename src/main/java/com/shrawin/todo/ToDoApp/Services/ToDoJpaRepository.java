package com.shrawin.todo.ToDoApp.Services;

import com.shrawin.todo.ToDoApp.Beans.TodoBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoJpaRepository extends JpaRepository<TodoBean, Long> {
   List<TodoBean> findByUserName(String userName);

}
