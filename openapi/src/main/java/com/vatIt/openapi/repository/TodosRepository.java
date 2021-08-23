package com.vatIt.openapi.repository;

import com.vatIt.openapi.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosRepository extends JpaRepository<Todos,Long> {
   Todos findById(String code);

    void deleteById(String id);
}
