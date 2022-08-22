package com.example.springwebservice.model;

import com.example.springwebservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);
    Long deleteById(int id);

//    List<User>findByAgeGreaterThanEqual(int age);
//    List<User>findByOrderByAgeDesc();
//    List<User>findByOrderByAgeAsc();
//
//    @Query(value = "SELECT * FROM member WHERE name= ?1 AND age= ?2",nativeQuery = true)
//    List<User> findByNameAndAge(String name,int age);
//
//    @Modifying
//    @Query(value= "INSERT INTO member VALUES(?1,?2,?3)",nativeQuery = true)
//    @Transactional
//    void createUserBySql(int id,String name,int age);
//
//
//    @Modifying
//    @Query(value = "UPDATE member SET name = ?1,age = ?2 WHERE id =?3",nativeQuery = true)
//    @Transactional
//    void updateUserBySql(String name,int age,int id);
//    int updateUserBySql(String name,int age,int id);

//    @Modifying
//    @Query(value = "DELETE FROM member WHERE name =?1 AND age = ?2",nativeQuery = true)
//    @Transactional
//    void deleteUserBySql(String name,int age);
}
