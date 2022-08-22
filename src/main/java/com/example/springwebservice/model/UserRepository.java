package com.example.springwebservice.model;

import com.example.springwebservice.model.entity.User;
import org.hibernate.sql.Select;
import org.springframework.boot.autoconfigure.websocket.servlet.UndertowWebSocketServletWebServerCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);

    Long deleteById(int id);

    List<User> findByAgeGreaterThanEqual(int age);



    @Query(value = "SELECT * FROM student WHERE name = ?1 and age = ?2", nativeQuery = true)
    List<User> findByNameAndAge(String name, int age);

    @Query(value = "INSERT INTO student VALUES (?1,?2,?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void createUserBySql(int id, String name, int age);

    @Query(value = "UPDATE student SET age = ?1,name = ?2 WHERE id = ?3", nativeQuery = true)
    @Modifying
    @Transactional
    void updateUserBySql(int age, String name, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM student WHERE name=?1 AND age=?2", nativeQuery = true)
    void DeleteByNameAge(String name, int age);
}
