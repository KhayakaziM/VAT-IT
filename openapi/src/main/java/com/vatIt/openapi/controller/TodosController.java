package com.vatIt.openapi.controller;

import com.vatIt.openapi.entity.Todos;
import com.vatIt.openapi.repository.TodosRepository;
import com.vatIt.openapi.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/components/schemas/")
public class TodosController {

    @Autowired
    private TodosService todosService;

    @GetMapping("todos")
    public ResponseEntity<List<Todos>> getAllTodos(){
        return ResponseEntity.ok().body(todosService.getAllTodos());
    }

    @DeleteMapping("todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") String id) {
        this.todosService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("todos")
    public ResponseEntity<Todos> addTodo(@RequestBody Todos todos){
        return ResponseEntity.ok().body(this.todosService.addTodo(todos));
    }

    @PutMapping("todos/{id}")
    public ResponseEntity<Todos> updateTodo(@PathVariable("id") String id,
                                            @RequestBody Todos todo) {
        return ResponseEntity.ok().body(this.todosService.updateTodo(id, todo));
    }


}
