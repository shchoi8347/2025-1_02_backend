package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    // 자동으로 save(), delete(), findById() 메소드 등이 자동으로 생성됨

    @Query(value = "select * from todo t where t.userId = ?1")
    public List<TodoEntity> findByUserId(String userId);

    List<TodoEntity> findByIdAndTitle(String id, String title);
    List<TodoEntity> findByTitle(String title);
}
