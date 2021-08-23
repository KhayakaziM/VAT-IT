package com.vatIt.openapi.service;

import com.vatIt.openapi.entity.Todos;

import java.util.List;


public interface TodosService  {

    List<Todos> getAllTodos();
    Todos addTodo(Todos todos);

    Todos updateTodo(String id, Todos todos);

    void deleteTodo(String id);

    Todos getTodosId(String code);
}
