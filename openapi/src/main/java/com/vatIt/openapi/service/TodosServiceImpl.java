package com.vatIt.openapi.service;

import com.vatIt.openapi.entity.Todos;
import com.vatIt.openapi.exception.ResourceNotFoundException;
import com.vatIt.openapi.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TodosServiceImpl implements TodosService{

   private TodosRepository todosRepository;
    @Autowired
    public TodosServiceImpl(TodosRepository todosRepository) {
       this.todosRepository= todosRepository;
    }

    @Override
    public List<Todos> getAllTodos() {
        return this.todosRepository.findAll();
    }

    //not done yet
    @Override
    public Todos addTodo(Todos todos) {
        Todos addTodos=new Todos();
        if(todos==null){
            throw new ResourceNotFoundException("request body empty for update" );
        }
        if(!todos.getName().trim().equalsIgnoreCase("")&& todos.getName()!=null){
            addTodos.setName(todos.getName());
        }else{
            throw new ResourceNotFoundException("product price is required");
        }
        if(todos.getCompleted()!=null){
            addTodos.setCompleted(todos.getCompleted());
        }else{

            throw new ResourceNotFoundException("Todo state is required" );
        }
        return todosRepository.save(addTodos);
    }

    @Override
    public Todos updateTodo(String id, Todos todos) {
        Todos findTodo = todosRepository.findById(id);
        if(todos==null){
            throw new ResourceNotFoundException("request body empty for update" );
        }
        if(findTodo!=null) {
            System.out.println(findTodo.toString());
            if(!todos.getName().trim().equalsIgnoreCase("") && todos.getName()!=null){
                findTodo.setName(todos.getName());
            }
            if(todos.getCompleted()!=null){
                findTodo.setCompleted(todos.getCompleted());
            }
           return  todosRepository.save(findTodo);
        }else{
            throw new ResourceNotFoundException("no Todo found with id:" +id);
        }
    }
    @Override
    public void deleteTodo(String id) {
        todosRepository.deleteById(id);
    }

    @Override
    public Todos getTodosId(String id) {
        return this.todosRepository.findById(id);
    }



}
