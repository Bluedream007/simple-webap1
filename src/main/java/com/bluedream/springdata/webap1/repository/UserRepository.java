package com.bluedream.springdata.webap1.repository;

import com.bluedream.springdata.webap1.model.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    List<Users> findAllBy();

    public Users findByName(String name);

    @EntityGraph(attributePaths = {"roles"})
    List<Users> findAll();

}